package Sorting_Patterns;

public class Bubble_Sort {
    // In Bubble we compare adjacent and move largest to last;
    
        public static void main(String[] args) {
            // int nums[] = {8,7,3,0,2,6,4};
            int nums[] = {1,2,3,4,5,6,7,8};
            sortUsingBubbleSort(nums);
            StringBuilder sb = new StringBuilder();
            for(int i : nums){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }

        private static void sortUsingBubbleSort(int[] nums) {
            // TODO Auto-generated method stub
            int n = nums.length;
            int count = 0;
            for(int i=0;i<n-1;i++){ // each time one should be placed at right and the last will automatically placed on it's place
                boolean swap = false;
                for(int j=0;j<n-i-1;j++){ // as we know each time we are placing largest at last then don't touch after placing.
                    if(nums[j]>nums[j+1]){
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                        swap = true;
                    }
                    count++;
                }
                if(!swap){ // already sorted cause if there is no swap then all in order
                    break;
                }
            }
            System.out.println(count);
        }
}
