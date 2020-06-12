***Points to remember***

Stack fallows LIFO( Last in First out) property 

it means the last one add or push element will be remove first on pop operation

Queue fallows FIFO( First in First Out) property

it means that first element add in queue will be remove first 

for understand in stack the rightmost element will be remove

and in queue the leftmost element will be remove.


***Stack display***
We need to print stack data array in reverse order with for loop to make look like stack

start from top index to 0 index means

i=this.top to i>=0 and i---

print this.data[i]

***Queue available index***

We need to find  available index  in queue data array to add element and display the element

>>> in enqueue

 available index = (this.front+this.size)% this.data.length
 
 assign data array index as this.data[ available index  ]=...
 
 ***Queue available index on dequeue***
 
 this.front = (this.front + 1) % this.data.length;
 
 ***Queue display***
 
 We will print queue data array in linear order with look like queue
 
 but we need find available index and print as per this
 
 available index =(this.front + i) % this.data.length;
 
 print data array as this.data[ available index  ]
 