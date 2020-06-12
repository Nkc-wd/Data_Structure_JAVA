Like arrays, Linked List is a linear data structure. Unlike arrays, linked list elements are not stored at the contiguous location, the elements are linked using pointers as shown below.

**In Java, LinkedList can be represented as a class and a Node as a separate class. The LinkedList class contains a reference of Node class type.**

Each element in the singly linked list is called a node.
Each node has two components: **data and a pointer** next which points to the next node in the list. 
*The first node of the list is called as head, and the last node of the list is called a tail.* 
**The last node of the list contains a pointer to the null.** 
Each node in the list can be accessed linearly by traversing through the list from head to tail.


**Linked List**

is look like this.
   1 * ==> 2 * ==> 3 * ==> 4
   
>>   node 1 is the head of the list and node 4 is the tail of the list. 
     Each node is connected in such a way that node 1 is pointing to node 2 which in turn pointing to node 3.
     Node 3 is again pointing to node 4. Node 4 is pointing to null as it is the last node of the list.


Where,

>> HEAD
   Is a head link node address of item data

>> TAIL
  Is a tail link node address of item data
  
 To connect one item data to second data item in Linkedlist One item's tail link connect with second's head link
 
 **display**
 
 We first take a temp node link which will be equal to current head
 And in while loop print temp link's data which is means current head data till
 temp is not null.
 
 After print temp link's data temp need to assign to next head as temp.next
 
 
 
 
   