**Java Heap**

In Java, a heap is a chunk of memory which is shared among all threads. 

In a heap, all class instances and the array is allocated. 

It is created when JVM starts-up. An automatic storage management system reclaims heap.
 
It may be of fixed and variable size. It does not need to be contiguous. 

* A Heap is a special Tree-based data structure in which the tree is a complete binary tree.

 Generally, Heaps can be of two types:

>> Max-Heap:

 In a Max-Heap the key present at the root node must be greatest among the keys present at all of it’s children. 
 
 The same property must be recursively true for all sub-trees in that Binary Tree.
 
>> Min-Heap:
 
In a Min-Heap the key present at the root node must be minimum among the keys present at all of it’s children. 

The same property must be recursively true for all sub-trees in that Binary Tree.

**To reduce time complexities in add/remove and get**

* ADD  == > O(log n)

* REMOVE ==>  O(log n)

* GET  ==>  O(1)

**Note**

* For min heap it must fallow the rule of min priority of root node and must be a complete binary tree.

** Always fill heap tree from left to right**



