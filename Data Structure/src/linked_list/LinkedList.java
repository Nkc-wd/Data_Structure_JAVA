package linked_list;

public class LinkedList {

	private class Node {              // A Node is private class for LinkedList
		int data;              // contains data 
		Node next;             //link Address or reference as next of Node class
	}

	// next is a pointer to the next node
	// next is by default initialized  as null
 
	
	private Node head;  // link address head
	private Node tail; // link address tail
	private int size;  // size

	// O(n)
	public void display() {

		
		Node temp = this.head;  // A temp node assigned to current head
		System.out.print("[");            //display linked list
		int i=0;
		while (temp != null) {          // till temp will be not null
			System.out.print(temp.data);  // print that data 
			temp = temp.next;             // and now temp is next temp as next head
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
			Node nn = new Node();      // nn is new node
			nn.data = item;             // give this new node nn to data
			nn.next = null;            // and nn's next to null

			// attachment
			if (this.size >= 1) {
				nn.next = head;      // Only attach data when size => to 1 
				                     // such that head's next will point to the newly added node.
			}
                                                              // addFirst Method
			// summary object update
			if (this.size == 0) {
				this.head = nn;      // If the list is empty, both head and tail will point to the newly added node(nn).
				this.tail = nn;
				this.size++;          // and size need to increment
			} else {
				this.head = nn;        // If the list is not empty, the new node will be added to head of the list
				this.size++;           // such that head's next will point to the newly added node.
			}

		}
		
		// O(1)
		public void addLast(int item) {

			// create a new node
			Node nn = new Node();
			nn.data = item;           // To add at last need to create node
			nn.next = null;

			// attach
			if (this.size >= 1) {      // Only attach data when size => to 1 
				this.tail.next = nn;  // such that tail's next will point to the newly added node.
			}                                             
			                                                   //addLast

			// summary object
			if (this.size == 0) {
				this.head = nn;           // If the list is empty, both head and tail will point to the newly added node(nn).
				this.tail = nn;
				this.size++;
			} else {
				this.tail = nn;         // If the list is not empty, the new node will be added to end of the list 
				                       // such that tail's next will point to the newly added node.
				this.size++;
			}
		}
		
		
	// O(1)
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;         // return current head's data
	}

	// O(1)
	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;             // return current tail's data
	}

	// O(n)
	public int getAt(int index) throws Exception {

		if (this.size == 0) {                 // size Exception Handling
			throw new Exception("LL is Empty.");
		}

		if (index < 0 || index >= this.size) {     // if index by user is less then 0 or greater or equal to size
			throw new Exception("Invalid Index.");  // then we can not add that index position
		}

		Node temp = this.head;          // temp node assigned to current head
		for (int i = 1; i <= index; i++) {        // iterate from 1 to less and equal to index
			temp = temp.next;                      // temp need to assign next head
		}

		return temp.data;      // return that data
	}

	// O(n)
	private Node getNodeAt(int index) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");  // Exception Handling
		}

		if (index < 0 || index >= this.size) {                    // Method to find Node link reference at paricular index 
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;     // temp node assigned to current head
		for (int i = 1; i <= index; i++) {   // iterate from 1 to less and equal to index
			temp = temp.next; // temp need to assign next head
		}

		return temp;  // return that link reference
	}

	

	

	// O(n)
	public void addAt(int item, int index) throws Exception {

		if (index < 0 || index > size) {
			throw new Exception("Invalid Index.");    // Exception Handling
		}

		if (index == 0) {     // if index is 0 then use addFirst Method to add item
			addFirst(item);
		} else if (index == this.size) {  // if index is equal to size then use addLast Method to add item
			addLast(item);
		} else {

			// create a new node         // or else index position
			Node nn = new Node();
			nn.data = item;                            //addAt position 
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(index - 1);  // for addAt we need to link address of previous item 
			                                  // So find getNodeAt of previous by index-1
			Node np1 = nm1.next;             // now find previous's next link

			nm1.next = nn;                 // Now attach new node link to previous's link
			nn.next = np1;                  // and new node to previous's next link

			// summary update
			this.size++;                  // After attachment size need to increment
		}
	}

	// O(1)
	public int removeFirst() throws Exception {

		if (this.size == 0) {                       // if size 0 Exception Handling
			throw new Exception("LL is empty.");
		}

		int rv = this.head.data;   // retrieve current head's data

		if (this.size == 1) {          // if size is only 1 then
			this.head = null;
			this.tail = null;         
			this.size = 0;
		} else {                          // else current head assigned to next item's head
			this.head = this.head.next;
			this.size--;     // size decrement
		}

		return rv;

	}

	// O(n)
	public int removeLast() throws Exception {

		if (this.size == 0) {                            // if size 0 Exception Handling
			throw new Exception("LL is empty.");
		}

		int rv = this.tail.data;             // retrieve current tail's data

		if (this.size == 1) {                // if size is only 1 then
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sizem2 = getNodeAt(this.size - 2);   // to remove last need to find second last's index links
			this.tail = sizem2;             // assigned current tail to second last's index item
			this.tail.next = null;       // and this index's tail next to be null
			this.size--;         // after remove size need to be decrement
		}

		return rv;         // return that value
	}

	// O(n)
	public int removeAt(int index) throws Exception {

		if (this.size == 0) {               // Exception Handling
			throw new Exception("LL is empty.");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (index == 0) {   // if index is 0 then use removeFirst Method to add item
			return removeFirst();
		} else if (index == this.size - 1) { // if index is equal to size-1 then use removeLast Method to add item
			return removeLast();
		} else {
			Node nm1 = getNodeAt(index - 1);    // for addAt we need to link address of previous item 
			Node n = nm1.next;              // Node n is next link of previous index 
			Node np1 = n.next;              // Node np1 is next link of Node n

			nm1.next = np1;                 // Now attach previous' link to np1 
                                       // that's means Node n's link broken and hence removed
			this.size--;   // then size need to be decrement

			return n.data;  // return removed data
		}
	}

	public void reverseData() throws Exception {

		int left = 0;
		int right = this.size - 1;
                                                       // Reverse Method
		while (left < right) {   // till right is greater than left

			Node ln = getNodeAt(left);      // Find Node link of left
			Node rn = getNodeAt(right);      // Find Node link of right 

			int temp = ln.data;           // And need to be shift
			ln.data = rn.data;
			rn.data = temp;

			left++;      // then left increment
			right--;              // then right to be increment

		}
	}

}
