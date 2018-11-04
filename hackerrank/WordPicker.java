//"I would like you to write a program which is run on the command line. The program takes two arguments: the name of a file containing words, each separated by a newline, and a list of letters. 
//The program should output the longest words from the file which can be made using the letters in the list."

//Only small case alphatetical lettter
// Input - fileName, "uberattgg" 

/**Doc1.txt
 *
 * apple
 * bat
 * cat
 * dog
 * 
 * **/

/**
./bigwords my_words.txt aabbscb

O(N) - n-letters
File - M lines, averagelength N - O(MN) - Time complexity

A['a']= 2
A['b'] = 3
int longestWordLength = 0;
List<String> longestWord 
$ cat my_words.txt
aab
cab
abba -Y
abacus-N
scabs-N
scab-Y
bacca -N
ab
**/
import java.util.*;
import java.util.Arrays;
class WordPicker {
    
    public static void main(String[] args) {
        if(args.length != 3) {
            //error
           // throw new IllegalArgumentException();
        }
        
        //String fileName = args[1];
        //String letters = args[2];
        String fileName = "aab\ncab\nabba\nabacus\nscabs\nscab\nbacca\nab";
        String letters = "aabbscb";
        System.out.println(findLongestWords(fileName, letters));
        
    }
    
    private static List<String> findLongestWords(String filename, String letters) {
        List<String> result = new ArrayList<>();
        
        if(letters.isEmpty()) return result;
        
        //TODO - check file
        
        int[] countArr = new int[26];
        for(int i = 0; i < letters.length(); i++) {
            int idx = letters.charAt(i) - 'a';
            countArr[idx]++;
        }
        
        //Proces file
        String[] file = filename.split("\n");
        int longestWord = 0;
        
        for(String word: file) {
            int n = word.length();
            if(n < longestWord) continue;
            
            if(canMakeWords(word, countArr)) {
                if(n != longestWord) {
                    result.clear();
                    longestWord = n;
                }
                result.add(word);
            }
        }
        return result;
    }
    
    private static boolean canMakeWords(String input, int[] A) {
        int[] tmp = Arrays.copyOf(A, 26);
        for(int j =0; j< input.length(); j++) {
            int idx = input.charAt(j) -'a';
            if(tmp[idx] <= 0) return false;
            else tmp[idx]--;
        }
        return true;
    }
}
