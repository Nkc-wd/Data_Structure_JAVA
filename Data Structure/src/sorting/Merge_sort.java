package sorting;

import java.util.Arrays;

public class Merge_sort {
//	public static void main(String[] args) {
//		int[] arr= {55,22,5,1,62};
//		int[] ans=mergesort(arr,0,arr.length-1);
//		System.out.println(Arrays.toString(ans));
//	}
//	
	
	public static int[] merge(int[] firstarr,int[] secondarr) {
		int[] mergearr=new int[firstarr.length+secondarr.length];
		int k=0;
		int i=0;
		int j=0;
		
		
		while(i<firstarr.length && j<secondarr.length) {
			// condition when same length
			
			if(firstarr[i]<=secondarr[j]) {
				mergearr[k]=firstarr[i];
				i++;
				k++;
			}else {
				mergearr[k]=secondarr[j];
				j++;
				k++;
			}
			
			
			//condition when one of arr consume
			
			if(i==firstarr.length) {
				while(j<secondarr.length) {
					mergearr[k]=secondarr[j];
					j++;
					k++;
				}
			}
				if(j==secondarr.length) {
					while(i<firstarr.length) {
						mergearr[k]=firstarr[i];
						i++;
						k++;
					}	
			}		
		}		

		return mergearr;

}
	
	public static int[] mergesort(int[] nums){
        if (nums.length <= 1){
            return nums;
        }

        int mid = nums.length/2;

        //copy of range not consider last index
        int[] first = Arrays.copyOfRange(nums, 0, mid);
        int[] second = Arrays.copyOfRange(nums, mid, nums.length);
         
            
        first = mergesort(first);
        second = mergesort(second);

        return merge(first, second);
    }
}