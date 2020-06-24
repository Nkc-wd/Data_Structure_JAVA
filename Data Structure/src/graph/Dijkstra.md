It is single source shortest path algorithm .

Always check shortest path which means lowest cost contains path from source Node.


![alt text](https://res.cloudinary.com/nkcloud/image/upload/v1593008714/dks_xjxmld.jpg)


 **what is the difference between Dijkstra's algorithm and BFS while looking for shortest path?**
 
 *Breadth-first search is just Dijkstra's algorithm with all edge weights equal to 1.

 *Dijkstra's algorithm is conceptually breadth-first search that respects edge costs.

 *The process for exploring the graph is structurally the same in both cases. 
 
 
 
 Dijkstra's uses a priority queue data structure to keep track of the frontier of unvisited nodes.
 
 Breadth-first search uses a regular queue data structure.
  
 Operations on a priority queue are O(log n).
   
 Operations on a regular queue are O(1). 
 
 The use of a regular queue in BFS is made possible by all edge weights being 1 
 
 - which makes the regular queue effectively behave as a priority queue.
 
  
  
  ** This Algorithm look likes prims Algorithm**
  
  