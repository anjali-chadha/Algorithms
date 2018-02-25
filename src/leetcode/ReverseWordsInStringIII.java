package leetcode;

public class ReverseWordsInStringIII {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String w: words)  {
            sb.append(reverse(w)).append(" ");
        }
        return sb.toString().trim();
    }

    private String reverse(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for(int i = 0; i < n/2; i++) {
            char tmp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = tmp;
        }
        return new String(arr);
    }
}
