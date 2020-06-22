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
		graph.addEdge("A", "D", 5);
		graph.addEdge("B", "C", 3);
		graph.addEdge("C", "D", 1);
		graph.addEdge("D", "E", 8);
		graph.addEdge("E", "F", 5);
		graph.addEdge("E", "G", 6);
		graph.addEdge("F", "G", 4);

		graph.display();
		 System.out.println(graph.numVertex());
				 System.out.println(graph.numEdges());
				 
	
	 System.out.println(graph.hasPath("A", "G", new HashMap<>()));
	 System.out.println(graph.bfs("A", "F"));
	 
	 
	}

}
