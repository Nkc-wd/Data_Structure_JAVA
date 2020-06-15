package binary_tree;

import java.util.Scanner;

public class Binary_tree {
	
	private class Node{           // Node reference
		private int data;  // int data
		Node left;            // for left address
		Node right;     // for right address
		
		Node(int data,Node left,Node right){
			this.data=data;                       // Node class constructor 
			this.left=left;
			this.right=right;
			
		}
	}
		
		private Node root=null;        // Node root reference that will be call by Binary_tree class
		private int size=0;
		
		Binary_tree() {
			Scanner s =new Scanner(System.in);      // Binary_tree constructor
			this.root=takeinput(s,null,false);        // B tree root has data by user ,parent is null and initially has false  
			                                         // condition for left and right child
			
		}
 
		
		// For taking input for tree
		
		private Node takeinput(Scanner s, Node parent, boolean isleftORright) {
			if(parent==null) {                                         // if parent node is null then it must be root
				System.out.println("enter the data for root node");
			}
			else {   // else asking for left and right child
				if(isleftORright) {   // if user enter true then 
					System.out.println("enter data for left child of "+parent.data);  // is true then ask for left child of parent data
				}
				else {             // if user enter false then for right child
					System.out.println("enter data for right child of "+parent.data);
					
				}
			}
			
			
			
			
			
			// for taking data for node by input Stream 
			int nodedata=s.nextInt();
			Node node=new Node(nodedata,null,null); // initialize the nodedata as new node creation
			this.size++;  // after new node creation size must be incremented
			
			boolean choice=false;   // Initialize a boolean variable for choice set as false
			System.out.println("Do you any left child of "+node.data);  // ask for left child
			choice=s.nextBoolean();  // taking boolean input
			
			if(choice) {   // if enter true
				node.left=takeinput(s,node,true);  // assigned node left address and take input method
			}
			
			choice=false;  // again set boolean variable for choice as false
			System.out.println("Do you any right child of "+node.data); // ask for right child
			choice=s.nextBoolean(); // taking boolean input
			if(choice) {        // if enter true
				node.right=takeinput(s,node,false); // assigned node right address and take input method
			}
			
			return node;   // return that node
			
		}
		
		
		// Display binary tree
		
		// taking display void method and passing form this root address that user 
		// can simple call display method to see from root parent node
		
		public void display() {
		       this.display(this.root);
		}
		
//		passing node as root to print display                
		
//		                                    Logic        // left=>parent root <= right

		private void display(Node node) {
			
			String str="";   // empty string initialize
			 
			if(node.left!=null)     // if node left address is not null
			{
				str+=node.left.data+"=>"; // then added in str
			}
			else {
				str+="END=>";  // else end
			}
			str+=node.data;  // add node.data in str for parent root (means bich me root aaye)
			
			
			//Now right child
			
			// if right node address is not null 
			if(node.right!=null) {
				str+="<="+node.right.data;  // then added in str
			}else {
				str+="<=END";   // else end
			}
			                 
			System.out.println(str);   // print total string str
			
			if(node.left!=null) {
				this.display(node.left);  // for other's left data to display
			}
			
			if(node.right!=null) {
				this.display(node.right);   // for other's right data to display
			}
			
		}
		
		public int height() {
			return this.height(this.root);   // to simply return the height by tree 
			                                 // without giving node addresss , Here taking root to start height 
		}

		private int height(Node node) {
			if(node==null) {
				return -1;                                     // To find height of tree 
			}
			int lheight=this.height(node.left);          // to find left height
			int rheight=this.height(node.right);         // to find right height
			int height=Math.max(lheight, rheight)+1;   // Find max of both and add +1
			                                   // to give exact height
			return height;  // return that height
			
		}
		
		public void preOrder() {               // to give pre order of binary tree
			this.preOrder(this.root);          //pre order from parent tree root
			System.out.println("END");   // ended by
		}

		private void preOrder(Node node) {
			if(node==null) {       // if node is null then return 
				return;
			}
			
			
			System.out.print(node.data+", "); // print data as root
			preOrder(node.left);    // recursion  for left
			preOrder(node.right);  // recursion for right 
			
			
		}
		
		public void inOrder() {           // to give in order of binary tree
			this.inOrder(this.root);      //in order from parent tree root
			System.out.println("END");    // ended by
		}

		private void inOrder(Node node) {
			if(node==null) {
				return;                    // if node is null then return
			}
			
			inOrder(node.left);            // recursion  for left
			System.out.print(node.data+", "); // print data as root
			inOrder(node.right);           // recursion for right
			
			
		}
		
		public void postOrder() {           // to give in order of binary tree
			this.postOrder(this.root);      //in order from parent tree root
			System.out.println("END");   // ended by
		}

		private void postOrder(Node node) {
			if(node==null) {                // if node is null then return
				return;
			}
			
			postOrder(node.left);        // recursion  for left
			postOrder(node.right);        // print data as root
			System.out.print(node.data+", ");  // recursion for right
			
			
		}
		
	}


