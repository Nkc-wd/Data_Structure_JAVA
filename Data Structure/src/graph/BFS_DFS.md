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


![alt text](https://res.cloudinary.com/nkcloud/image/upload/v1592799843/graph_f6g7da.png)

Node : A  B  C  D  E  F  G

Path: A AB AD  ABC ADE ADEF ADEG

HashMap: A  B  C  D  E  F  G  H


**Remember only bfs is give shortest path not dfs**


**Depth First Search (DFS) Algorithm**


Depth first search (DFS) algorithm starts with the initial node of the graph G,

 and then goes to **deeper and deeper until we find the goal node or the node which has no children. **
 
 The algorithm, then backtracks from the dead end towards the most recent node that is yet to be completely unexplored.

**The data structure which is being used in DFS is stack.**

The process is similar to BFS algorithm.
 
In DFS, the edges that leads to an unvisited node are called discovery edges while the edges that leads to an already visited node are called block edges.

![alt text](https://res.cloudinary.com/nkcloud/image/upload/v1592799843/graph_f6g7da.png)



|G|ADFG| >> Here the graph traverse all nbh of Node G first then come back for Node F 

|F|ADEF|

|E|ADE | >> Here the graph traverse all nbh of Node E first then come back for Node C

|C|ADC |

|D|AD  | >> Here the graph traverse all nbh of Node D first then come back for Node B

|B|AD  |

|A|A   |


HashMap : A  D  E  G  F  C  B 
