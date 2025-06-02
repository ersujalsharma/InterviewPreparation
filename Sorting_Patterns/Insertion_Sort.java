package Sorting_Patterns;

public class Insertion_Sort {
    // Pick a Number and place in sorted Part.
    // adaptable && stable
    public static void main(String[] args) {
            int nums[] = {8,7,3,0,2,6,4};
            // int nums[] = {1,2,3,4,5,6,7,8};
            sortUsingInsertionSort(nums);
            StringBuilder sb = new StringBuilder();
            for(int i : nums){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }

    private static void sortUsingInsertionSort(int[] nums) {
        // TODO Auto-generated method stub
        for(int i=1;i<nums.length-1;i++){
            int temp = nums[i];
            int j = i-1;
            while(j>=0 && nums[j]>temp){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp; 
        }
    }
}
