      **Internal Structure of HashMap**

Internally HashMap contains an array of Node and a node is represented as a class which contains 4 fields:

int hash

K key

V value
Node next

It can be seen that node is containing a reference of its own object. So it’s a linked list.

HashMap:

|__||__||__||__|
  |               
Node[0]
                 