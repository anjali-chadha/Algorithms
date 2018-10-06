package leetcode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] cleanInputArr = cleanString(s).toCharArray();
        int len = cleanInputArr.length;

        for(int i = 0; i < len/2; i++) {
            if(cleanInputArr[i] != cleanInputArr[len-i-1]) {
                return false;
            }
        }

        return true;
    }

    private String cleanString(String s) {
        String lowerCase = s.toLowerCase();
        return lowerCase.replaceAll("[^A-Za-z0-9]", "");
    }
}
