package generic_tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Gtree {
	
	
	private class Node{
		int data;
		ArrayList<Node> children;
		
		Node (int data){         // constructor inside Node class
			this.data=data;     // means it will be only acces by node class
			this.children=new ArrayList<>();
			
		}
	}
	
	
	private Node root;   // Where, these can be access by Gtree class
	private int size;
	
	// so they need constructor
	Gtree(){
		Scanner s=new Scanner(System.in);
		this.root=takeinput(s,null,0); // to make root item

}
	// to take the input of generic tree
	
	private Node takeinput(Scanner s,Node parent,int ithchild) {
		if(parent==null) { // for root
			System.out.println("Enter the data for node root");
		}
		else {
			System.out.println("Enter the data for the "+ithchild+"th child of "+parent.data);	
		}
		int nodedata=s.nextInt();
		Node node=new Node(nodedata);
		this.size++;
		
		System.out.println("Enter the no. of children for "+node.data);
		int childs=s.nextInt();
		// will be executed according to the value of children
		for (int i = 0; i < childs; i++) {
			Node child=this.takeinput(s, node, i);
			node.children.add(child);
			
		}
		return node;
	}
	
	
	// display tree
	// logic will be parent.data=> child.data=> END
	
	public void display() {
		this.display(this.root);
	}
	
	private void display(Node node) {
		//node data
		String str=node.data+"=>";
		for (int i = 0; i <node.children.size(); i++) {
			// add children data of current node
			str=str+node.children.get(i).data+", ";
			
		}
		str=str+"END";
		// display the string for current node
		System.out.println(str);
		
		
		 // display for all nodes
		for (int i = 0; i <node.children.size(); i++) {
			this.display(node.children.get(i));
		}
	}
	

}
