package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            Scanner scan=new Scanner(System.in);
            System.out.println("enter the size of array");
            int no=scan.nextInt();
            
            int[] arr=new int[no];
            System.out.println("enter the elments of array:");
            for (int i = 0; i < arr.length; i++) {
				arr[i]=scan.nextInt();
			}
            
//            Bubblesort bub=new Bubblesort();
//            bub.bubble(arr);
//            for(int val:arr) {
//            	System.out.println(val);
//            }
//
//            Selection_sort bub=new Selection_sort();
//            bub.ss_sort(arr);
//            for(int val:arr) {
//            	System.out.println(val);
//            }
//            Insertion_sort bub=new Insertion_sort();
//            bub.insert(arr);
//            for(int val:arr) {
//            	System.out.println(val);
//            }
//            Quick_sort bub=new Quick_sort();
//            bub.quick(arr,0,arr.length-1);
//            for(int val:arr) {
//            	System.out.println(val);
//            }
            Merge_sort bub=new Merge_sort();
            int[] ans=bub.mergesort(arr);
    		System.out.println(Arrays.toString(ans));
	}

}
