package generic_hashmap;
 
import java.util.ArrayList;

public class Generic {

	public static void main(String[] args) {
		Integer[] arr= {1,2,3};
		
		display(arr);
		
		String[] arr1= {"sim","run","ddlj"};
		display(arr1);
		
	}
	
	// for printing both integer and String array we need two other methods
	// But with help of generic method and passing generic type argument we can
	// optimize this in single method
	public static<T> void display(T arr[]) {
		for(T val:arr) {
			System.out.println(val);
		}
	}
}