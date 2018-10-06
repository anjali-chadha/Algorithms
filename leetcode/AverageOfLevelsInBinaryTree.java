package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    private long[] sums;
    private int[] counts;
    public List<Double> averageOfLevels(TreeNode root) {
        sums = new long[10000];
        counts = new int[10000];

        averageOfLevels(root, 0);

        List<Double> result = new ArrayList<>();
        int i = 0;

        while(counts[i] != 0) {
            result.add((double)sums[i]/ counts[i]);
            i++;
        }
        return result;
    }

    private void averageOfLevels(TreeNode node, int h) {
        if(node == null) {
            return;
        }
        sums[h] += node.val;
        counts[h]++;
        averageOfLevels(node.left, h+1);
        averageOfLevels(node.right, h+1);
    }
}
