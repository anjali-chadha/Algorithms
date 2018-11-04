/*
Algorithm 1: Using extra result array (Space sub-optimal)
Time Complexity - O(N)

Algorithm 2: Two pointer approach
Current Pointer and LastNonZeroElement Pointer
Keep Swapping them when even a non zero element is found
*/
package leetcode;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        for(int j = count; j< nums.length; j++) {
            nums[j] = 0;
        }
    }
}
