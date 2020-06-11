package sorting;

public class Bubblesort {
	
	public static void bubble(int[] arr) {
		// bubble sort iterate over length-2
		int n=arr.length-1;
		// loop of index iterate
		for (int i = 0; i < n; i++) {
			// loop for element compare
			for (int j = 0; j < (n-i); j++) {
				if(arr[j]>arr[j+1]) { // check if
					// sawping 
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;					
				}	
			}		
		}
	}
}
