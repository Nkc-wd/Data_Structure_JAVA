package graph;

import java.util.HashMap;

public class Graph_User {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 6);
		graph.addEdge("B", "C", 3);
		graph.addEdge("C", "D", 1);
		graph.addEdge("D", "E", 8);
		graph.addEdge("E", "F", 5);
		graph.addEdge("E", "G", 7);
		graph.addEdge("F", "G", 9);

		graph.display();
		 System.out.println("No. of vertices in given Graph: "+graph.numVertex());
				 System.out.println("No. of Edges in given Graph: "+graph.numEdges());
				 
	
	 System.out.println("Has Path between given Node: "+graph.hasPath("A", "G", new HashMap<>()));
	 System.out.println("BFS of given node: "+graph.bfs("A", "F"));
	 System.out.println("DFS of given node: "+graph.dfs("A", "X"));
	 System.out.println();
	 graph.bft();
	 System.out.println();
	 graph.dft();
	 System.out.println();
	 graph.removeEdge("B","C");
	 graph.removeEdge("F","G");
	 System.out.println("Is Given Graph is cyclic: "+ graph.isCyclic());
	 System.out.println();
	 System.out.println("Is Given Graph is Connected: "+graph.isConnected());
	 System.out.println();
	 System.out.println("Is Given graph is a Tree: "+graph.isTree());
	 System.out.println();
//	 graph.removeEdge("D","E");
	 System.out.println("The Connected component in given graph is: "+graph.getCC());
	 System.out.println();
	 System.out.println("Graph's Prims display: ");
	 graph.prims().display();
	 System.out.println();
	 System.out.println("Graph on dijkstra Algorithm: ");
	 System.out.println(graph.dijkstra("A"));
	 
	}

}
