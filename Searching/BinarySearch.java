package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int index = searchByBinary(arr,8);
        System.out.println(index);
    }

    private static int searchByBinary(int[] arr,int val) {
        // TODO Auto-generated method stub
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(arr[mid]==val) return mid;
            else if(arr[mid]<val){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return -1;
    }
    // Find Minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[start]<=nums[mid]){
                min = Math.min(nums[start],min);
                start = mid+1;
            }
            else{
                min = Math.min(nums[mid],min);
                end = mid-1;
            }
        }
        return min;
    }
    // Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target) return mid;
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target && target<=nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[end]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
