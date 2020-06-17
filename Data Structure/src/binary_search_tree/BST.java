package binary_search_tree;  

public class BST {
	
	
	private class Node{
		int data;         // data 
		Node left;       // left address
		Node right;          // right address

//		Note: Here we do not need of data one by one by user 
//	     array pass by user during BST class call
	// Hence No Node class constructor require
	}

	
	private Node root;      // root address access by BST class
	
	
	BST(int[] arr){   // BST class constructor with parameter array 
		this.root=construct(arr,0,arr.length-1);  // binary search tree by given array 
		                                   // by index 0 as low and till array size-1 high
	}


	private Node construct(int[] arr, int low, int high) {   // with data low as 0 high as size-1(initially)
		if(low>high) {                 // if low is greater than high     
			return null;   // then return       ( Recursion base condition)
		}
		
		int mid=(low+high)/2;  // find mid 
		
		Node newnode=new Node();  // create new node
		newnode.data=arr[mid];   // assigned new node data as mid element data of array
		                                // To set parent root node of bst
		
		// Recursion to construct all left and right child of tree
		
		newnode.left=construct(arr,low,mid-1);  // left child condition
		newnode.right=construct(arr,mid+1,high);  // right child condition 
		
		return newnode;  // return the new node
		
		
	}
	
	
	// To display
	
	public void display() {
		this.display(this.root);   // set from root node to display
	}


	private void display(Node node) {
		if(node==null) {
			return;                // if node null then return ( Recursion base condition)
		}
		
		// self work
				String str = "";

				if (node.left == null) {   // if left child null add as END
					str += "END";
				} else {
					str += node.left.data;  // if present than add that data
				}

				str += " -> " + node.data + " <- ";  // then parent root node attach with left child data

				if (node.right == null) {
					str += "END";           // if left child null add as END
				} else {
					str += node.right.data;   // if present than add that data
				}

				System.out.println(str);   // print the tree for root node

				// Recursion cases to print all child left and right nodes
				
				// left
				display(node.left);
				// right
				display(node.right);
		
	}
	
	
	// Find an item in binary search tree  as search
	
	public boolean find(int item) {               // method pass with item
		return this.find(this.root,item);  // refer to find method with node and item
	}


	private boolean find(Node node, int item) {
		
		if(node==null) {         // if node is null 
			return false;        // then return ( Recursion base condition)
		}
		
		    // Case 1.
		if(item>node.data) {         
			return find(node.right,item); // recursion
		}
		
		    // Case 2.
		else if(item<node.data) {
			return find(node.left,item);  // recursion 
			
		}else {                  
			return true;   // after case 1 and case 2 recursion item found
		}                  // then return true  otherwise give as base condition null
	}
	
	
	public void max() {
		System.out.println(this.max(this.root));
	}


	
	// To find max data in tree       // As we know max item of bst
	private int max(Node node) {      // must in right child
		if(node.right==null) {   // so if right child is null
			return node.data;       // Then parent root node data will be max
		} 
		return max(node.right);  // Otherwise recursion to reach last right child
	}                             // then base condition to give that data
	
	
	// Method to add data in bst
	
	public void add(int item) {   // Method pass by data only
		 this.add(this.root,item);   // To work on node pass with item
	}


	private void add(Node node, int item) {
		if(item>node.data) {             // to check position
			if(node.right==null) {  // if right node null (recursion base condition)
				Node nn=new Node();   // create new node to add
				nn.data=item;        // assigned new node to item
				node.right=nn;        // parent node's right node assigned to new node
			}else {
				add(node.right,item);  // recursion to add on right node
			}
		}else {
			if(node.left==null) {   // if left node null (recursion base condition)
				Node nn=new Node();    // create new node to add
				nn.data=item;         // assigned new node to item
				node.left=nn;      // parent node's right node assigned to new node
			}else {
				add(node.left,item);  // recursion to add on left node
			}
		}
		
	}
	
	// Method to remove data from bst
	
	public void remove(int item) {
		this.remove(this.root,null,false,item); // To work on node pass with parent node, item 
	}                    // and condition of boolean to check is left child(ilc)


	private void remove(Node node, Node parent, boolean ilc, int item) {
		if(node==null) {           // if node null
			return;        // then return (recursion base condition)
		}
		
		
		// Case 1.
		if(item>node.data) {
			remove(node.right,node,false,item);  // recursion to remove 
		}
		
		// Case 2. 
		else if(item<node.data) {
			remove(node.left,node,true,item);  // recursion to remove 
		}
		
		// Case 3.
		else { 
			            // Case 3, subCase 1.
			   if(node.left==null && node.right==null) { // if both right and left child is no
				   
				   if(ilc) {  // On behalf is left child true
					   parent.left=null;  // set null
				   }else {
					   parent.right=null;   // set null
				   }
				   
			   }      // Case 3, subCase 2.
			       else if(node.left==null && node.right!=null) { 
				                            // if left null not right
				   if(ilc) {    // On behalf is left child true
					   parent.left=node.right;  // add right node
				   }else {
					   parent.right=node.right;  // right node also new right node
				   }
				   
			   }       // Case 3, subCase 3.
			       else if(node.left!=null && node.right==null) {
				                               // is left not null nbut right null
				   if(ilc) {     // On behalf is left child true
					   parent.left=node.left;   // left node also new left node
				   }else {
					   parent.right=node.left;   // add left node
				   }
				   
			   }      // Case 3, subCase 3.  when both are not null
			       else { 
				   int max=max(node.left);   // find max of in left child
				   node.data=max;   // make as node data
				   remove(node.left,node,true,max);  // recursion to remove that
				                               // and set new bst with bst condition
			   }
		}
		
	}
	
	

}
