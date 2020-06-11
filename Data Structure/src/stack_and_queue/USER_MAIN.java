package stack_and_queue;

public class USER_MAIN {

	public static void main(String[] args) throws Exception {
		/*
		 * Note: Remember the default size of stack and queue here is 10 if we want more 
		 *      then give user size on class name initialization
		 *      as STACK stk=new STACK(100);
		 */     
		
//		STACK stk=new STACK();
//		stk.push(10);
//		stk.push(20);
//		stk.push(30);
//		stk.push(40);
//		stk.push(50);
//		stk.push(60);
//		stk.push(70);
//		stk.push(80);
//		stk.push(90);
//		stk.push(100);
//		stk.display();
//		System.out.println("=========");
//		System.out.println("size"+stk.size());
//		System.out.println("=========");
//		System.out.println(stk.isEmpty());
//		System.out.println("=========");
//		stk.pop();
//		stk.pop();
//		stk.pop();
//		stk.pop();
//		stk.display();
//		System.out.println("=========");
//		System.out.println("size"+stk.size());
//		System.out.println("=========");
//		System.out.println(stk.top());
		
		
		QUEUE q=new QUEUE();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.enqueue(70);
		q.enqueue(80);
		q.enqueue(90);
		q.enqueue(100);
		q.display();
		System.out.println("=========");
		System.out.println("size"+q.size());
		System.out.println("=========");
		System.out.println(q.isEmpty());
		System.out.println("=========");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.display();
		System.out.println("=========");
		System.out.println("size"+q.size());
		System.out.println("=========");
		System.out.println(q.front());
		
		
	}

}
