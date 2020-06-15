package linked_list;

public class List_User {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addAt(100, 1);
		list.display();
		System.out.println(list.getLast());
		System.out.println(list.getFirst());
		System.out.println(list.getAt(1));
		System.out.println(list.removeFirst());
		list.display();
		System.out.println(list.removeLast());
		list.display();
		list.addLast(200);
		list.addLast(300);
		
		list.display();
		 System.out.println(list.removeAt(3));
		list.display();

		list.reverseData();
		list.display();
		System.out.println("=========");
		System.out.println(list.size());
		System.out.println("=========");
		System.out.println(list.mid());
		

	}

}
