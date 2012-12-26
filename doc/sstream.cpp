

template<typename _CharT, typename _Traits, typename _Alloc>
class basic_stringbuf : public basic_streambuf<_CharT, _Traits>
{
public:
    // Types:
    typedef _CharT 					    char_type;
    typedef _Traits 					traits_type;

    typedef _Alloc				       	allocator_type;
    typedef typename traits_type::int_type 		int_type;
    typedef typename traits_type::pos_type 		pos_type;
    typedef typename traits_type::off_type 		off_type;

    typedef basic_streambuf<char_type, traits_type>  	__streambuf_type;
    typedef basic_string<char_type, _Traits, _Alloc> 	__string_type;
    typedef typename __string_type::size_type		    __size_type;

protected:
    /// Place to stash in || out || in | out settings for current stringbuf.
    ios_base::openmode 	_M_mode;

    // Data Members:
    __string_type 		_M_string;

public:
    // Constructors:
    /**
     *  @brief  Starts with an empty string buffer.
     *  @param  __mode  Whether the buffer can read, or write, or both.
     *
     *  The default constructor initializes the parent class using its
     *  own default ctor.
    */
    explicit
    basic_stringbuf(ios_base::openmode __mode = ios_base::in | ios_base::out)
        : __streambuf_type(), _M_mode(__mode), _M_string()
    { }

    /**
     *  @brief  Starts with an existing string buffer.
     *  @param  __str  A string to copy as a starting buffer.
     *  @param  __mode  Whether the buffer can read, or write, or both.
     *
     *  This constructor initializes the parent class using its
     *  own default ctor.
    */
    explicit
    basic_stringbuf(const __string_type& __str,
                    ios_base::openmode __mode = ios_base::in | ios_base::out)
        : __streambuf_type(), _M_mode(), _M_string(__str.data(), __str.size()) {
        _M_stringbuf_init(__mode);
    }

    // Get and set:
    /**
     *  @brief  Copying out the string buffer.
     *  @return  A copy of one of the underlying sequences.
     *
     *  <em>If the buffer is only created in input mode, the underlying
     *  character sequence is equal to the input sequence; otherwise, it
     *  is equal to the output sequence.</em> [27.7.1.2]/1
    */
    __string_type
    str() const {
        __string_type __ret;
        if (this->pptr()) {
            // The current egptr() may not be the actual string end.
            if (this->pptr() > this->egptr()) {
                __ret = __string_type(this->pbase(), this->pptr());
            } else {
                __ret = __string_type(this->pbase(), this->egptr());
            }
        } else {
            __ret = _M_string;
        }
        return __ret;
    }

    /**
     *  @brief  Setting a new buffer.
     *  @param  __s  The string to use as a new sequence.
     *
     *  Deallocates any previous stored sequence, then copies @a s to
     *  use as a new one.
    */
    void
    str(const __string_type& __s) {
        // Cannot use _M_string = __s, since v3 strings are COW.
        _M_string.assign(__s.data(), __s.size());
        _M_stringbuf_init(_M_mode);
    }

protected:
    // Common initialization code goes here.
    void
    _M_stringbuf_init(ios_base::openmode __mode) {
        _M_mode = __mode;
        __size_type __len = 0;
        if (_M_mode & (ios_base::ate | ios_base::app)) {
            __len = _M_string.size();
        }
        _M_sync(const_cast<char_type*>(_M_string.data()), 0, __len);
    }

    virtual streamsize
    showmanyc() {
        streamsize __ret = -1;
        if (_M_mode & ios_base::in) {
            _M_update_egptr();
            __ret = this->egptr() - this->gptr();
        }
        return __ret;
    }

    virtual int_type
    underflow();

    virtual int_type
    pbackfail(int_type __c = traits_type::eof());

    virtual int_type
    overflow(int_type __c = traits_type::eof());

    /**
     *  @brief  Manipulates the buffer.
     *  @param  __s  Pointer to a buffer area.
     *  @param  __n  Size of @a __s.
     *  @return  @c this
     *
     *  If no buffer has already been created, and both @a __s and @a __n are
     *  non-zero, then @c __s is used as a buffer; see
     *  http://gcc.gnu.org/onlinedocs/libstdc++/manual/bk01pt11ch25s02.html
     *  for more.
    */
    virtual __streambuf_type*
    setbuf(char_type* __s, streamsize __n) {
        if (__s && __n >= 0) {
            // This is implementation-defined behavior, and assumes
            // that an external char_type array of length __n exists
            // and has been pre-allocated. If this is not the case,
            // things will quickly blow up.

            // Step 1: Destroy the current internal array.
            _M_string.clear();

            // Step 2: Use the external array.
            _M_sync(__s, __n, 0);
        }
        return this;
    }

    virtual pos_type
    seekoff(off_type __off, ios_base::seekdir __way,
            ios_base::openmode __mode = ios_base::in | ios_base::out);

    virtual pos_type
    seekpos(pos_type __sp,
            ios_base::openmode __mode = ios_base::in | ios_base::out);

    // Internal function for correctly updating the internal buffer
    // for a particular _M_string, due to initialization or re-sizing
    // of an existing _M_string.
    void
    _M_sync(char_type* __base, __size_type __i, __size_type __o);

    // Internal function for correctly updating egptr() to the actual
    // string end.
    void
    _M_update_egptr() {
        const bool __testin = _M_mode & ios_base::in;
        if (this->pptr() && this->pptr() > this->egptr()) {
            if (__testin) {
                this->setg(this->eback(), this->gptr(), this->pptr());
            } else {
                this->setg(this->pptr(), this->pptr(), this->pptr());
            }
        }
    }

    // Works around the issue with pbump, part of the protected
    // interface of basic_streambuf, taking just an int.
    void
    _M_pbump(char_type* __pbeg, char_type* __pend, off_type __off);
};