package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	
	private class Vertex{  // for vertices
		HashMap<String,Integer> nbrs=new HashMap<>();
	}
	
	HashMap<String,Vertex> vtces;
	 
	public Graph() {   // Constructors
		vtces= new HashMap<>();
	}
	
	public int numVertex() { // how many vertex in graph
		return this.vtces.size();  // size of vtces hashmap will give no of vertices
	}
	
	public boolean containsVertex(String vname) { //  to check that given vextex is present or not
		return this.vtces.containsKey(vname); // with property of HM to check containsKey vertex(as key) or not
	}
	
	public void addVertex(String vname) { // To add vertex
		// as we know for add key in HM we need value and edge here
		// so here we will make a new HM A separate HM for newly added vertex with no connected edge
		// Make Vertex class first
		Vertex vtx = new Vertex();
		
		vtces.put(vname, vtx);  // empty hashMap puted
		
	}

	
	public int numEdges() { // to give number of edges in Graph
		// It may be that vertex is alone without edge so can't return vtces size only
		// Each vertex's individual HashMap size calc 
		// and edge may be include in others vertex's edge also
		// then to find exact no. of edges in graph just divide by 2 of total calc edge
		
	  ArrayList<String> keys=new ArrayList<>(vtces.keySet()); // for keys(As vertices)
	  
	  int count=0;
	  for(String key:keys) {
		  Vertex vtx=vtces.get(key); // vertex find
		  count+=vtx.nbrs.size();// vtx nbrs give individual HM size and add with count
	  }
	  return count/2;
	}
	
	
	// It will tell that there is edge bw two given vertex or not
	public boolean ContainsEdge(String vname1,String vname2) {
		Vertex vtx1=vtces.get(vname1); // vertex 1 found
		Vertex vtx2=vtces.get(vname2);  // vertex 2 found
		
		// let vertex's given by user not exist and second vertex is not in nbrs then must return false
		
		if(vtx1==null || vtx2==null || !vtx1.nbrs.containsKey(vname2)) {
				return false;
		}
		
		return true;   // else return true 
		
		
	}
}






























