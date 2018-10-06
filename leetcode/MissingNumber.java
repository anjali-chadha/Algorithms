package leetcode;

public class MissingNumber {
    /**
     * Input array has all numbers which occur twice except one. Find that number.
     * Try to use without using extra space.
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int xor = nums[0];
        for(int i = 1; i < len; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
