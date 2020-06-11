package searching;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr2= {2,5,10,15,18};
		int items=15;
		System.out.println(binarySearch(arr2, items));
	

	}
	public static String binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			
			if (arr[mid] < item) {
				lo = mid + 1;
			} else if (arr[mid] > item) {
				hi = mid - 1;
			} else {
				return ("your item has found at "+mid+" index");
			}

		}

		return ("Sorry your item is not in the list");
	}
}
