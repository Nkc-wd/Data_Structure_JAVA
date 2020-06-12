package stack_and_queue;

public class QUEUE {
	protected int[] data;   // data array initialization
	protected int size;     // size of queue data array
	protected int front;   // required front index of queue array

	public static final int DEFAULT_CAPACITY = 10;    // default capacity if user not give capacity

	public QUEUE() throws Exception {               // default capacity constructor
		this(DEFAULT_CAPACITY);
	}

	public QUEUE(int capacity) throws Exception {
		if (capacity < 1) {                             // user capacity Exception Handling
			throw new Exception("Invalid Capacity");
		}
		                                    // data array and front,size Constructor
		
		this.data = new int[capacity];      //new data array initialize with capacity by user 
		this.front = 0;                     // set initial front index is 0 
		this.size = 0;                      // set size is 0 
	}

	public int size() {                     // method to give size
		return this.size;                  // return size
	}

	public boolean isEmpty() {                // Method to check queue is empty or not and return as boolean
		return this.size() == 0;              // true and false
	}

	public void enqueue(int value) throws Exception {
		if (this.size() == this.data.length) {                 // Size must be greater than data array length to add an element
			throw new Exception("Queue is Full");
		}                                                             // enqueue method 
		int ai = (this.front + this.size) % this.data.length;   // to retrieve available index by
		                                // (current front+ current size) modulo by data array length
		
		this.data[ai] = value;   // data array with current available index will assigned to add item element
		this.size++;               // after enqueue size need to increment
	}
	
	

	public int dequeue() throws Exception {
		if (this.size() == 0) {                              // Exception Handling
			throw new Exception("Queue is Empty");
		}
		                                                         // dequeue method
		                                                      
		int rv = this.data[this.front];          // Retrieve value of current front index value of data array
		this.data[this.front] = 0;              // Make this front index value is 0 to remove that index from stack
		
		this.front = (this.front + 1) % this.data.length; // After remove need to set new front
		                                        // new front Assigned to current available index
		this.size--;                      // After remove size need to decrement
		return rv;           // To return current dequeue item value
	}

	public int front() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Queue is Empty");
		}
		                                                       // To find current front index value
		int rv = this.data[this.front];          // Retrieve value of current front index value of data array
		return rv;                     // return this
	}

	public void display() {
		for (int i = 0; i < this.size; i++) {
			int ai = (this.front + i) % this.data.length;       // Need to find on every iterate available index  
			                                                  
			                                                     // display queue data array
			System.out.print(this.data[ai] + "=>");            // print data array as per available index  
		}
		System.out.println("END");
	}
}