package sorting;

public class Selection_sort {

	// basically selection sort compare index with element
	// remember till last means <n only
	public static void ss_sort(int[] arr) {
		int n=arr.length;
		//loop for indexing
		for (int i = 0; i <n; i++) {
			//loop for element
			for (int j = i+1; j <n; j++) {
				//compare index with element
				if(arr[i]>arr[j]) {
					
					//swap
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				
			}
			
		}
	}
}
