package Searching;

import java.util.Arrays;

public class KthSmallestElementInAnArray {

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15}, K = 3;
        int ans = helpOptimized(arr,K);
        System.out.println(ans);
    }

    private static int helpOptimized(int[] arr, int k) {
        // TODO Auto-generated method stub
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int start = min;
        int end = max;
        while(start<=end){
            int mid = start+(end-start)/2;
            int countLess = 0;
            int countEqual = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]<mid){
                    countLess++;
                }
                else if(arr[i]==mid){
                    countEqual++;
                }
            }
            if(countLess<k && countLess+countEqual>=k){
                return mid;
            }
            else if(countLess>=k){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return 0;
    }

    private static int help(int[] arr, int k) {
        // TODO Auto-generated method stub
        Arrays.sort(arr);
        return arr[k-1];
    }
    


}