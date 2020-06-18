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

HashTable contains Array of LinkedList

We need hashing for each pair of HashMap that will generate a integer type code After passing through HASH FUNCTION

And this code assign that pair's location in linked list of array

Then we must find that code's absolute value because it may be negative

And then modulo by bucket array length it will be give linked list array position in given array range.

Let code = -996

abs(996) =996

996%5(array length) = 1

means 1 index of array of linked list 

**To reduce time complexity as O(1) **

use lambda

load factor=> lambda

lambda =(size)*1.0/arr.length;

if(lambda>2){

rehash();

}

Rehashing of a hash map is done when the number of elements in the map reaches the maximum threshold value.

 ... Basically when rehashing occurs the number of buckets are approximately doubled 
 
 and hence the new index at which the value has to be put changes
 
*Why rehashing? *

Rehashing is done because whenever key value pairs are inserted into the map, 

the load factor increases, which implies that the time complexity also increases as explained above.

 ... Hence, rehash must be done,
 
increasing the size of the bucketArray so as to reduce the load factor and the time complexity. 


                 