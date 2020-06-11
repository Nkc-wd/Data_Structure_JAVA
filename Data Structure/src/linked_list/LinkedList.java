package linked_list;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(n)
	public void display() {

		
		Node temp = this.head;
		System.out.print("[");
		int i=0;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
			if(i!=this.size-1) {
				System.out.print(",");
			}
			i++;
		}
		
		System.out.println("]");
	}

	// O(1)
		public void addFirst(int item) {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			if (this.size >= 1) {
				nn.next = head;
			}

			// summary object update
			if (this.size == 0) {
				this.head = nn;
				this.tail = nn;
				this.size++;
			} else {
				this.head = nn;
				this.size++;
			}

		}
		
		// O(1)
		public void addLast(int item) {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			if (this.size >= 1) {
				this.tail.next = nn;
			}

			// summary object
			if (this.size == 0) {
				this.head = nn;
				this.tail = nn;
				this.size++;
			} else {
				this.tail = nn;
				this.size++;
			}
		}
		
		
	// O(1)
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;
	}

	// O(n)
	public int getAt(int index) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	// O(n)
	private Node getNodeAt(int index) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}

		return temp;
	}

	

	

	// O(n)
	public void addAt(int item, int index) throws Exception {

		if (index < 0 || index > size) {
			throw new Exception("Invalid Index.");
		}

		if (index == 0) {
			addFirst(item);
		} else if (index == this.size) {
			addLast(item);
		} else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(index - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// summary update
			this.size++;
		}
	}

	// O(1)
	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;

	}

	// O(n)
	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sizem2 = getNodeAt(this.size - 2);
			this.tail = sizem2;
			this.tail.next = null;
			this.size--;
		}

		return rv;
	}

	// O(n)
	public int removeAt(int index) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (index == 0) {
			return removeFirst();
		} else if (index == this.size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(index - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			this.size--;

			return n.data;
		}
	}

	public void reverseData() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;

		}
	}

}
