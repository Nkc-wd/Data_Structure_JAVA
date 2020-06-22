Traversing the graph means examining all the nodes and vertices of the graph.

There are two standard methods by using which, we can traverse the graphs.

Lets discuss each one of them in detail.

* Breadth First Search

* Depth First Search 

**Breadth First Search (BFS) Algorithm**

Breadth first search is a graph traversal algorithm that starts traversing the graph from root node and explores all the neighbouring nodes.

Then, it selects the nearest node and explore all the unexplored nodes. 

The algorithm follows the same process for each of the nearest node until it finds the goal.

The algorithm explores all neighbours of all the nodes

and ensures that **each node is visited exactly once and no node is visited twice.**

The Queue structure is use for BFS.


 <p align="center"> ![alt text](https://res.cloudinary.com/nkcloud/image/upload/v1592799843/graph_f6g7da.png) </p>

Node : A  B  C  D  E  F  G

Path: A AB AD  ABC ADE ADEF ADEG

HashMap: A  B  C  D  E  F  G  H



