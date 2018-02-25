package leetcode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        int len = nums.length;
        return sortedArrayToBST(nums, 0, len - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        if(start > end) return null;

        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }
}
