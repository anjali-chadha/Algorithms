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
