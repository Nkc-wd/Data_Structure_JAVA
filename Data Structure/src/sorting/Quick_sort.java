package sorting;

public class Quick_sort {
	
	
	public static void quick(int[] arr,int began,int end) {
		
		// array with start and end index
		//let pivot element is mid
		int mid =(began+end)/2;
		//set pivot as mid
		int pivot=arr[mid];
		// two reference as left and right
		int left=began;
		int right=end;
		
		//base case
		//when starting index will equal or grater the high then return
		 if(began>=end) {
			 return;
		 }
		
		 //means while loop till when high index become equal to start
		while(left<=right) {
			
			//when start element is lesser then pivot element then left index must be increase
			while(arr[left]<pivot) {
				left++;
			}
			//when high element is greater then pivot element then right index must be decrease
			while(arr[right]>pivot) {
				right--;
			}
			
			//swap only when left is less than of equal right 
			if(left<=right) {
				
				//swap then element to left to right 
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
			
			//recursion call to complelete the sorting as
			/*
			 * ----low to right---
			 * ===================pivot======================
			 *                         ----left to high------
			 */
			quick(arr,began,right);
			quick(arr,left,end);
		}
		
	}

}
