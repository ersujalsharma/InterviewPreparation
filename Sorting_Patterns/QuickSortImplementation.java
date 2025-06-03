/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class QuickSortImplementation
{
	public static void main(String[] args) {
		int arr[] = {3,4,5,2,1};
		quickSort(arr,0,arr.length-1);
		StringBuilder sb = new StringBuilder();
		for(int i : arr){
		    sb.append(i+" ");
		}
		System.out.println(sb);
	}
	static void quickSort(int arr[],int start,int end){
	    if(start>=end){
	        return;
	    }
	    int partition = findPartition(arr,start,end);
	    quickSort(arr,start,partition-1);
	    quickSort(arr,partition+1,end);
	}
	static int findPartition(int arr[],int start,int end){
	    int pivot = start;
	    int count = 0;
	    for(int i=start+1;i<=end;i++){
	        if(arr[i]<arr[start]){
	            count++;
	        }
	    }
	    int temp = arr[pivot];
	    arr[pivot] = arr[start+count];
	    arr[start+count] = temp;
	    balanceBothsides(arr,start,start+count,end);
	    return start+count;
	}
	static void balanceBothsides(int[] arr,int start,int pivot,int end){
	    int left = start;
	    int right = end;
	    while(left<pivot && pivot<right){
	        if(arr[left]<=arr[pivot]) left++;
	        else if(arr[right]>=arr[pivot]) right--; 
	        else{
	            int temp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = temp;
	        }
	    }
	}
}
