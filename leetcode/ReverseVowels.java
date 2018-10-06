package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        List<Integer> l = new ArrayList<>();

        int index = 0;
        for(char c: s.toCharArray()) {
            if(vowelSet.contains(c)) {
                l.add(index);
            }
            index++;
        }

        if(l.isEmpty()) {
            return s;
        }

        int[] indexArray = l.stream().mapToInt(i->i).toArray();
        char[] input = s.toCharArray();
        int len = indexArray.length;

        for(int i = 0; i < len/2; i ++) {
            int index1 = indexArray[i];
            int index2 = indexArray[len-i-1];
            swap(input, index1, index2);
        }
        return new String(input);
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
