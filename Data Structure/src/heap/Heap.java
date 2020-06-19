package heap;

import java.util.ArrayList;

public class Heap {
	
	ArrayList<Integer> data =new ArrayList<>(); // to store in Arraylist bcoz of dynamic array
	
	public void add(int item) {  // add method
		data.add(item); // ArL property to add item
		upheapify(data.size()-1);  // upheapify on ArL size-1
	}
	
	private void upheapify(int ci) {  // child index
		
		int pi=(ci-1)/2; // parent index
		if(data.get(ci)<data.get(pi)) { // child index value is smaller than parent index
		  swap(pi,ci); // then must be swap	
		  upheapify(pi); // recursion to complete for all
		}
		
		
		
		// Since there is strict less than condition hence no need of base case for recursion
	}
	//swap required bcoz we need root node must less than child
	private void swap(int i ,int j) {  // swap method
		int ith=data.get(i); //  get value on ith index
		int jth =data.get(j); // get value on jth index
		
		data.set(i, jth); // set on i index to jth value
		data.set(j, ith); // set on j index to ith value
		         // swap
		
	}
	
	
	public void display() {
		System.out.println(data);   // display method
	}
	
	
	public int size() {
		return this.data.size();   // size method
	}
	
	
	public boolean isEmpty() {
		return this.size()==0;    // is Empty check
	}
	
	
	
	// for remove data from heap  we need priority data from heap tree
	public int remove() {
		swap(0,this.data.size()-1); // for remove swap the first and last index of ArL
	    int rv=this.data.remove(this.data.size()-1);// retrieve value of remove data by ArL property
	
	    downheapify(0);
	    
	    return rv;
	}

	private void downheapify(int pi) {
		int lci=2*pi+1; // left child index
		int rci=2*pi+2;  // right child index
		
		int min_i=pi; // assumed pi is min_ i
		
		// if lci is less than ArL size and data on lci is less than min_i
		if (lci < this.data.size() && data.get(lci) < data.get(min_i)) { 
			// then min_i need to update as lci
			min_i = lci;
		}
           
		// if rci is less than ArL size and data on rci is less than min_i
		if (rci < this.data.size() && data.get(rci) < data.get(min_i)) {
			// then min_i need to update as rci
			min_i = rci;
		}
         
		// After updation if min_i is not equal to parent index 
		if (min_i != pi) {
			swap(min_i, pi);  // then swap them
			downheapify(min_i);  // and call recursion for do all
		}
		
		
		
	}
	public int get() {  // To give top priority data in heap
		return this.data.get(0);
	}
	

}
