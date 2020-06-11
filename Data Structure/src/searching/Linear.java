package searching;

public class Linear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,5,25,23,8,96,25};
		int item=5;
		System.out.println(linear_search(arr,item));
		

	}
	
	// When need to return with Statement then use String for method return
	public static String linear_search(int[] arr,int item) {
		for (int i = 0; i < arr.length; i++) {  // iterate over array
			if(arr[i]==item) {    // When array element will be equal search item
				return ("Item "+item+" found at "+(i+1)+" index");  // then return
			}
			
		}
		return ("not found");  // if not then return statement
		
		/* Important Note:
		 * when element is not found in iterate loop then not find return must be 
		 * outside of the loop not with << else of if >>
		 */
		
		
	}

}
