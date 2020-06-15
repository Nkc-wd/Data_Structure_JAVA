package binary_tree;

public class Binary_User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		                     /*          50
                                      /      \		
		                             25      45
		                           /   \     / \
		                         38     48  85 60
		                               /
		                              18		
		*/

		
		// 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
				// 
				Binary_tree tree = new Binary_tree();
				System.out.println();
				System.out.println("The Constructed Binary tree is :");
				tree.display();
				System.out.println("Height of this binary tree is :");
		        System.out.println(tree.height());
		        System.out.println("================");
		        System.out.println("preOrder");
		        tree.preOrder();
		        System.out.println("inOrder");
		        tree.inOrder();
		        System.out.println("postOrder");
		        tree.postOrder();
	}

}
