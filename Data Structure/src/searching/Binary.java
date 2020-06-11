package searching;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr2= {2,5,10,15,18};
		int items=15;
		System.out.println(binarySearch(arr2, items));
	

	}
	// return type with statement method String
	public static String binarySearch(int[] arr, int item) {

		int lo = 0;     // left
		int hi = arr.length - 1; // right
		while (lo <= hi) {    // loop till right is greater or equal to the left
			int mid = (lo + hi) / 2; // mid
			
			if (item>arr[mid]) {  // when item is greater then mid element
				lo = mid + 1;    // then it need to be left increment with mid , mid+1
			} 
			
			else if (item<arr[mid]) {  // when item is less than mid element
				hi = mid - 1;         // then it need to right decrement as with mid, mid-1
			} else {
				return ("your item has found at "+mid+" index");   // When both if and else if condition pass 
			}                                                     // then search item will be in mid, so return this

		}

		return ("Sorry your item is not in the list");    // when item is not find in while loop
	}                                                     //then it need to be return -1
}
