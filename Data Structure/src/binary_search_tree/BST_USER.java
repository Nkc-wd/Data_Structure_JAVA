package binary_search_tree;

public class BST_USER {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] in = { 10, 20, 30, 40, 50, 60, 70 };

		BST bst = new BST(in);
		bst.display();
		System.out.println();
		System.out.println("bst find for 80");
		System.out.println(bst.find(80));
		System.out.println("bst max");
		bst.max();
		System.out.println("Added 55");
		bst.add(55);
		System.out.println("=====After add bst=====");
		bst.display(); 
		System.out.println("===========");

		System.out.println("remove 55");
		bst.remove(55);
		System.out.println("=====After remove 55 bst=====");
		System.out.println();
		bst.display();
		System.out.println("===========");

		bst.remove(80);
		bst.display();

	}

}
