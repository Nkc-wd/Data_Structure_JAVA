package graph;

import java.util.ArrayList;
import java.util.HashMap;

import generic_hashmap.LinkedList;
import heap.HeapGeneric;

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

	public void removeVertex(String vname) {
		// we cant simply remove vertex we need to remove from nbrs of his vertex
		/*   1. get that all nbrs
	          2. Then visit on nbrs and remove from there
	          3. then remove that vertex from HM of vtces
		 */

		Vertex vtx=vtces.get(vname);  // 1.
		ArrayList<String> keys=new ArrayList<>(vtx.nbrs.keySet()); // List of all keys get

		for(String key:keys) {
			Vertex nbrVtx=vtces.get(key); //2.  // get that address
			nbrVtx.nbrs.remove(key);  // loop will go and remove from nbrs
		}

		vtces.remove(vname); //3.


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
			count=count+vtx.nbrs.size();// vtx nbrs give individual HM size and add with count
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

	// Add Edge bw to given vertex with edge as cost integer
	public void addEdge(String vname1,String vname2,int cost) {
		Vertex vtx1=vtces.get(vname1); // vertex 1 found
		Vertex vtx2=vtces.get(vname2);  // vertex 2 found

		// let vertex's given by user not exist and second vertex is not in nbrs then must return false

		if(vtx1==null || vtx2==null || vtx1.nbrs.containsKey(vname2)) { // if vtx1 nbrs already contains vname2
			// it means there is already edge
			return;  // then no need to add edge bw them simply return 
		}

		// else valid then
		vtx1.nbrs.put(vname2, cost); //  vtx1 nbrs put vname 2 with given cost
		vtx2.nbrs.put(vname1, cost); //  vtx2 nbrs put vname 1 with given cost

	}

	public void removeEdge(String vname1, String vname2) {
		Vertex vtx1=vtces.get(vname1); // vertex 1 found
		Vertex vtx2=vtces.get(vname2);  // vertex 2 found

		// let vertex's given by user not exist and second vertex is not in nbrs then must return false

		if(vtx1==null || vtx2==null || !vtx1.nbrs.containsKey(vname2)) {
			return;  // if not present then return 
		}

		vtx1.nbrs.remove(vname2);  // removed vtx1 nbrs of given vname2
		vtx2.nbrs.remove(vname1); //  removed vtx2 nbrs of given vname1

		// And remember for remove from HM we need only key as vertex here value be self delete

	}

	public void display() {

		System.out.println("------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet()); //all keys as vertex in ARL

		for (String key : keys) {

			Vertex vtx = vtces.get(key);// get that key's address

			System.out.println(key+" : "+vtx.nbrs);  // print that key with address's nbrs HM
		}
		System.out.println("------------------");

	}	

	public boolean hasPath(String vname1,String vname2,HashMap<String,Boolean> processed) {

		// Here processed HM is use for if once A note visited not go for second time
		// otherwise recursion work infinte time

		if(ContainsEdge(vname1,vname2)) {  // it will simply check there is direct edge present or not
			return true;
		}

		// Store in HM as vname1 as key with true value
		processed.put(vname1, true);

		Vertex vtx=vtces.get(vname1);
		ArrayList<String> nbrs=new ArrayList<>(vtx.nbrs.keySet()); // vtx address's nbr vertx contains nbrs ARL
		for(String nbr:nbrs) {
			if(!processed.containsKey(nbr)&& hasPath(nbr,vname2,processed)) { // check if nbr key not present in procesed HM then give true
				return true;
			}
		}

		return false;  // if not find at all then false

	}



	private class Pair{   // A private Pair class 

		String vname;    // string as vertex
		String psf;        // string path so far
	}





	// the bfs will be boolean type method that output will tell there is path or not as searching
	public boolean bfs (String src ,String dst) throws Exception {
		HashMap<String, Boolean> processed = new HashMap<>(); // HM for visit only node once 

		LinkedList<Pair> queue = new LinkedList<>(); // Here we take queue as doubly generic linked list as 

		// create a new pair
		Pair sp=new Pair(); // starting pair
		sp.vname=src;  // Starting pair's node is source
		sp.psf=src; //  Starting pair's path so far is source

		// put the last new pair in queue

		queue.addLast(sp);

		// while queue is not empty keep on doing the work
		while(!queue.isEmpty()) {

			// remove a pair from queue
			Pair rp=queue.removeFirst();  // remove pair


			// if a vertex already in HM then continue for next iteration
			if(processed.containsKey(rp.vname)) {
				continue;
			}

			// put in proceeses HM
			processed.put(rp.vname, true);

			// direct edge

			if(ContainsEdge(rp.vname,dst)) { // if there is direct edge means path bw remove pair and dst then return true 
				System.out.println("The Shortest Path is: "+rp.psf + dst); // will give path bw src to dst as string
				return true;
			}


			// if not direct edge then explore nbrs
			Vertex rpvtx=vtces.get(rp.vname); // remove pair vertex
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet()); // store the vertex in nbrs ARL

			for(String nbr:nbrs) { // loop in nbrs

				// process only unprocessed nbrs
				if(!processed.containsKey(nbr)) {  //if nbr not in processed HM 
					// then only it will avoid to traverse each node from second time	

					// make a new pair of nbr and put in queue
					Pair np=new Pair();
					np.vname=nbr;  // new pair's vertex is currently nbr (in loop nbr will change)
					np.psf=rp.psf+nbr;   // new pair's path so far = remove pair's pasf+ currently nbr

					// After all add this new pair in queue(as LL) atLast
					queue.addLast(np);
				}

			}
		}

		// if not contains edge or search found
		return false;

	}



	// the dfs will be boolean type method that output will tell there is path or not as searching
	public boolean dfs (String src ,String dst) throws Exception {
		HashMap<String, Boolean> processed = new HashMap<>(); // HM for visit only node once 

		LinkedList<Pair> stack = new LinkedList<>(); // Here we take stack as doubly generic linked list as 


		// create a new pair
		Pair sp=new Pair(); // starting pair
		sp.vname=src;  // Starting pair's node is source
		sp.psf=src; //  Starting pair's path so far is source

		// put the last new pair in stack

		stack.addFirst(sp);

		// while stack is not empty keep on doing the work
		while(!stack.isEmpty()) {

			// remove a pair from queue
			Pair rp=stack.removeFirst();  // remove pair


			// if a vertex already in HM then continue for next iteration
			if(processed.containsKey(rp.vname)) {
				continue;
			}

			// put in proceeses HM
			processed.put(rp.vname, true);

			// direct edge

			if(ContainsEdge(rp.vname,dst)) { // if there is direct edge means path bw remove pair and dst then return true 
				System.out.println("Path is: "+rp.psf + dst); // will give path bw src to dst as string
				return true;
			}


			// if not direct edge then explore nbrs
			Vertex rpvtx=vtces.get(rp.vname); // remove pair vertex
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet()); // store the vertex in nbrs ARL

			for(String nbr:nbrs) { // loop in nbrs

				// process only unprocessed nbrs
				if(!processed.containsKey(nbr)) {  //if nbr not in processed HM 
					// then only it will avoid to traverse each node from second time	

					// make a new pair of nbr and put in stack
					Pair np=new Pair();
					np.vname=nbr;  // new pair's vertex is currently nbr (in loop nbr will change)
					np.psf=rp.psf+nbr;   // new pair's path so far = remove pair's pasf+ currently nbr

					// After all add this new pair in stack(as LL) atFirst
					stack.addFirst(np);
				}

			}
		}

		// if not contains edge or search found
		return false;

	}

	// the bft will be void type method that output will tell there is path or not as searching
	public void bft () throws Exception {  // No source and dst vertex  it will trasverse in entire graph

		HashMap<String, Boolean> processed = new HashMap<>(); // HM for visit only node once 

		LinkedList<Pair> queue = new LinkedList<>(); // Here we take queue as doubly generic linked list as 
		ArrayList<String> keys=new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for(String key:keys) {

			// If Graph is disconnected 
			if(processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp=new Pair(); // starting pair
			sp.vname=key;  // Starting pair's node is source
			sp.psf=key; //  Starting pair's path so far is source

			// put the last new pair in queue

			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while(!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp=queue.removeFirst();  // remove pair


				// if a vertex already in HM then continue for next iteration
				if(processed.containsKey(rp.vname)) {
					continue;
				}

				// put in proceeses HM
				processed.put(rp.vname, true);

				// syso

				System.out.println(rp.vname+" via "+rp.psf);


				// if not direct edge then explore nbrs
				Vertex rpvtx=vtces.get(rp.vname); // remove pair vertex
				ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet()); // store the vertex in nbrs ARL

				for(String nbr:nbrs) { // loop in nbrs

					// process only unprocessed nbrs
					if(!processed.containsKey(nbr)) {  //if nbr not in processed HM 
						// then only it will avoid to traverse each node from second time	

						// make a new pair of nbr and put in queue
						Pair np=new Pair();
						np.vname=nbr;  // new pair's vertex is currently nbr (in loop nbr will change)
						np.psf=rp.psf+nbr;   // new pair's path so far = remove pair's pasf+ currently nbr

						// After all add this new pair in queue(as LL) atLast
						queue.addLast(np);
					}

				}
			}

		}


	}


	// the dft will be void type method that output will tell there is path or not as searching
	public void dft () throws Exception {  // No source and dst vertex  it will trasverse in entire graph

		HashMap<String, Boolean> processed = new HashMap<>(); // HM for visit only node once 

		LinkedList<Pair> stack = new LinkedList<>(); // Here we take stack as doubly generic linked list as 
		ArrayList<String> keys=new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for(String key:keys) {

			// to avoid that which is already in HM
			if(processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp=new Pair(); // starting pair
			sp.vname=key;  // Starting pair's node is source
			sp.psf=key; //  Starting pair's path so far is source

			// put the last new pair in queue

			stack.addFirst(sp);

			// while stack is not empty keep on doing the work
			while(!stack.isEmpty()) {

				// remove a pair from queue
				Pair rp=stack.removeFirst();  // remove pair


				// if a vertex already in HM then continue for next iteration
				if(processed.containsKey(rp.vname)) {
					continue;
				}

				// put in proceeses HM
				processed.put(rp.vname, true);

				// syso

				System.out.println(rp.vname+" via "+rp.psf);


				// if not direct edge then explore nbrs
				Vertex rpvtx=vtces.get(rp.vname); // remove pair vertex
				ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet()); // store the vertex in nbrs ARL

				for(String nbr:nbrs) { // loop in nbrs

					// process only unprocessed nbrs
					if(!processed.containsKey(nbr)) {  //if nbr not in processed HM 
						// then only it will avoid to traverse each node from second time	

						// make a new pair of nbr and put in queue
						Pair np=new Pair();
						np.vname=nbr;  // new pair's vertex is currently nbr (in loop nbr will change)
						np.psf=rp.psf+nbr;   // new pair's path so far = remove pair's pasf+ currently nbr

						// After all add this new pair in stack(as LL) atLast
						stack.addFirst(np);
					}

				}
			}

		}


	}



	// If there is any cyclic loop present in graph then Graph will be cyclic

	/* Logic in bft ,while loop if processed HashMap contains remove pair 
	 * it means that remove is already in processed HashMap 
	 * that means it is forming a cycle loop in graph, so
	 * just return true otherwise after loop return false

	 */



	public boolean isCyclic () throws Exception {  // No source and dst vertex  it will trasverse in entire graph

		HashMap<String, Boolean> processed = new HashMap<>(); // HM for visit only node once 

		LinkedList<Pair> queue = new LinkedList<>(); // Here we take queue as doubly generic linked list as 
		ArrayList<String> keys=new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for(String key:keys) {

			// If Graph is disconnected 
			if(processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp=new Pair(); // starting pair
			sp.vname=key;  // Starting pair's node is source
			sp.psf=key; //  Starting pair's path so far is source

			// put the last new pair in queue

			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while(!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp=queue.removeFirst();  // remove pair


				// if a vertex already in HM then continue for next iteration
				if(processed.containsKey(rp.vname)) {
					return true;
				}

				// put in proceeses HM
				processed.put(rp.vname, true);


				// if not direct edge then explore nbrs
				Vertex rpvtx=vtces.get(rp.vname); // remove pair vertex
				ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet()); // store the vertex in nbrs ARL

				for(String nbr:nbrs) { // loop in nbrs

					// process only unprocessed nbrs
					if(!processed.containsKey(nbr)) {  //if nbr not in processed HM 
						// then only it will avoid to traverse each node from second time	

						// make a new pair of nbr and put in queue
						Pair np=new Pair();
						np.vname=nbr;  // new pair's vertex is currently nbr (in loop nbr will change)
						np.psf=rp.psf+nbr;   // new pair's path so far = remove pair's pasf+ currently nbr

						// After all add this new pair in queue(as LL) atLast
						queue.addLast(np);
					}

				}
			}

		}

		return false;
	}


	// isConnected that means entire graph is connected No Node is alone

	/* Logic
	 * If Graph is disconnected then we must come 
	 * 2 times in graph disconnected continue region 
	 * so set a flag and count when it comes that region
	 * if flag is >= 2 then graph is disconnected
	 * means false for isConnected and true for flag <=2
	 */

	public boolean isConnected() throws Exception {

		int flag = 0;

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++;

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

		if (flag >= 2) {
			return false;
		} else {
			return true;
		}

	}


	// isTree that means graph not be cyclic and must be Connected
	/* Logic
	 * Just check for not cyclic as !isCyclic and for Connected as isConnected
	 */

	public boolean isTree() throws Exception {
		return !isCyclic() && isConnected(); 
	}


	//getCC that means get the Connected component of graph in a ArrayList
	/* Logic
	 * We will make a method of ArL return type that also contains a ArL
	 * like ArrayList<ArrayList<String>>
	 * and store the connected Node as in individual ArL of One ArL
	 */
	// type
	public ArrayList<ArrayList<String>> getCC() throws Exception {

		// ans ArL to store all individual ArL 
		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// for new component create a new arrayList
			ArrayList<String> subans = new ArrayList<>();

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// put in subans arraylist
				subans.add(rp.vname);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

			// put subans in final ans
			ans.add(subans);

		}
		// After adding all suband ArL retun ans ArL
		return ans;

	}

	
	
	// Pair for heap                              // bounds set
	private class PrimsPair implements Comparable<PrimsPair> {
		// Comparable is a interface in which we have to give body for interface method
		
		String vname;   // vertex
		String acqvname;   // aquire vertex
		int cost;		// cost
		
		// interface method
		@Override
		public int compareTo(PrimsPair o) {
		  return o.cost-this.cost;  // other cost - this cost
		}
	}
	
	
	public Graph prims() {
		// we need make sapnning tree and return
		// mst will be contains all property of Graph class
		Graph mst =new Graph();
		HashMap<String,PrimsPair> map=new HashMap<>();
		
		// we need implements Comparable for HeapGeneric
		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();
		
		// make a pair and put in heap and map 
		for(String key:vtces.keySet()) {
			 
			// create a new pair
			PrimsPair np=new PrimsPair();
			np.vname=key;   // np's vertex
			
			np.acqvname=null; // np's Acquire vertex

			np.cost=Integer.MAX_VALUE; // np's cost currently is oo
			
			heap.add(np);  // new pair added in heap
			map.put(key, np);  // new pair with currently key puted in map
			
		}
		 // till the heap is not empty keep on removing the pairs
		while(!heap.isEmpty()) {
			
			// remove a pair
			PrimsPair rp=heap.remove();  // from heap
			map.remove(rp.vname); // from HM with use of remove pair's vertex as key
		
		     // add to mst
			if(rp.acqvname==null) {
				mst.addVertex(rp.vname);
			}else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname,rp.acqvname, rp.cost);
			}
			
			//nbrs
			
			for(String nbr:vtces.get(rp.vname).nbrs.keySet()) {
				  
				// work for nbrs which are in heap
				if(map.containsKey(nbr)) {
					
					int oc=map.get(nbr).cost; // old cost
					
					int nc=vtces.get(rp.vname).nbrs.get(nbr); // new cost
				
					// update the pair only when nc < oc
					if(nc<oc) {
						PrimsPair gp=map.get(nbr); // get pair
						gp.acqvname=rp.vname;
						
						gp.cost=nc;
						
						heap.updatePriority(gp);
						
					}
				
				
				}
			}
		
		}
		
		
		return mst;
		
	}
	
	
	
	
	
	
}





























