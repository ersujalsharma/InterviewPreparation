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
}
