/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class MergeSortImplementation
{
	public static void main(String[] args) {
		int arr[] = {2,5,1,6,9};
		mergeSort(arr,0,arr.length-1);
		StringBuilder sb = new StringBuilder();
		for(int i : arr){
		    sb.append(i+" ");
		}
		System.out.println(sb);
	}
	public static void mergeSort(int[] arr,int start,int end){
	    if(start >= end) return;
	    int mid = start+ (end-start)/2;
	    mergeSort(arr,start,mid); // sorting left part
	    mergeSort(arr,mid+1,end); // sorting right part
	    merge(arr,start,mid,end);
	}
	public static void merge(int[] arr,int start,int mid,int end){
	    int firstStart = start;
	    int secondStart = mid+1;
	    int temp[] = new int[end-start+1];
	    int k =0;
	    while(firstStart<=mid && secondStart<=end){
	        if(arr[firstStart]<arr[secondStart]){
	            temp[k++] = arr[firstStart++];
	        }
	        else{
	            temp[k++] = arr[secondStart++];
	        }
	    }
	    while(firstStart<=mid){
	        temp[k++] = arr[firstStart++]; 
	    }
	    while(secondStart<=end){
	        temp[k++] = arr[secondStart++];
	    }
	    for(int i=start;i<=end;i++){
	        arr[i] = temp[i-start];
	    }
	}
}
