package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, String> digitsToLettersMap = new HashMap<>();
            digitsToLettersMap.put('2', "abc");
            digitsToLettersMap.put('3', "def");
            digitsToLettersMap.put('4', "ghi");
            digitsToLettersMap.put('5', "jkl");
            digitsToLettersMap.put('6', "mno");
            digitsToLettersMap.put('7', "pqrs");
            digitsToLettersMap.put('8', "tuv");
            digitsToLettersMap.put('9', "wxyz");
            digitsToLettersMap.put('1', "");
            digitsToLettersMap.put('0', "");

            int n = digits.length(); //Get the number of the digits.

            List<String> tempList = new ArrayList<>();
            List<String> outputList = new ArrayList<>();
            for(char c: digits.toCharArray()) {
                tempList.add(digitsToLettersMap.get(c));
            }

            if(n == 1) {
                String a = tempList.get(0);
                for(char c: a.toCharArray()) {
                    outputList.add("" + c);
                }
            }

            for(int i = 1; i < tempList.size(); i++) {
                String a = tempList.get( i - 1);
                String b = tempList.get(i);

                int a_n = a.length();
                int b_n = b.length();

                for(int p = 0; p < a_n; p++) {
                    for(int q = 0; q < b_n; q++) {

                        String comb = "" + a.charAt(p) + b.charAt(q);
                        tempList.add(i, comb);
                        outputList.add(comb);
                    }
                }
            }
            return outputList;
        }
    }
}
