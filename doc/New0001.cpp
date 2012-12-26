
/*
file poll��wait_queue
file.f_ops.poll
poll/select/epoll��ʵ�ֶ��ǻ����ļ��ṩ��poll����(f_op->poll)��
�÷�������poll_table�ṩ��_qproc�������ļ��ڲ��¼�����_key��Ӧ�ĵ�һ�������ȴ�����(wait_queue_head_t)����Ӱ������Ѻ���(wait_queue_t.func)�Ľڵ�(wait_queue_t)��������ļ���ǰ������״̬���ظ�poll�ĵ�����(�������ļ���ʵ��)��
���ļ���״̬�����ı�ʱ(�����������ݰ�����)���ļ��ͻ�����¼���Ӧ�ĵȴ����в����ûص�����(wait_queue_t.func)���ѵȴ��̡߳�

ͨ����file.f_ops.pollʵ�ּ���ؽṹ������
*/


// �ļ���������Ӧ��file�ṹ
struct file {
    const struct file_operations	*f_op;
    spinlock_t			f_lock;
    // �ļ��ڲ�ʵ��ϸ��
    void			   *private_data;
#ifdef CONFIG_EPOLL
    /* Used by fs/eventpoll.c to link all the hooks to this file */
    struct list_head	f_ep_links;
    struct list_head	f_tfile_llink;
#endif /* #ifdef CONFIG_EPOLL */
    // ����ϸ��....
};

// �ļ�����
struct file_operations {
    // �ļ��ṩ��poll/select/epoll
    // ��ȡ�ļ���ǰ״̬, �Լ�����֪ͨ�ӿں���
    unsigned int (*poll) (struct file *, struct poll_table_struct *);
    // ��������read/write ��... ...
};

// ͨ����file.f_ops.poll ������ʵ��
unsigned int file_f_op_poll (struct file *filp, struct poll_table_struct *wait)
{
    unsigned int mask = 0;
    wait_queue_head_t * wait_queue;

    //1. �����¼�����wait->key_���ļ�ʵ��filep->private_data ȡ���¼������Ӧ��һ������wait queue head
    some_code();

    // 2. ����poll_wait ���õ�wait queue head ��ӽڵ�
    poll_wait(filp, wait_queue, wait);

    // 3. ȡ�õ�ǰ����״̬���浽mask
    some_code();

    return mask;
}

// select/poll/epoll ���ļ�ע�������ص��ڵ�Ľӿڽṹ
typedef struct poll_table_struct {
    // ��wait_queue_head ��ӻص��ڵ�(wait_queue_t)�Ľӿں���
    poll_queue_proc _qproc;
    // ��ע���¼�����, �ļ���ʵ�����ô����뽫�ȴ����д��ݸ�_qproc
    unsigned long   _key;
} poll_table;
typedef void (*poll_queue_proc)(struct file *, wait_queue_head_t *, struct poll_table_struct *);


// ͨ�õ�poll_wait ����, �ļ���f_ops->poll ͨ������ô˺���
static inline void poll_wait(struct file * filp, wait_queue_head_t * wait_address, poll_table *p)
{
    if (p && p->_qproc && wait_address) {
        // ����_qproc ��wait_address ����ӽڵ�ͻص�����
        // ���� poll_table_struct �ϵĺ���ָ����wait_address��ӽڵ�, �����ýڵ��func
        // (�����select��poll ���� __pollwait, ����� epoll ���� ep_ptable_queue_proc),
        p->_qproc(filp, wait_address, p);
    }
}


// wait_queue ͷ�ڵ�
typedef struct __wait_queue_head wait_queue_head_t;
struct __wait_queue_head {
    spinlock_t lock;
    struct list_head task_list;
};

// wait_queue �ڵ�
typedef struct __wait_queue wait_queue_t;
struct __wait_queue {
    unsigned int flags;
#define WQ_FLAG_EXCLUSIVE	0x01
    void *private;
    wait_queue_func_t func;
    struct list_head task_list;
};
typedef int (*wait_queue_func_t)(wait_queue_t *wait, unsigned mode, int flags, void *key);


// ���ļ���״̬�����ı�ʱ, �ļ�����ô˺������˺���ͨ������wait_queue_t.func֪ͨpoll�ĵ�����
// ����key���ļ���ǰ���¼�����
void __wake_up(wait_queue_head_t *q, unsigned int mode,
               int nr_exclusive, void *key)
{
    unsigned long flags;

    spin_lock_irqsave(&q->lock, flags);
    __wake_up_common(q, mode, nr_exclusive, 0, key);
    spin_unlock_irqrestore(&q->lock, flags);
}
static void __wake_up_common(wait_queue_head_t *q, unsigned int mode,
                             int nr_exclusive, int wake_flags, void *key)
{
    wait_queue_t *curr, *next;
    // ����������func ����, ͨ��func�ỽ�ѵ���poll���߳�
    list_for_each_entry_safe(curr, next, &q->task_list, task_list) {
        unsigned flags = curr->flags;

        if (curr->func(curr, mode, wake_flags, key) &&
                (flags & WQ_FLAG_EXCLUSIVE) && !--nr_exclusive) {
            break;
        }
    }
}






/*
poll �� select
poll��select��ʵ�ֻ�������һ�µģ�ֻ�Ǵ��ݲ���������ͬ�����ǵĻ����������£�

�����û����ݵ��ں˿ռ�
���Ƴ�ʱʱ��
����ÿ���ļ�������f_op->poll ȡ���ļ���ǰ����״̬, ���ǰ��������ļ���û�о���,���ļ�����wait_queue�ڵ�
��������������Ѿ��о������ļ�ת��6, ����������������źŲ���ת��3(����poll��select), ���������̵ȴ���ʱ����
��ʱ�򱻻��Ѻ��ٴα��������ļ�ȡ��ÿ���ļ��ľ���״̬
�������ļ��ľ���״̬���Ƶ��û��ռ�
�����������Դ

������poll/select���õĽṹ�弰����ع���:

poll_wqueues:
   select/poll ��poll_table�ӿڵľ��廯ʵ��,���е�table, inline_index��inline_entries����Ϊ�˹����ڴ档
poll_table_entry:
   ��һ���ļ������, ��poll_table_entry�Ͽ��Եõ��ļ�filp, �ļ��ȴ�����wait_address,���ڵȴ����¼�����key�Լ����뵽�ļ��ȴ����еĽڵ�wait,


*/
// select/poll ��poll_table�ľ��廯ʵ��
struct poll_wqueues {
    poll_table pt;
    struct poll_table_page *table;     // ���inline_entries �ռ䲻��, ��poll_table_page �з���
    struct task_struct *polling_task;  // ����poll ��select �Ľ���
    int triggered;                     // �Ѵ������
    int error;
    int inline_index;                  // ��һ��Ҫ�����inline_entrie ����
    struct poll_table_entry inline_entries[N_INLINE_POLL_ENTRIES];//
};
// ��������select/poll  ������ڴ�
struct poll_table_page {
    struct poll_table_page  * next;       // ��һ�� page
    struct poll_table_entry * entry;      // ָ���һ��entries
    struct poll_table_entry entries[0];
};
// ��һ������poll /select ���ļ������,
struct poll_table_entry {
    struct file *filp;               // ��poll/select�е��ļ�
    unsigned long key;
    wait_queue_t wait;               // ���뵽wait_queue_head_t �Ľڵ�
    wait_queue_head_t *wait_address; // �ļ��ϵ�wait_queue_head_t ��ַ
};

/*
��ͼ�� poll/select ʵ�ֹ������ֵĹ�ϵͼ�����������ļ�ֱ�ӵĹ�ϵ���Լ�����֮���������



������poll/select���õ�һЩ����
*/
// poll_wqueues �ĳ�ʼ��:
// ��ʼ�� poll_wqueues , __pollwait�����ļ�����ʱ������
void poll_initwait(struct poll_wqueues *pwq)
{
    // ��ʼ��poll_table, �൱�ڵ��û���Ĺ��캯��
    init_poll_funcptr(&pwq->pt, __pollwait);
    /*
     * static inline void init_poll_funcptr(poll_table *pt, poll_queue_proc qproc)
     * {
     *     pt->_qproc = qproc;
     *     pt->_key   = ~0UL;
     * }
     */
    pwq->polling_task = current;
    pwq->triggered = 0;
    pwq->error = 0;
    pwq->table = NULL;
    pwq->inline_index = 0;
}


// wait_queue���ú���
// poll/select ���ļ�wait_queue����ӽڵ�ķ���
static void __pollwait(struct file *filp, wait_queue_head_t *wait_address,
                       poll_table *p)
{
    struct poll_wqueues *pwq = container_of(p, struct poll_wqueues, pt);
    struct poll_table_entry *entry = poll_get_entry(pwq);
    if (!entry) {
        return;
    }
    get_file(filp); //put_file() in free_poll_entry()
    entry->filp = filp;
    entry->wait_address = wait_address; // �ȴ�����ͷ
    entry->key = p->key;
    // ���ûص�Ϊ pollwake
    init_waitqueue_func_entry(&entry->wait, pollwake);
    entry->wait.private = pwq;
    // ��ӵ��ȴ�����
    add_wait_queue(wait_address, &entry->wait);
}

// �ڵȴ�����(wait_queue_t)�ϻص�����(func)
// �ļ������󱻵��ã����ѵ��ý��̣�����key���ļ��ṩ�ĵ�ǰ״̬����
static int pollwake(wait_queue_t *wait, unsigned mode, int sync, void *key)
{
    struct poll_table_entry *entry;
    // ȡ���ļ���Ӧ��poll_table_entry
    entry = container_of(wait, struct poll_table_entry, wait);
    // ���˲���ע���¼�
    if (key && !((unsigned long)key & entry->key)) {
        return 0;
    }
    // ����
    return __pollwake(wait, mode, sync, key);
}
static int __pollwake(wait_queue_t *wait, unsigned mode, int sync, void *key)
{
    struct poll_wqueues *pwq = wait->private;
    // �����ý��� pwq->polling_task ������ dummy_wait
    DECLARE_WAITQUEUE(dummy_wait, pwq->polling_task);
    smp_wmb();
    pwq->triggered = 1;// ���Ϊ�Ѵ���
    // ���ѵ��ý���
    return default_wake_function(&dummy_wait, mode, sync, key);
}

// Ĭ�ϵĻ��Ѻ���,poll/select ���õĻص���������ô˺�������
// ֱ�ӻ��ѵȴ������ϵ��߳�,�����߳��Ƶ����ж���(rq)
int default_wake_function(wait_queue_t *curr, unsigned mode, int wake_flags,
                          void *key)
{
    // ��������Ƚϸ���, ����Ͳ����������
    return try_to_wake_up(curr->private, mode, wake_flags);
}

/*
�ڴ����poll��select��poll_table_entry��������ͷŲ��õ��������ڴ�صĹ���ʽ����ʹ��Ԥ����Ŀռ䣬Ԥ����Ŀռ䲻��ʱ������һ���ڴ�ҳ��ʹ���ڴ�ҳ�ϵĿռ䡣
*/
// �����ʹ������ǰ����� poll_table_entry,
static struct poll_table_entry *poll_get_entry(struct poll_wqueues *p) {
    struct poll_table_page *table = p->table;

    if (p->inline_index < N_INLINE_POLL_ENTRIES) {
        return p->inline_entries + p->inline_index++;
    }

    if (!table || POLL_TABLE_FULL(table)) {
        struct poll_table_page *new_table;
        new_table = (struct poll_table_page *) __get_free_page(GFP_KERNEL);
        if (!new_table) {
            p->error = -ENOMEM;
            return NULL;
        }
        new_table->entry = new_table->entries;
        new_table->next = table;
        p->table = new_table;
        table = new_table;
    }
    return table->entry++;
}

// ����poll_wqueues ռ�õ���Դ
void poll_freewait(struct poll_wqueues *pwq)
{
    struct poll_table_page * p = pwq->table;
    // ���������ѷ����inline poll_table_entry
    int i;
    for (i = 0; i < pwq->inline_index; i++) {
        free_poll_entry(pwq->inline_entries + i);
    }
    // ������poll_table_page�Ϸ����inline poll_table_entry
    // ���ͷ�poll_table_page
    while (p) {
        struct poll_table_entry * entry;
        struct poll_table_page *old;
        entry = p->entry;
        do {
            entry--;
            free_poll_entry(entry);
        } while (entry > p->entries);
        old = p;
        p = p->next;
        free_page((unsigned long) old);
    }
}
static void free_poll_entry(struct poll_table_entry *entry)
{
    // �ӵȴ�������ɾ��, �ͷ��ļ����ü���
    remove_wait_queue(entry->wait_address, &entry->wait);
    fput(entry->filp);
}

/*
poll ��ʵ��
*/
// poll ʹ�õĽṹ��
struct pollfd {
    int fd;        // ������
    short events;  // ��ע���¼�����
    short revents; // ���ص��¼�����
};
// long sys_poll(struct pollfd *ufds, unsigned int nfds, long timeout_msecs)
SYSCALL_DEFINE3(poll, struct pollfd __user *, ufds, unsigned int, nfds,
                long, timeout_msecs)
{
    struct timespec end_time, *to = NULL;
    int ret;
    if (timeout_msecs >= 0) {
        to = &end_time;
        // ����Գ�ʱʱ��msec ת��Ϊ����ʱ��
        poll_select_set_timeout(to, timeout_msecs / MSEC_PER_SEC,
                                NSEC_PER_MSEC * (timeout_msecs % MSEC_PER_SEC));
    }
    // do sys poll
    ret = do_sys_poll(ufds, nfds, to);
    // do_sys_poll ���ź��ж�, ���µ���, ��ʹ������˵ poll �ǲ��ᱻ�ź��жϵ�.
    if (ret == -EINTR) {
        struct restart_block *restart_block;
        restart_block = &current_thread_info()->restart_block;
        restart_block->fn = do_restart_poll; // ���������ĺ���
        restart_block->poll.ufds = ufds;
        restart_block->poll.nfds = nfds;
        if (timeout_msecs >= 0) {
            restart_block->poll.tv_sec = end_time.tv_sec;
            restart_block->poll.tv_nsec = end_time.tv_nsec;
            restart_block->poll.has_timeout = 1;
        } else {
            restart_block->poll.has_timeout = 0;
        }
        // ERESTART_RESTARTBLOCK ���᷵�ظ��û�����,
        // ���ǻᱻϵͳ����, Ȼ����� do_restart_poll,
        ret = -ERESTART_RESTARTBLOCK;
    }
    return ret;
}
int do_sys_poll(struct pollfd __user *ufds, unsigned int nfds,
                struct timespec *end_time)
{
    struct poll_wqueues table;
    int err = -EFAULT, fdcount, len, size;
    /* ����ʹ��ջ�ϵĿռ䣬��Լ�ڴ棬���ٷ��� */
    long stack_pps[POLL_STACK_ALLOC/sizeof(long)];
    struct poll_list *const head = (struct poll_list *)stack_pps;
    struct poll_list *walk = head;
    unsigned long todo = nfds;
    if (nfds > rlimit(RLIMIT_NOFILE)) {
        // �ļ�����������������ǰ��������
        return -EINVAL;
    }
    // �����û��ռ����ݵ��ں�
    len = min_t(unsigned int, nfds, N_STACK_PPS);
    for (;;) {
        walk->next = NULL;
        walk->len = len;
        if (!len) {
            break;
        }
        // ���Ƶ���ǰ�� entries
        if (copy_from_user(walk->entries, ufds + nfds-todo,
                           sizeof(struct pollfd) * walk->len)) {
            goto out_fds;
        }
        todo -= walk->len;
        if (!todo) {
            break;
        }
        // ջ�Ͽռ䲻�㣬�ڶ�������ʣ�ಿ��
        len = min(todo, POLLFD_PER_PAGE);
        size = sizeof(struct poll_list) + sizeof(struct pollfd) * len;
        walk = walk->next = kmalloc(size, GFP_KERNEL);
        if (!walk) {
            err = -ENOMEM;
            goto out_fds;
        }
    }
    // ��ʼ�� poll_wqueues �ṹ, ���ú���ָ��_qproc  Ϊ__pollwait
    poll_initwait(&table);
    // poll
    fdcount = do_poll(nfds, head, &table, end_time);
    // ���ļ�wait queue ���Ƴ���Ӧ�Ľڵ�, �ͷ�entry.
    poll_freewait(&table);
    // ���ƽ�����û��ռ�
    for (walk = head; walk; walk = walk->next) {
        struct pollfd *fds = walk->entries;
        int j;
        for (j = 0; j < len; j++, ufds++)
            if (__put_user(fds[j].revents, &ufds->revents)) {
                goto out_fds;
            }
    }
    err = fdcount;
out_fds:
    // �ͷ�������ڴ�
    walk = head->next;
    while (walk) {
        struct poll_list *pos = walk;
        walk = walk->next;
        kfree(pos);
    }
    return err;
}
// �����Ĵ�����
static int do_poll(unsigned int nfds,  struct poll_list *list,
                   struct poll_wqueues *wait, struct timespec *end_time)
{
    poll_table* pt = &wait->pt;
    ktime_t expire, *to = NULL;
    int timed_out = 0, count = 0;
    unsigned long slack = 0;
    if (end_time && !end_time->tv_sec && !end_time->tv_nsec) {
        // �Ѿ���ʱ,ֱ�ӱ��������ļ�������, Ȼ�󷵻�
        pt = NULL;
        timed_out = 1;
    }
    if (end_time && !timed_out) {
        // ���ƽ��̵ȴ�ʱ�䣬����
        slack = select_estimate_accuracy(end_time);
    }
    // �����ļ���Ϊÿ���ļ��ĵȴ�������ӻ��Ѻ���(pollwake)
    for (;;) {
        struct poll_list *walk;
        for (walk = list; walk != NULL; walk = walk->next) {
            struct pollfd * pfd, * pfd_end;
            pfd = walk->entries;
            pfd_end = pfd + walk->len;
            for (; pfd != pfd_end; pfd++) {
                // do_pollfd �����ļ���Ӧ��wait queue ����ӽڵ�
                // �ͻص�����(��� pt ��Ϊ��)
                // ����鵱ǰ�ļ�״̬�����÷��ص�����
                if (do_pollfd(pfd, pt)) {
                    // ���ļ��Ѿ�׼������.
                    // ����Ҫ������ļ���wait queue ����ӻ��Ѻ�����.
                    count++;
                    pt = NULL;
                }
            }
        }
        // �´�ѭ����ʱ����Ҫ���ļ���wait queue ����ӽڵ�,
        // ��Ϊǰ���ѭ���Ѿ��Ѹ���ӵĶ������
        pt = NULL;

        // ��һ�α���û�з���ready���ļ�
        if (!count) {
            count = wait->error;
            // ���źŲ���
            if (signal_pending(current)) {
                count = -EINTR;
            }
        }

        // ��ready���ļ����Ѿ���ʱ
        if (count || timed_out) {
            break;
        }
        // ת��Ϊ�ں�ʱ��
        if (end_time && !to) {
            expire = timespec_to_ktime(*end_time);
            to = &expire;
        }
        // �ȴ��¼�����, ������¼�������ʱ������ѭ
        // ��һ�飬ȡ���¼�״̬���벢����,
        // ע��˴�ѭ����, �ļ� wait queue �еĽڵ���Ȼ����
        if (!poll_schedule_timeout(wait, TASK_INTERRUPTIBLE, to, slack)) {
            timed_out = 1;
        }
    }
    return count;
}


static inline unsigned int do_pollfd(struct pollfd *pollfd, poll_table *pwait)
{
    unsigned int mask;
    int fd;
    mask = 0;
    fd = pollfd->fd;
    if (fd >= 0) {
        int fput_needed;
        struct file * file;
        // ȡ��fd��Ӧ���ļ��ṹ��
        file = fget_light(fd, &fput_needed);
        mask = POLLNVAL;
        if (file != NULL) {
            // ���û�� f_op �� f_op->poll ����Ϊ�ļ�ʼ�մ��ھ���״̬.
            mask = DEFAULT_POLLMASK;
            if (file->f_op && file->f_op->poll) {
                if (pwait) {
                    // ���ù�ע���¼�����
                    pwait->key = pollfd->events | POLLERR | POLLHUP;
                }
                // ע��ص������������ص�ǰ����״̬������������pollwake
                mask = file->f_op->poll(file, pwait);
            }
            mask &= pollfd->events | POLLERR | POLLHUP; // �Ƴ�����Ҫ��״̬����
            fput_light(file, fput_needed);// �ͷ��ļ�
        }
    }
    pollfd->revents = mask; // �����¼�״̬
    return mask;
}


static long do_restart_poll(struct restart_block *restart_block)
{
    struct pollfd __user *ufds = restart_block->poll.ufds;
    int nfds = restart_block->poll.nfds;
    struct timespec *to = NULL, end_time;
    int ret;
    if (restart_block->poll.has_timeout) {
        // ��ȡ��ǰ�ĳ�ʱʱ��
        end_time.tv_sec = restart_block->poll.tv_sec;
        end_time.tv_nsec = restart_block->poll.tv_nsec;
        to = &end_time;
    }
    ret = do_sys_poll(ufds, nfds, to); // ���µ��� do_sys_poll
    if (ret == -EINTR) {
        // �ֱ��ź��ж���, �ٴ�����
        restart_block->fn = do_restart_poll;
        ret = -ERESTART_RESTARTBLOCK;
    }
    return ret;
}
/*
select ʵ��
*/
typedef struct {
    unsigned long *in, *out, *ex;
    unsigned long *res_in, *res_out, *res_ex;
} fd_set_bits;
//  long sys_select(int n, fd_set *inp, fd_set *outp, fd_set *exp, struct timeval *tvp)
SYSCALL_DEFINE5(select, int, n, fd_set __user *, inp, fd_set __user *, outp,
                fd_set __user *, exp, struct timeval __user *, tvp)
{
    struct timespec end_time, *to = NULL;
    struct timeval tv;
    int ret;
    if (tvp) {
        if (copy_from_user(&tv, tvp, sizeof(tv))) {
            return -EFAULT;
        }
        // ���㳬ʱʱ��
        to = &end_time;
        if (poll_select_set_timeout(to,
                                    tv.tv_sec + (tv.tv_usec / USEC_PER_SEC),
                                    (tv.tv_usec % USEC_PER_SEC) * NSEC_PER_USEC)) {
            return -EINVAL;
        }
    }
    ret = core_sys_select(n, inp, outp, exp, to);
    // ����ʣ��ʱ�䵽�û��ռ�
    ret = poll_select_copy_remaining(&end_time, tvp, 1, ret);
    return ret;
}

int core_sys_select(int n, fd_set __user *inp, fd_set __user *outp,
                    fd_set __user *exp, struct timespec *end_time)
{
    fd_set_bits fds;
    void *bits;
    int ret, max_fds;
    unsigned int size;
    struct fdtable *fdt;
    //С����ʹ��ջ�ϵĿռ�,��Լ�ڴ�, �ӿ�����ٶ�
    long stack_fds[SELECT_STACK_ALLOC/sizeof(long)];

    ret = -EINVAL;
    if (n < 0) {
        goto out_nofds;
    }

    rcu_read_lock();
    // ȡ�ý��̶�Ӧ�� fdtable
    fdt = files_fdtable(current->files);
    max_fds = fdt->max_fds;
    rcu_read_unlock();
    if (n > max_fds) {
        n = max_fds;
    }

    size = FDS_BYTES(n);
    bits = stack_fds;
    if (size > sizeof(stack_fds) / 6) {
        // ջ�ϵĿռ䲻��, �����ڴ�, ȫ��ʹ�ö��ϵĿռ�
        ret = -ENOMEM;
        bits = kmalloc(6 * size, GFP_KERNEL);
        if (!bits) {
            goto out_nofds;
        }
    }
    fds.in	   = bits;
    fds.out	   = bits +   size;
    fds.ex	   = bits + 2*size;
    fds.res_in  = bits + 3*size;
    fds.res_out = bits + 4*size;
    fds.res_ex  = bits + 5*size;

    // �����û��ռ䵽�ں�
    if ((ret = get_fd_set(n, inp, fds.in)) ||
            (ret = get_fd_set(n, outp, fds.out)) ||
            (ret = get_fd_set(n, exp, fds.ex))) {
        goto out;
    }
    // ��ʼ��fd set
    zero_fd_set(n, fds.res_in);
    zero_fd_set(n, fds.res_out);
    zero_fd_set(n, fds.res_ex);

    ret = do_select(n, &fds, end_time);

    if (ret < 0) {
        goto out;
    }
    if (!ret) {
        // �÷���ֵ�ᱻϵͳ����, ����ͬ���Ĳ������µ���sys_select()
        ret = -ERESTARTNOHAND;
        if (signal_pending(current)) {
            goto out;
        }
        ret = 0;
    }

    // ���Ƶ��û��ռ�
    if (set_fd_set(n, inp, fds.res_in) ||
            set_fd_set(n, outp, fds.res_out) ||
            set_fd_set(n, exp, fds.res_ex)) {
        ret = -EFAULT;
    }

out:
    if (bits != stack_fds) {
        kfree(bits);
    }
out_nofds:
    return ret;
}

int do_select(int n, fd_set_bits *fds, struct timespec *end_time)
{
    ktime_t expire, *to = NULL;
    struct poll_wqueues table;
    poll_table *wait;
    int retval, i, timed_out = 0;
    unsigned long slack = 0;

    rcu_read_lock();
    // ���fds��fd����Ч��, ����ȡ��ǰ����fd
    retval = max_select_fd(n, fds);
    rcu_read_unlock();

    if (retval < 0) {
        return retval;
    }
    n = retval;

    // ��ʼ�� poll_wqueues �ṹ, ���ú���ָ��_qproc	Ϊ__pollwait
    poll_initwait(&table);
    wait = &table.pt;
    if (end_time && !end_time->tv_sec && !end_time->tv_nsec) {
        wait = NULL;
        timed_out = 1;
    }

    if (end_time && !timed_out) {
        // ������Ҫ�ȴ���ʱ��.
        slack = select_estimate_accuracy(end_time);
    }

    retval = 0;
    for (;;) {
        unsigned long *rinp, *routp, *rexp, *inp, *outp, *exp;

        inp = fds->in;
        outp = fds->out;
        exp = fds->ex;
        rinp = fds->res_in;
        routp = fds->res_out;
        rexp = fds->res_ex;
        // �������е�������, i �ļ�������
        for (i = 0; i < n; ++rinp, ++routp, ++rexp) {
            unsigned long in, out, ex, all_bits, bit = 1, mask, j;
            unsigned long res_in = 0, res_out = 0, res_ex = 0;
            const struct file_operations *f_op = NULL;
            struct file *file = NULL;
            // ��鵱ǰ�� slot �е�������
            in = *inp++;
            out = *outp++;
            ex = *exp++;
            all_bits = in | out | ex;
            if (all_bits == 0) { // û����Ҫ������������, ��һ��slot
                i += __NFDBITS;
                continue;
            }

            for (j = 0; j < __NFDBITS; ++j, ++i, bit <<= 1) {
                int fput_needed;
                if (i >= n) {
                    break;
                }
                // ����Ҫ���������� i
                if (!(bit & all_bits)) {
                    continue;
                }
                // ȡ���ļ��ṹ
                file = fget_light(i, &fput_needed);
                if (file) {
                    f_op = file->f_op;
                    // û�� f_op �Ļ�����Ϊһֱ���ھ���״̬
                    mask = DEFAULT_POLLMASK;
                    if (f_op && f_op->poll) {
                        // ���õȴ��¼�������
                        wait_key_set(wait, in, out, bit);
                        /*
                        static inline void wait_key_set(poll_table *wait, unsigned long in,
                        unsigned long out, unsigned long bit)
                        {
                        wait->_key = POLLEX_SET;// (POLLPRI)
                        if (in & bit)
                        wait->_key |= POLLIN_SET;//(POLLRDNORM | POLLRDBAND | POLLIN | POLLHUP | POLLERR)
                        if (out & bit)
                        wait->_key |= POLLOUT_SET;//POLLOUT_SET (POLLWRBAND | POLLWRNORM | POLLOUT | POLLERR)
                        }
                        */
                        // ��ȡ��ǰ�ľ���״̬, ����ӵ��ļ��Ķ�Ӧ�ȴ�������
                        mask = (*f_op->poll)(file, wait);
                        // ��poll��ȫһ��
                    }
                    fput_light(file, fput_needed);
                    // �ͷ��ļ�
                    // ����ļ� i �Ƿ������¼�������
                    if ((mask & POLLIN_SET) && (in & bit)) {
                        res_in |= bit;
                        retval++;
                        // ������о����¼��Ͳ����������ļ���
                        // �ȴ���������ӻص�����
                        wait = NULL;
                    }
                    if ((mask & POLLOUT_SET) && (out & bit)) {
                        res_out |= bit;
                        retval++;
                        wait = NULL;
                    }
                    if ((mask & POLLEX_SET) && (ex & bit)) {
                        res_ex |= bit;
                        retval++;
                        wait = NULL;
                    }
                }
            }
            if (res_in) {
                *rinp = res_in;
            }
            if (res_out) {
                *routp = res_out;
            }
            if (res_ex) {
                *rexp = res_ex;
            }
            cond_resched();
        }
        wait = NULL; // ����ӻص������Ķ��Ѿ������
        if (retval || timed_out || signal_pending(current)) {
            break;	 // �źŷ����������¼�������ʱ
        }
        if (table.error) {
            retval = table.error; // ����������
            break;
        }
        // ת�����ں�ʱ��
        if (end_time && !to) {
            expire = timespec_to_ktime(*end_time);
            to = &expire;
        }
        // �ȴ�ֱ����ʱ, ���ɻص���������, ��ʱ����ٴα����ļ�������
        if (!poll_schedule_timeout(&table, TASK_INTERRUPTIBLE,
                                   to, slack)) {
            timed_out = 1;
        }
    }

    poll_freewait(&table);

    return retval;
}

/*
       epoll

       epoll ��ʵ�ֱ�poll/select ����һЩ��������Ϊ
       epoll_wait, epoll_ctl �ĵ�����ȫ��������,�ں���Ҫ�����ƶ���Щ�������б�����������Ҫ�־õ�ά����ӵ�epoll���ļ�
       epoll����Ҳ���ļ���Ҳ���Ա�poll/select/epoll���ӣ�����ܵ���epoll֮��ѭ�����ѵ�����
       �����ļ���״̬�ı���ܻ��ѹ�����������ϵ�epoll���������ѷ籩

       epoll�������ܵ�ʵ��Ҫ�ǳ�С�������Щ���⣬ʹ�ø��Ӷȴ�����ӡ�
       epoll ��ػ����ṹ
       */

// epoll�ĺ���ʵ�ֶ�Ӧ��һ��epoll������
struct eventpoll {
    spinlock_t lock;
    struct mutex mtx;
    wait_queue_head_t wq; // sys_epoll_wait() �ȴ�������
    // f_op->poll()  ʹ�õ�, �������¼�֪ͨ�������õ�wait_address
    wait_queue_head_t poll_wait;
    /* �Ѿ�������Ҫ����epitem �б� */
    struct list_head rdllist;
    /* �������м��뵽��ǰepoll���ļ���Ӧ��epitem*/
    struct rb_root rbr;
    // ���������û��ռ临������ʱ, �����Ŀ����ļ�
    struct epitem *ovflist;
    /* The user that created the eventpoll descriptor */
    struct user_struct *user;
    struct file *file;
    /*�Ż�ѭ����飬����ѭ��������ظ��ı��� */
    int visited;
    struct list_head visited_list_link;
}

// ��Ӧ��һ�����뵽epoll���ļ�
struct epitem {
    // ���ص�eventpoll �ĺ�����ڵ�
    struct rb_node rbn;
    // ���ص�eventpoll.rdllist �Ľڵ�
    struct list_head rdllink;
    // ���ӵ�ovflist ��ָ��
    struct epitem *next;
    /* �ļ���������Ϣfd + file, �������key */
    struct epoll_filefd ffd;
    /* Number of active wait queue attached to poll operations */
    int nwait;
    // ��ǰ�ļ��ĵȴ�����(eppoll_entry)�б�
    // ͬһ���ļ��Ͽ��ܻ���Ӷ����¼�,
    // ��Щ�¼��������ڲ�ͬ��wait_queue��
    // (ȡ���ڶ�Ӧ�ļ����͵�ʵ��),
    // ������Ҫʹ������
    struct list_head pwqlist;
    // ��ǰepitem ��������
    struct eventpoll *ep;
    /* List header used to link this item to the &quot;struct file&quot; items list */
    struct list_head fllink;
    /* epoll_ctl ������û����� */
    struct epoll_event event;
};

struct epoll_filefd {
    struct file *file;
    int fd;
};

// ��һ���ļ��ϵ�һ��wait_queue_head ���������Ϊͬһ�ļ������ж���ȴ����¼�����Щ�¼�����ʹ�ò�ͬ�ĵȴ�����
struct eppoll_entry {
    // List struct epitem.pwqlist
    struct list_head llink;
    // ������
    struct epitem *base;
    // ��ӵ�wait_queue �еĽڵ�
    wait_queue_t wait;
    // �ļ�wait_queue ͷ
    wait_queue_head_t *whead;
};

// �û�ʹ�õ�epoll_event
struct epoll_event {
    __u32 events;
    __u64 data;
} EPOLL_PACKED;

/*
epollȫͼ

�ļ�ϵͳ��eventpoll_poll��ʵ��
*/

// epoll �ļ�ϵͳ�����ʵ��
// epoll �ļ�ϵͳ��ʼ��, ��ϵͳ����ʱ�����

static int __init eventpoll_init(void)
{
    struct sysinfo si;

    si_meminfo(&si);
    // ���ƿ���ӵ�epoll����������������

    max_user_watches = (((si.totalram - si.totalhigh) / 25) << PAGE_SHIFT) /
                       EP_ITEM_COST;
    BUG_ON(max_user_watches < 0);

    // ��ʼ���ݹ������
    ep_nested_calls_init(&poll_loop_ncalls);
    ep_nested_calls_init(&poll_safewake_ncalls);
    ep_nested_calls_init(&poll_readywalk_ncalls);
    // epoll ʹ�õ�slab�������ֱ���������epitem��eppoll_entry
    epi_cache = kmem_cache_create("eventpoll_epi", sizeof(struct epitem),
                                  0, SLAB_HWCACHE_ALIGN | SLAB_PANIC, NULL);
    pwq_cache = kmem_cache_create("eventpoll_pwq",
                                  sizeof(struct eppoll_entry), 0, SLAB_PANIC, NULL);

    return 0;
}


SYSCALL_DEFINE1(epoll_create, int, size)
{
    if (size <= 0) {
        return -EINVAL;
    }

    return sys_epoll_create1(0);
}

SYSCALL_DEFINE1(epoll_create1, int, flags)
{
    int error, fd;
    struct eventpoll *ep = NULL;
    struct file *file;

    /* Check the EPOLL_* constant for consistency.	*/
    BUILD_BUG_ON(EPOLL_CLOEXEC != O_CLOEXEC);

    if (flags & ~EPOLL_CLOEXEC) {
        return -EINVAL;
    }
    /*
     * Create the internal data structure ("struct eventpoll").
     */
    error = ep_alloc(&ep);
    if (error < 0) {
        return error;
    }
    /*
     * Creates all the items needed to setup an eventpoll file. That is,
     * a file structure and a free file descriptor.
     */
    fd = get_unused_fd_flags(O_RDWR | (flags & O_CLOEXEC));
    if (fd < 0) {
        error = fd;
        goto out_free_ep;
    }
    file = anon_inode_getfile("[eventpoll]", &eventpoll_fops, ep,
                              O_RDWR | (flags & O_CLOEXEC));
    if (IS_ERR(file)) {
        error = PTR_ERR(file);
        goto out_free_fd;
    }
    fd_install(fd, file);
    ep->file = file;
    return fd;

out_free_fd:
    put_unused_fd(fd);
out_free_ep:
    ep_free(ep);
    return error;
}


// ����epoll����Ҳ���ļ�ϵͳ����������Ҳ���Ա�poll/select/epoll���ӣ������Ҫʵ��poll������
static const struct file_operations eventpoll_fops = {
    .release = ep_eventpoll_release,
    .poll	 = ep_eventpoll_poll,
    .llseek	 = noop_llseek,
};

static unsigned int ep_eventpoll_poll(struct file *file, poll_table *wait)
{
    int pollflags;
    struct eventpoll *ep = file->private_data;
    // ���뵽wait_queue
    poll_wait(file, &ep->poll_wait, wait);
    // ɨ��������ļ��б�, ����ÿ���ļ��ϵ�poll ����Ƿ���ľ���,
    // Ȼ���Ƶ��û��ռ�
    // �ļ��б����п�����epoll�ļ�, ����poll��ʱ���п��ܻ�����ݹ�,
    // ����������ep_call_nested ��װһ��, ��ֹ��ѭ���͹���ĵ���
    pollflags = ep_call_nested(&poll_readywalk_ncalls, EP_MAX_NESTS,
                               ep_poll_readyevents_proc, ep, ep, current);
    // static struct nested_calls poll_readywalk_ncalls;
    return pollflags != -1 ? pollflags : 0;
}

static int ep_poll_readyevents_proc(void *priv, void *cookie, int call_nests)
{
    return ep_scan_ready_list(priv, ep_read_events_proc, NULL, call_nests + 1);
}

static int ep_scan_ready_list(struct eventpoll *ep,
                              int (*sproc)(struct eventpoll *,
                                      struct list_head *, void *),
                              void *priv,
                              int depth)
{
    int error, pwake = 0;
    unsigned long flags;
    struct epitem *epi, *nepi;
    LIST_HEAD(txlist);

    /*
     * We need to lock this because we could be hit by
     * eventpoll_release_file() and epoll_ctl().
     */
    mutex_lock_nested(&ep->mtx, depth);

    spin_lock_irqsave(&ep->lock, flags);
    // �ƶ�rdllist ���µ�����txlist
    list_splice_init(&ep->rdllist, &txlist);
    // �ı�ovflist ��״̬, ���ep->ovflist != EP_UNACTIVE_PTR,
    // ���ļ�����wait_queueʱ���ͻὫ��Ӧ��epitem���뵽ep->ovflist
    // �����ļ�ֱ�Ӽ��뵽ep->rdllist��
    // ��������Ŀ���Ǳ��ⶪʧ�¼�
    // ���ﲻ��Ҫ���ep->ovflist ��״̬����Ϊep->mtx�Ĵ��ڱ�֤�˴���ep->ovflist
    // һ����EP_UNACTIVE_PTR
    ep->ovflist = NULL;
    spin_unlock_irqrestore(&ep->lock, flags);

    // ����ɨ�躯������txlist
    error = (*sproc)(ep, &txlist, priv);

    spin_lock_irqsave(&ep->lock, flags);

    // ���� sproc ʱ�������µ��¼���������Щ�µ��¼�������뵽ready list
    for (nepi = ep->ovflist; (epi = nepi) != NULL;
            nepi = epi->next, epi->next = EP_UNACTIVE_PTR) {
        // #define EP_UNACTIVE_PTR (void *) -1
        // epi ����rdllist, ����
        if (!ep_is_linked(&epi->rdllink)) {
            list_add_tail(&epi->rdllink, &ep->rdllist);
        }
    }
    // ��ԭep->ovflist��״̬
    ep->ovflist = EP_UNACTIVE_PTR;

    // �������� txlist ���ӵ� rdllist
    list_splice(&txlist, &ep->rdllist);

    if (!list_empty(&ep->rdllist)) {
        // ����epoll_wait
        if (waitqueue_active(&ep->wq)) {
            wake_up_locked(&ep->wq);
        }
        // ��ǰ��ep���������¼�֪ͨ���Ƽ��
        if (waitqueue_active(&ep->poll_wait)) {
            pwake++;
        }
    }
    spin_unlock_irqrestore(&ep->lock, flags);

    mutex_unlock(&ep->mtx);

    if (pwake) {
        // ��ȫ�����ⲿ���¼�֪ͨ����
        ep_poll_safewake(&ep->poll_wait);
    }

    return error;
}

static int ep_read_events_proc(struct eventpoll *ep, struct list_head *head,
                               void *priv)
{
    struct epitem *epi, *tmp;
    poll_table pt;
    init_poll_funcptr(&pt, NULL);
    list_for_each_entry_safe(epi, tmp, head, rdllink) {
        pt._key = epi->event.events;
        if (epi->ffd.file->f_op->poll(epi->ffd.file, &pt) &
                epi->event.events) {
            return POLLIN | POLLRDNORM;
        } else {
            // ����¼���Ȼ�ھ����б���,
            // ����ʵ���ϲ�û�о���, �����Ƴ�
            // ���п�����ˮƽ����ģʽ�ٴμ���ļ���״̬��
            // Ҳ�������¼����뵽�����б����ĳЩ�̶߳��ļ������˲���
            list_del_init(&epi->rdllink);
        }
    }
    return 0;
}

/*
��ֹ��ѭ���͹���ĵݹ����

��epoll�ĵ��ù��������п��ܲ����ݹ���õĺ������ɺ���
*/
static int ep_call_nested(struct nested_calls *ncalls, int max_nests,
                          int (*nproc)(void *, void *, int), void *priv,
                          void *cookie, void *ctx);
/*
���а��������������ѭ�������ĵݹ���þͻ᷵�ش���
ep_call_nested ��ÿ�ε��ú���nproc֮ǰ����һ��ȫ�ֵ������в���һ��������ǰ��������������ctx(���̣�CPU����epoll�ļ�)�ʹ���Ķ����ʶcookie��Ȼ��ͨ������ȫ������Ϳ���֪����ǰ�ݹ����ȣ��������������ͬ���������ĳ�����ͬ����cookie��ʶcookie��˵����������ѭ����
*/

struct nested_call_node {
    struct list_head llink;
    void *cookie;   // �������б�ʶ, �����־
    void *ctx;      // ���л�����ʶ
};
struct nested_calls {
    struct list_head tasks_call_list;
    spinlock_t lock;
};

static nested_call_node poll_loop_ncalls;
static nested_call_node poll_safewake_ncalls;
static nested_call_node poll_readywalk_ncalls;



// ����epoll ��ֱ�ӻ��ӵݹ���õ���Ȳ���ֹ��ѭ��
// ctx: ��������������(����, CPU ��)
// cookie: ÿ������ı�ʶ
// priv: ����������Ҫ��˽������
// ����������������ʵ��Ӧ�þͻ���һ��wapper��
static int ep_call_nested(struct nested_calls *ncalls, int max_nests,
                          int (*nproc)(void *, void *, int), void *priv,
                          void *cookie, void *ctx)
{
    int error, call_nests = 0;
    unsigned long flags;
    struct list_head *lsthead = &ncalls->tasks_call_list;
    struct nested_call_node *tncur;
    struct nested_call_node tnode;
    spin_lock_irqsave(&ncalls->lock, flags);
    // ���ԭ�е�Ƕ�׵�������ncalls, �鿴�Ƿ�����ȳ������Ƶ����
    list_for_each_entry(tncur, lsthead, llink) {
        // ͬһ��������(ctx)����ͬ������(cookie)˵����������ѭ��
        // ͬһ�����ĵĵݹ����call_nests ��������
        if (tncur->ctx == ctx &&
                (tncur->cookie == cookie || ++call_nests > max_nests)) {
            error = -1;
        }
        goto out_unlock;
    }
    /* ����ǰ������������ӵ������б�*/
    tnode.ctx = ctx;
    tnode.cookie = cookie;
    list_add(&tnode.llink, lsthead);
    spin_unlock_irqrestore(&ncalls->lock, flags);
    /* nproc ���ܻᵼ�µݹ����(ֱ�ӻ���)ep_call_nested
         * ��������ݹ����, ��ô�ڴ˺�������֮ǰ,
         * ncalls �ֻᱻ�������Ľڵ�,
         * ����ͨ��ǰ��ļ��Ϳ���֪���ݹ���õ����
      */
    error = (*nproc)(priv, cookie, call_nests);
    /* ��������ɾ����ǰ����*/
    spin_lock_irqsave(&ncalls->lock, flags);
    list_del(&tnode.llink);
out_unlock:
    spin_unlock_irqrestore(&ncalls->lock, flags);
    return error;
}
/*
epoll_ctl ʵ��
*/

// long epoll_ctl(int epfd, int op, int fd, struct epoll_event *event);

SYSCALL_DEFINE4(epoll_ctl, int, epfd, int, op, int, fd,
                struct epoll_event __user *, event)
{
    int error;
    int did_lock_epmutex = 0;
    struct file *file, *tfile;
    struct eventpoll *ep;
    struct epitem *epi;
    struct epoll_event epds;

    error = -EFAULT;
    if (ep_op_has_event(op) &&
            // �����û��ռ����ݵ��ں�
            copy_from_user(&epds, event, sizeof(struct epoll_event))) {
        goto error_return;
    }

    // ȡ�� epfd ��Ӧ���ļ�
    error = -EBADF;
    file = fget(epfd);
    if (!file) {
        goto error_return;
    }

    // ȡ��Ŀ���ļ�
    tfile = fget(fd);
    if (!tfile) {
        goto error_fput;
    }

    // Ŀ���ļ������ṩ poll ����
    error = -EPERM;
    if (!tfile->f_op || !tfile->f_op->poll) {
        goto error_tgt_fput;
    }

    // ��������epfd ����epoll ���
    error = -EINVAL;
    if (file == tfile || !is_file_epoll(file)) {
        goto error_tgt_fput;
    }

    // ȡ���ڲ��ṹeventpoll
    ep = file->private_data;

    // EPOLL_CTL_MOD ����Ҫ��ȫ���� epmutex
    if (op == EPOLL_CTL_ADD || op == EPOLL_CTL_DEL) {
        mutex_lock(&epmutex);
        did_lock_epmutex = 1;
    }
    if (op == EPOLL_CTL_ADD) {
        if (is_file_epoll(tfile)) {
            error = -ELOOP;
            // Ŀ���ļ�Ҳ��epoll ����Ƿ���ѭ��
            if (ep_loop_check(ep, tfile) != 0) {
                goto error_tgt_fput;
            }
        } else

        {
            // ��Ŀ���ļ���ӵ� epoll ȫ�ֵ�tfile_check_list ��
            list_add(&tfile->f_tfile_llink, &tfile_check_list);
        }
    }

    mutex_lock_nested(&ep->mtx, 0);

    // ��tfile ��fd Ϊkey ��rbtree �в����ļ���Ӧ��epitem
    epi = ep_find(ep, tfile, fd);

    error = -EINVAL;
    switch (op) {
    case EPOLL_CTL_ADD:
        if (!epi) {
            // û�ҵ�, ��Ӷ������ERR HUP �¼�
            epds.events |= POLLERR | POLLHUP;
            error = ep_insert(ep, &epds, tfile, fd);
        } else {
            error = -EEXIST;
        }
        // ����ļ�����б�
        clear_tfile_check_list();
        break;
    case EPOLL_CTL_DEL:
        if (epi) {
            error = ep_remove(ep, epi);
        } else {
            error = -ENOENT;
        }
        break;
    case EPOLL_CTL_MOD:
        if (epi) {
            epds.events |= POLLERR | POLLHUP;
            error = ep_modify(ep, epi, &epds);
        } else {
            error = -ENOENT;
        }
        break;
    }
    mutex_unlock(&ep->mtx);

error_tgt_fput:
    if (did_lock_epmutex) {
        mutex_unlock(&epmutex);
    }

    fput(tfile);
error_fput:
    fput(file);
error_return:

    return error;
}


static LIST_HEAD(visited_list);
// ��� file (epoll)��ep ֮���Ƿ���ѭ��
static int ep_loop_check(struct eventpoll *ep, struct file *file)
{
    int ret;
    struct eventpoll *ep_cur, *ep_next;

    ret = ep_call_nested(&poll_loop_ncalls, EP_MAX_NESTS,
                         ep_loop_check_proc, file, ep, current);
    /* �������ͱ�־ */
    list_for_each_entry_safe(ep_cur, ep_next, &visited_list,
                             visited_list_link) {
        ep_cur->visited = 0;
        list_del(&ep_cur->visited_list_link);
    }
    return ret;
}

static int ep_loop_check_proc(void *priv, void *cookie, int call_nests)
{
    int error = 0;
    struct file *file = priv;
    struct eventpoll *ep = file->private_data;
    struct eventpoll *ep_tovisit;
    struct rb_node *rbp;
    struct epitem *epi;

    mutex_lock_nested(&ep->mtx, call_nests + 1);
    // ��ǵ�ǰΪ�ѱ���
    ep->visited = 1;
    list_add(&ep->visited_list_link, &visited_list);
    // ��������ep ���ӵ��ļ�
    for (rbp = rb_first(&ep->rbr); rbp; rbp = rb_next(rbp)) {
        epi = rb_entry(rbp, struct epitem, rbn);
        if (unlikely(is_file_epoll(epi->ffd.file))) {
            ep_tovisit = epi->ffd.file->private_data;
            // ������ǰ�ѱ�����, ����ѭ�����
            if (ep_tovisit->visited) {
                continue;
            }
            // ����ep���ӵ�δ������epoll
            error = ep_call_nested(&poll_loop_ncalls, EP_MAX_NESTS,
                                   ep_loop_check_proc, epi->ffd.file,
                                   ep_tovisit, current);
            if (error != 0) {
                break;
            }
        } else {
            // �ļ�����tfile_check_list ��, ���
            // ������epoll ��Ҫ�����epoll���ӵ��ļ�
            if (list_empty(&epi->ffd.file->f_tfile_llink))
                list_add(&epi->ffd.file->f_tfile_llink,
                         &tfile_check_list);
        }
    }
    mutex_unlock(&ep->mtx);

    return error;
}



// EPOLL_CTL_ADD
static int ep_insert(struct eventpoll *ep, struct epoll_event *event,
                     struct file *tfile, int fd)
{
    int error, revents, pwake = 0;
    unsigned long flags;
    long user_watches;
    struct epitem *epi;
    struct ep_pqueue epq;
    /*
    struct ep_pqueue {
    	poll_table pt;
    	struct epitem *epi;
    };
    */

    // ���Ӽ����ļ���
    user_watches = atomic_long_read(&ep->user->epoll_watches);
    if (unlikely(user_watches >= max_user_watches)) {
        return -ENOSPC;
    }

    // �����ʼ�� epi
    if (!(epi = kmem_cache_alloc(epi_cache, GFP_KERNEL))) {
        return -ENOMEM;
    }

    INIT_LIST_HEAD(&epi->rdllink);
    INIT_LIST_HEAD(&epi->fllink);
    INIT_LIST_HEAD(&epi->pwqlist);
    epi->ep = ep;
    // ��ʼ��������е�key
    ep_set_ffd(&epi->ffd, tfile, fd);
    // ֱ�Ӹ����û��ṹ
    epi->event = *event;
    epi->nwait = 0;
    epi->next = EP_UNACTIVE_PTR;

    // ��ʼ����ʱ�� epq
    epq.epi = epi;
    init_poll_funcptr(&epq.pt, ep_ptable_queue_proc);
	// �����¼�����
    epq.pt._key = event->events;
    //  �ڲ������ep_ptable_queue_proc, ���ļ���Ӧ��wait queue head ��
    // ע��ص�����, �����ص�ǰ�ļ���״̬
    revents = tfile->f_op->poll(tfile, &epq.pt);

    // ������
    error = -ENOMEM;
    if (epi->nwait < 0) { // f_op->poll ���̳���
        goto error_unregister;
    }
    // ��ӵ�ǰ��epitem ���ļ���f_ep_links ����
    spin_lock(&tfile->f_lock);
    list_add_tail(&epi->fllink, &tfile->f_ep_links);
    spin_unlock(&tfile->f_lock);

    // ����epi ��rbtree
    ep_rbtree_insert(ep, epi);

    /* now check if we've created too many backpaths */
    error = -EINVAL;
    if (reverse_path_check()) {
        goto error_remove_epi;
    }

    spin_lock_irqsave(&ep->lock, flags);

    /* �ļ��Ѿ��������뵽��������rdllist */
    if ((revents & event->events) && !ep_is_linked(&epi->rdllink)) {
        list_add_tail(&epi->rdllink, &ep->rdllist);


        if (waitqueue_active(&ep->wq))
            // ֪ͨsys_epoll_wait , ���ûص���������sys_epoll_wait ����
        {
            wake_up_locked(&ep->wq);
        }
        // �Ȳ�֪ͨ����eventpoll_poll �Ľ���
        if (waitqueue_active(&ep->poll_wait)) {
            pwake++;
        }
    }

    spin_unlock_irqrestore(&ep->lock, flags);

    atomic_long_inc(&ep->user->epoll_watches);

    if (pwake)
        // ��ȫ֪ͨ����eventpoll_poll �Ľ���
    {
        ep_poll_safewake(&ep->poll_wait);
    }

    return 0;

error_remove_epi:
    spin_lock(&tfile->f_lock);
    // ɾ���ļ��ϵ� epi
    if (ep_is_linked(&epi->fllink)) {
        list_del_init(&epi->fllink);
    }
    spin_unlock(&tfile->f_lock);

    // �Ӻ������ɾ��
    rb_erase(&epi->rbn, &ep->rbr);

error_unregister:
    // ���ļ���wait_queue ��ɾ��, �ͷ�epitem ����������eppoll_entry
    ep_unregister_pollwait(ep, epi);

    /*
     * We need to do this because an event could have been arrived on some
     * allocated wait queue. Note that we don't care about the ep->ovflist
     * list, since that is used/cleaned only inside a section bound by "mtx".
     * And ep_insert() is called with "mtx" held.
     */
    // TODO:
    spin_lock_irqsave(&ep->lock, flags);
    if (ep_is_linked(&epi->rdllink)) {
        list_del_init(&epi->rdllink);
    }
    spin_unlock_irqrestore(&ep->lock, flags);

    // �ͷ�epi
    kmem_cache_free(epi_cache, epi);

    return error;
}


#define PATH_ARR_SIZE 5
// ��EPOLL_CTL_ADD ʱ, ����Ƿ��п��ܲ������ѷ籩
// epoll ����ĵ����ļ��Ļ������С��5, ����
// һ���ļ����������1000�����Ϊ1��epoll������,
//�������б������ļ�ֱ�ӻ��ѵ�epoll�������ٴλ��ѵ�epoll������������500
//

// �������
static const int path_limits[PATH_ARR_SIZE] = { 1000, 500, 100, 50, 10 };
// ������������
static int path_count[PATH_ARR_SIZE];

static int path_count_inc(int nests)
{
    /* Allow an arbitrary number of depth 1 paths */
    if (nests == 0) {
        return 0;
    }

    if (++path_count[nests] > path_limits[nests]) {
        return -1;
    }
    return 0;
}

static void path_count_init(void)
{
    int i;

    for (i = 0; i < PATH_ARR_SIZE; i++) {
        path_count[i] = 0;
    }
}

// ���ѷ籩��麯��
static int reverse_path_check(void)
{
    int error = 0;
    struct file *current_file;

    /* let's call this for all tfiles */
    // ����ȫ��tfile_check_list �е��ļ�, ��һ��
    list_for_each_entry(current_file, &tfile_check_list, f_tfile_llink) {
        // ��ʼ��
        path_count_init();
        // ���Ƶݹ�����, �����ÿ������ϻ��ѵ�epoll ����
        error = ep_call_nested(&poll_loop_ncalls, EP_MAX_NESTS,
                               reverse_path_check_proc, current_file,
                               current_file, current);
        if (error) {
            break;
        }
    }
    return error;
}
static int reverse_path_check_proc(void *priv, void *cookie, int call_nests)
{
    int error = 0;
    struct file *file = priv;
    struct file *child_file;
    struct epitem *epi;

    list_for_each_entry(epi, &file->f_ep_links, fllink) {
        // ��������file ��epoll
        child_file = epi->ep->file;
        if (is_file_epoll(child_file)) {
            if (list_empty(&child_file->f_ep_links)) {
                // û��������epoll���ӵ�ǰ�����epoll,
                // �Ѿ���Ҷ����
                if (path_count_inc(call_nests)) {
                    error = -1;
                    break;
                }
            } else {
                // �����������epoll �ļ���epoll,
                // �ݹ����
                error = ep_call_nested(&poll_loop_ncalls,
                                       EP_MAX_NESTS,
                                       reverse_path_check_proc,
                                       child_file, child_file,
                                       current);
            }
            if (error != 0) {
                break;
            }
        } else {
            // ����epoll , �����ܰ�?
            printk(KERN_ERR "reverse_path_check_proc: "
                   "file is not an ep!\n");
        }
    }
    return error;
}

static void ep_poll_safewake(wait_queue_head_t *wq)
{
    int this_cpu = get_cpu();

    ep_call_nested(&poll_safewake_ncalls, EP_MAX_NESTS,
                   ep_poll_wakeup_proc, NULL, wq, (void *) (long) this_cpu);

    put_cpu();
}

static int ep_poll_wakeup_proc(void *priv, void *cookie, int call_nests)
{
    ep_wake_up_nested((wait_queue_head_t *) cookie, POLLIN,
                      1 + call_nests);
    return 0;
}

static inline void ep_wake_up_nested(wait_queue_head_t *wqueue,
                                     unsigned long events, int subclass)
{
    // ��ػ����������ڵȴ���epfd ��select/epoll/poll ��
    // ������ѵ���epoll �Ϳ��ܻ���������epoll, ����������Ӧ
    // ����ܿ������ж��������б�����
    wake_up_poll(wqueue, events);
}





// EPOLL_CTL_DEL
static int ep_remove(struct eventpoll *ep, struct epitem *epi)
{
    int error;
    unsigned long flags;
    struct file *file = epi->ffd.file;

    ep_unregister_pollwait(ep, epi);

	// ��f_ep
    spin_lock(&file->f_ep_lock);
    if (ep_is_linked(&epi->fllink)) {
        ep_list_del(&epi->fllink);
    }
    spin_unlock(&file->f_ep_lock);

    /* We need to acquire the write IRQ lock before calling ep_unlink() */
    write_lock_irqsave(&ep->lock, flags);

    /* Really unlink the item from the hash */
    error = ep_unlink(ep, epi);

    write_unlock_irqrestore(&ep->lock, flags);

    if (error) {
        goto eexit_1;
    }

    /* At this point it is safe to free the eventpoll item */
    ep_release_epitem(epi);

    error = 0;
eexit_1:
    DNPRINTK(3, (KERN_INFO "[%p] eventpoll: ep_remove(%p, %p) = %d\n",
                 current, ep, file, error));

    return error;
}

/*
 * This function unregister poll callbacks from the associated file descriptor.
 * Since this must be called without holding "ep->lock" the atomic exchange trick
 * will protect us from multiple unregister.
 */
static void ep_unregister_pollwait(struct eventpoll *ep, struct epitem *epi)
{
    struct list_head *lsthead = &epi->pwqlist;
    struct eppoll_entry *pwq;

    while (!list_empty(lsthead)) {
        // ���ļ�poll wait queue ��ɾ��
        pwq = list_first_entry(lsthead, struct eppoll_entry, llink);

        list_del(&pwq->llink);
        ep_remove_wait_queue(pwq);
        kmem_cache_free(pwq_cache, pwq);
    }
}


/*
 * Modify the interest event mask by dropping an event if the new mask
 * has a match in the current file status.
 */
static int ep_modify(struct eventpoll *ep, struct epitem *epi, struct epoll_event *event)
{
    int pwake = 0;
    unsigned int revents;
    unsigned long flags;

    /*
     * Set the new event interest mask before calling f_op->poll(), otherwise
     * a potential race might occur. In fact if we do this operation inside
     * the lock, an event might happen between the f_op->poll() call and the
     * new event set registering.
     */
    epi->event.events = event->events;

    /*
     * Get current event bits. We can safely use the file* here because
     * its usage count has been increased by the caller of this function.
     */
    revents = epi->ffd.file->f_op->poll(epi->ffd.file, NULL);

    write_lock_irqsave(&ep->lock, flags);

    /* Copy the data member from inside the lock */
    epi->event.data = event->data;

    /*
     * If the item is not linked to the hash it means that it's on its
     * way toward the removal. Do nothing in this case.
     */
    if (ep_rb_linked(&epi->rbn)) {
        /*
         * If the item is "hot" and it is not registered inside the ready
         * list, push it inside. If the item is not "hot" and it is currently
         * registered inside the ready list, unlink it.
         */
        if (revents & event->events) {
            if (!ep_is_linked(&epi->rdllink)) {
                list_add_tail(&epi->rdllink, &ep->rdllist);

                /* Notify waiting tasks that events are available */
                if (waitqueue_active(&ep->wq))
                    __wake_up_locked(&ep->wq, TASK_UNINTERRUPTIBLE |
                                     TASK_INTERRUPTIBLE);
                if (waitqueue_active(&ep->poll_wait)) {
                    pwake++;
                }
            }
        }
    }

    write_unlock_irqrestore(&ep->lock, flags);

    /* We have to call this outside the lock */
    if (pwake) {
        ep_poll_safewake(&psw, &ep->poll_wait);
    }

    return 0;
}





/*
 * ǰ��˵��file.f_op->poll������ͬһ���ļ�file�ϵ�һ������wait_queue_head_t ����ӽڵ�,
 * epoll ��ʵ�־Ϳ��ǵ��˶��wait_queue_head_t �������������f_op->pollʱ��
 * ep_ptable_queue_proc���ܻ���ö�Σ�ÿ�ε��ö�Ӧһ��wait_queue_head_t
 * ����ͬһ��epitem �Ϳ��Թ������е��ļ����롣
 */
static void ep_ptable_queue_proc(struct file *file, wait_queue_head_t *whead,
                                 poll_table *pt)
{
    struct epitem *epi = ep_item_from_epqueue(pt);
    /*
    static inline struct epitem *ep_item_from_epqueue(poll_table *p)
    {
    return container_of(p, struct ep_pqueue, pt)->epi;
    }
    */
    struct eppoll_entry *pwq;

    if (epi->nwait >= 0 && (pwq = kmem_cache_alloc(pwq_cache, GFP_KERNEL))) {
        init_waitqueue_func_entry(&pwq->wait, ep_poll_callback);
        pwq->whead = whead;
        pwq->base = epi;
        add_wait_queue(whead, &pwq->wait);
        list_add_tail(&pwq->llink, &epi->pwqlist);
        epi->nwait++;
    } else {
        /* We have to signal that an error occurred */
        epi->nwait = -1;
    }
}

/*
 * �ļ���������epoll����֪ͨ�ĺ���
 *
 */
static int ep_poll_callback(wait_queue_t *wait, unsigned mode, int sync, void *key)
{
    int pwake = 0;
    unsigned long flags;
    struct epitem *epi = ep_item_from_wait(wait);
    struct eventpoll *ep = epi->ep;

    // �ļ�����POLLFREE �¼�,Ҫ��epoll����ȴ�������ɾ��
    if ((unsigned long)key & POLLFREE) {
        ep_pwq_from_wait(wait)->whead = NULL;
        /*
        static inline struct eppoll_entry *ep_pwq_from_wait(wait_queue_t *p)
        {
        return container_of(p, struct eppoll_entry, wait);
        }
        */
        /*
         * whead = NULL above can race with ep_remove_wait_queue()
         * which can do another remove_wait_queue() after us, so we
         * can't use __remove_wait_queue(). whead->lock is held by
         * the caller.
         */
        list_del_init(&wait->task_list);
    }

    spin_lock_irqsave(&ep->lock, flags);

    // ʲô�¼���û�У�ֱ���˳�
    if (!(epi->event.events & ~EP_PRIVATE_BITS)) {
        goto out_unlock;
    }

    // ���˲�����¼�
    if (key && !((unsigned long) key & epi->event.events)) {
        goto out_unlock;
    }

    /*
     * If we are transferring events to userspace, we can hold no locks
     * (because we're accessing user memory, and because of linux f_op->poll()
     * semantics). All the events that happen during that period of time are
     * chained in ep->ovflist and requeued later on.
     */
    // ep->ovflist ������״̬ep->ovflist == EP_UNACTIVE_PTR//( (void *) -1) ��ʾĿǰû��ɨ������б�
    // ����ep->ovflist != EP_UNACTIVE_PTR//( (void *) -1)����ʾĿǰ����ɨ������б�û�б�Ҫ�ٴλ���
    // ������¼���ӵ�ep->ovflist �ȴ�����ɨ����߳�������
    if (unlikely(ep->ovflist != EP_UNACTIVE_PTR)) {
        if (epi->next == EP_UNACTIVE_PTR) {
            epi->next = ep->ovflist;
            ep->ovflist = epi;
        }
        goto out_unlock;
    }

    // ���뵽�����б�
    if (!ep_is_linked(&epi->rdllink)) {
        list_add_tail(&epi->rdllink, &ep->rdllist);
    }

    // ����epoll_wait
    if (waitqueue_active(&ep->wq)) {
        wake_up_locked(&ep->wq);
    }

    if (waitqueue_active(&ep->poll_wait)) {
        pwake++;
    }

out_unlock:
    spin_unlock_irqrestore(&ep->lock, flags);

    /* We have to call this outside the lock */
    if (pwake) {
        ep_poll_safewake(&ep->poll_wait);
    }

    return 1;
}



/*
epoll_waitʵ��
*/

SYSCALL_DEFINE4(epoll_wait, int, epfd, struct epoll_event __user *, events,
                int, maxevents, int, timeout)
{
    int error;
    struct file *file;
    struct eventpoll *ep;

    // �������������Ч��
    if (maxevents <= 0 || maxevents > EP_MAX_EVENTS) {
        return -EINVAL;
    }

    if (!access_ok(VERIFY_WRITE, events, maxevents * sizeof(struct epoll_event))) {
        error = -EFAULT;
        goto error_return;
    }

    /* Get the "struct file *" for the eventpoll file */
    error = -EBADF;
    file = fget(epfd);
    if (!file) {
        goto error_return;
    }

    error = -EINVAL;
    if (!is_file_epoll(file)) {
        goto error_fput;
    }
    // ȡ��ep �ṹ
    ep = file->private_data;

    // �ȴ��¼�
    error = ep_poll(ep, events, maxevents, timeout);

error_fput:
    fput(file);
error_return:

    return error;
}

static int ep_poll(struct eventpoll *ep, struct epoll_event __user *events,
                   int maxevents, long timeout)
{
    int res = 0, eavail, timed_out = 0;
    unsigned long flags;
    long slack = 0;
    wait_queue_t wait;
    ktime_t expires, *to = NULL;

    if (timeout > 0) {
		// ת��Ϊ�ں�ʱ��
        struct timespec end_time = ep_set_mstimeout(timeout);

        slack = select_estimate_accuracy(&end_time);
        to = &expires;
        *to = timespec_to_ktime(end_time);
    } else if (timeout == 0) {
        // �Ѿ���ʱֱ�Ӽ��readylist
        timed_out = 1;
        spin_lock_irqsave(&ep->lock, flags);
        goto check_events;
    }

fetch_events:
    spin_lock_irqsave(&ep->lock, flags);

    // û�п��õ��¼���ready list ��ovflist ��Ϊ��
    if (!ep_events_available(ep)) {

        // ��ӵ�ǰ���̵Ļ��Ѻ���
        init_waitqueue_entry(&wait, current);
        __add_wait_queue_exclusive(&ep->wq, &wait);

        for (;;) {
            /*
             * We don't want to sleep if the ep_poll_callback() sends us
             * a wakeup in between. That's why we set the task state
             * to TASK_INTERRUPTIBLE before doing the checks.
             */
            set_current_state(TASK_INTERRUPTIBLE);
            if (ep_events_available(ep) || timed_out) {
                break;
            }
            if (signal_pending(current)) {
                res = -EINTR;
                break;
            }

            spin_unlock_irqrestore(&ep->lock, flags);
			// ����ǰ���̣��ȴ����ѻ�ʱ
            if (!schedule_hrtimeout_range(to, slack, HRTIMER_MODE_ABS)) {
                timed_out = 1;
            }

            spin_lock_irqsave(&ep->lock, flags);
        }
	
        __remove_wait_queue(&ep->wq, &wait);

        set_current_state(TASK_RUNNING);
    }
check_events:
    // �ٴμ���Ƿ��п����¼�
    eavail = ep_events_available(ep);

    spin_unlock_irqrestore(&ep->lock, flags);

    /*
     * Try to transfer events to user space. In case we get 0 events and
     * there's still timeout left over, we go trying again in search of
     * more luck.
     */
    if (!res && eavail 
		    && !(res = ep_send_events(ep, events, maxevents)) // �����¼����û��ռ�
            && !timed_out) // �����¼�ʧ�ܲ���û�г�ʱ�����µȴ���
            {
        goto fetch_events;
    }

    return res;
}


static inline int ep_events_available(struct eventpoll *ep)
{
    return !list_empty(&ep->rdllist) || ep->ovflist != EP_UNACTIVE_PTR;
}

struct ep_send_events_data {
    int maxevents;
    struct epoll_event __user *events;
};

static int ep_send_events(struct eventpoll *ep,
                          struct epoll_event __user *events, int maxevents)
{
    struct ep_send_events_data esed;

    esed.maxevents = maxevents;
    esed.events = events;

    return ep_scan_ready_list(ep, ep_send_events_proc, &esed, 0);
}

static int ep_send_events_proc(struct eventpoll *ep, struct list_head *head,
                               void *priv)
{
    struct ep_send_events_data *esed = priv;
    int eventcnt;
    unsigned int revents;
    struct epitem *epi;
    struct epoll_event __user *uevent;

    /*
     * We can loop without lock because we are passed a task private list.
     * Items cannot vanish during the loop because ep_scan_ready_list() is
     * holding "mtx" during this call.
     */
    // �����Ѿ�������
    for (eventcnt = 0, uevent = esed->events;
            !list_empty(head) && eventcnt < esed->maxevents;) {
        epi = list_first_entry(head, struct epitem, rdllink);

        list_del_init(&epi->rdllink);
        // ��ȡready �¼�����
        revents = epi->ffd.file->f_op->poll(epi->ffd.file, NULL) &
                  epi->event.events;

        /*
         * If the event mask intersect the caller-requested one,
         * deliver the event to userspace. Again, ep_scan_ready_list()
         * is holding "mtx", so no operations coming from userspace
         * can change the item.
         */
        if (revents) {
            // �¼�����, ���Ƶ��û��ռ�
            if (__put_user(revents, &uevent->events) ||
                    __put_user(epi->event.data, &uevent->data)) {
                list_add(&epi->rdllink, head);
                return eventcnt ? eventcnt : -EFAULT;
            }
            eventcnt++;
            uevent++;
            if (epi->event.events & EPOLLONESHOT) {
                epi->event.events &= EP_PRIVATE_BITS;
            } else if (!(epi->event.events & EPOLLET)) {
                // ���Ǳ�Եģʽ, �ٴ���ӵ�ready list,
                // �´�epoll_wait ʱֱ�ӽ���˺������ready list�Ƿ���Ȼ����
                list_add_tail(&epi->rdllink, &ep->rdllist);
            }
            // ����Ǳ�Եģʽ, ֻ�е��ļ�״̬�����ı�ʱ,
            // ���ļ����ٴδ���wait_address ��wait_queue�Ļص�����,
        }
    }

    return eventcnt;
}


/*
 * epoll �е���
 * epmutex
 * ep->mtx
 * ep->lock
 */


/*
 * epoll �е���
 * epoll �ļ�poll 
 * �ݹ���ȼ��, ѭ����������, ���ѷ籩����
 * epoll_create, cpoll_ctl, epoll_wait
 */

