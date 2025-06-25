package Amazon_Prep_Kit;

import java.util.Arrays;

public class TwoSum {
    
}
class Solution {
	int[] twoSum(int[] A, int target) {
		/*
		 * 
		 * // add your logic here
		// for(int i=0;i<A.length;i++){
		// 	for(int j=i+1;j<A.length;j++){
		// 		if(A[i]+A[j]==target){
		// 			return new int[]{i,j};
		// 		}
		// 	}
		// }
		// return new int[]{-1,-1};
		// Use s1 + s2 => target;
		 // s1 = target-s2;
		HashMap<Integer,Integer> hashmap = new HashMap<>();
		for(int i=0;i<A.length;i++){
			if(hashmap.containsKey(target-A[i])){
				return new int[]{hashmap.get(target-A[i]),i};
			}
			hashmap.put(A[i],i);
		}
		return new int[]{-1,-1};
		 */
	    // add your logic here
		int arr[][] = new int[A.length][2];
		for(int i=0;i<arr.length;i++){
			arr[i][0] = A[i];
			arr[i][1] = i;
		}
		Arrays.sort(arr,(a,b)->a[0]-b[0]);
		int i=0,j=A.length-1;
		while(i<j){
			int sum = arr[i][0] + arr[j][0];
			if(sum==target){
				return new int[]{arr[i][1],arr[j][1]};
			}
			if(sum<target){
				i++;
			}
			else{
				j--;
			}
		}
		return new int[]{-1,-1};
	}
}