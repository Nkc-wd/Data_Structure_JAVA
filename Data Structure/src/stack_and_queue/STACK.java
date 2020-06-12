package stack_and_queue;

public class STACK {
	protected int[] data;    // data array initialization
	protected int top;       // top index for stack 

	public static final int DEFAULT_CAPACITY = 10;  // default capacity if user not give capacity

	public STACK() throws Exception {
		this(DEFAULT_CAPACITY);             // default capacity constructor 
	}

	public STACK(int capacity) throws Exception {
		if (capacity < 1) {                            // user capacity Exception Handling
			throw new Exception("Invalid Capacity");
		}                                               // data array and top Constructor

		this.data = new int[capacity];   //new data array initialize with capacity by user 
		this.top = -1;                   // Set top=-1 becoz when an element add(+1) it will give 0 as array index
	}

	public int size() {              // method to give size
		return this.top + 1;         // must return +1 to give exact size
	}
	
	

	public boolean isEmpty() {
		return this.size() == 0;         // Method to check stack is empty or not and return as boolean 
	}   // true and false
	
	

	public void push(int value) throws Exception {
		if (this.size() == this.data.length) {      // Size must be greater than data array length to add an element
			throw new Exception("Stack is Full");
		}                                                         // Push Method

		this.top++;                        // On push top need to increment
		this.data[this.top] = value;       // data array with current top index will assigned to push item element
	}

	
	
	public int pop() throws Exception {
		if (this.size() == 0) {                             // If size is 0 then Exception Handling
			throw new Exception("Stack is Empty");
		}                                                     //Pop Method

		int rv = this.data[this.top];                   // Retrieve value of current top index value of data array
		this.data[this.top] = 0;                      // Make this top index value is 0 to remove that index from stack
		this.top--;                     // On pop top need to decrement
		return rv;                      // It will return pop value item 
	}

	public int top() throws Exception { 
		if (this.size() == 0) {               // Exception Handling
			throw new Exception("Stack is Empty");
		}                                                           // Method to find Top index item value in stack

		int rv = this.data[this.top];         // Retrieve value of current top index value of data array
		return rv;                              // return this value
	}

	public void display() {
		for (int i = this.top; i >= 0; i--) {       // iterate in data array
			System.out.println("|"+this.data[i]+"|");              // Stack display
			System.out.println("_ _ _");
			                                               // Note:  We need to print data array in reverse order
		}                                // To form look like stack starting from top index to 0 index
		System.out.println("END");
	}

}