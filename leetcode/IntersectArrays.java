package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectArrays {
    /**
     * Arrays can be in any order.
     *
     * O(n) - Time Complexity
     * O(n) - Space Complexity
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = createHashMap(nums1);
        List<Integer> intersect = new ArrayList<>();
        for(int a: nums2) {
            if(map1.containsKey(a)) {
                int val = map1.get(a);
                if(val == 1) {map1.remove(a);}
                else {map1.put(a, val-1);}
                intersect.add(a);
            }
        }
        return intersect.stream().mapToInt(x->x).toArray();
    }

    private Map<Integer, Integer> createHashMap(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i: arr) {
            if(countMap.containsKey(i)) {
                int val = countMap.get(i);
                countMap.put(i, val+1);
            } else {
                countMap.put(i, 1);
            }
        }
        return countMap;
    }

    /**
     * Assume the arrays are sorted.
     * How will you optimise your algorithms?
     * Using merge routine as in merge sort
     * Time Complexity = O(m + n)
     */

    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0, j =0;
        int len1 = nums1.length;
        int len2 = nums2.length;

        List<Integer> output = new ArrayList<>();

        while(i < len1 && j < len2) {
            if(nums1[i] > nums1[j]) {
                j++;
            } else if (nums1[i] < nums1[j]) {
                i++;
            } else {
                output.add(nums1[i]);
                i++;
                j++;
            }
        }
        return output.stream().mapToInt(Integer:: intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectArrays o = new IntersectArrays();
        int[] nums1 = {1, 1, 2, 3};
        int[] nums2 = {0,1,2,2,2,3,3,4};
        o.intersect(nums1, nums2);
    }
}
