package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        if(A == null || B == null || A.length != B.length) {
            throw new IllegalArgumentException("Invalid values");
        }

        Map<Integer, List<Integer>> valueIndexMapping = new HashMap<>();
        for(int i = 0; i < B.length; i++ ) {
            int key = B[i];
            int value = i;
            if(valueIndexMapping.containsKey(key)) {
                valueIndexMapping.get(key).add(value);
            } else {
                List<Integer> list = new ArrayList<>(value);
                valueIndexMapping.put(key, list);
            }
        }

        int[] result = new int[A.length];

        for(int j = 0; j < A.length; j++) {
            int key = A[j];
            int value = valueIndexMapping.get(key).remove(0);
            result[j] = value;
        }

        return result;
    }
}
