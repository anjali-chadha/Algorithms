package leetcode;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int start = 0;
        int end = n - 1;

        int result = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;

            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1] )) {
                result = mid;
                break;
            } else if(nums[mid] < nums[mid + 1] ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
