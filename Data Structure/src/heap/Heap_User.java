package heap;

public class Heap_User {

	public static void main(String[] args) {
		// Note: Array may not be sorted on output but must be as Min Heap
		Heap heap = new Heap();
		heap.add(10);
		heap.display();
		heap.add(20);
		heap.display();
		heap.add(30);
		heap.display();
		heap.add(40);
		heap.display();
		heap.add(5);
		heap.display();
		heap.add(3);
		heap.display();
		
		System.out.println(heap.remove());
		// heap.display();
		System.out.println(heap.remove());
		// heap.display();
		System.out.println(heap.remove());
		// heap.display();
		System.out.println(heap.remove());
		// heap.display();
		System.out.println(heap.remove());
		// heap.display();
		System.out.println(heap.remove());
		heap.display();
	}

}
