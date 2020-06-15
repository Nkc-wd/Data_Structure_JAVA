package binary_tree;

import java.util.Scanner;

public class Binary_tree {
	
	private class Node{
		private int data;
		Node left;
		Node right;
		
		Node(int data,Node left,Node right){
			this.data=data;
			this.left=left;
			this.right=right;
			
		}
	}
		
		private Node root=null;
		private int size=0;
		
		Binary_tree() {
			Scanner s =new Scanner(System.in);
			this.root=takeinput(s,null,false);
			
			
		}

		private Node takeinput(Scanner s, Node parent, boolean isleftORright) {
			if(parent==null) {
				System.out.println("enter the data for root node");
			}
			else {
				if(isleftORright) {
					System.out.println("enter data for left child of "+parent.data);
				}
				else {
					System.out.println("enter data for right child of "+parent.data);
					
				}
			}
			
			
			int nodedata=s.nextInt();
			Node node=new Node(nodedata,null,null);
			this.size++;
			
			boolean choice=false;
			System.out.println("Do you any left child of "+node.data);
			choice=s.nextBoolean();
			
			if(choice) {
				node.left=takeinput(s,node,true);
			}
			
			choice=false;
			System.out.println("Do you any left child of "+node.data);
			choice=s.nextBoolean();
			if(choice) {
				node.right=takeinput(s,node,false);
			}
			
			return node;
			
		}
		
		
		public void display() {
		       this.display(this.root);
		}

		private void display(Node node) {
			
			String str="";
			
			if(node.left!=null)
			{
				str+=node.left.data+"=>";
			}
			else {
				str+="END=>";
			}
			str+=node.data;
			
			if(node.right!=null) {
				str+="<="+node.right.data;
			}else {
				str+="<=END";
			}
			
			System.out.println(str);
			
			if(node.left!=null) {
				this.display(node.left);
			}
			
			if(node.right!=null) {
				this.display(node.right);
			}
			
		}
		
		
		
	}


