package Sorting_Patterns;

public class Selection_Sort {

    public static void main(String[] args) {
        int nums[] = {8,7,3,0,2,6,4};
        sortUsingSelectionSort(nums);
        StringBuilder sb = new StringBuilder();
        for(int i : nums){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }

    private static void sortUsingSelectionSort(int[] nums) {
        // TODO Auto-generated method stub
        // select the best and place next to sorted part;
        for(int i=0;i<nums.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            // after finding the min value just swap with the current one.
            if(i!=minIndex){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}