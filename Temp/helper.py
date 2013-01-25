#!/bin/env python
import simplejson;

f = open('AMsymbol', 'r')

s = f.read(-1)
j = simplejson.loads(str(s))
d = {}

d2 = {}
d3 = {}
for i in j:
    t = i["ttype"]
    if d.has_key(t) == False:
        d[t] = [i]
    else:
        d[t].append(i)


for i in d:
    print "========%s========" %(i)
    for k in d[i]:
        print "\t|'%s'\t|'%s'\t|'%s'" %(k["tex"],k["input"],k["output"])

for i in j:
    output = i["output"]
    d2[i["output"]] = i["output"]
    d3[i["output"]] = i["input"]
    if i["tex"] != None:
        d2[i["tex"]] = i["output"]
    d2[i["input"]] = i["output"]

for i in d2:
    d2[i] = d3[d2[i]]

for i in 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ':
    d2[i]=i
print d2

