package sorting;

public class Insertion_sort {

	public static void insert(int[] arr) {
		
		//indexing loop
		for (int i = 1; i < arr.length; i++) {
			int key=arr[i];
			int j=i-1;
			
			//comapring element
			while((j>-1)&&(arr[j]>key)) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;	
		}
	}
	
	
}
