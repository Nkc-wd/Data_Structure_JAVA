package searching;

public class Linear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,5,25,23,8,96,25};
		int item=5;
		System.out.println(linear_search(arr,item));
		

	}
	
	public static String linear_search(int[] arr,int item) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==item) {
				return ("Item "+item+" found at "+(i+1)+" index");
			}
			
		}
		return ("not found");
		
		
	}

}
