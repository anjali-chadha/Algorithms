//https://leetcode.com/problems/integer-to-english-words/submissions/

class Solution {
    private String[] singleDigit = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] twoDigit = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    private String[] tensMultiple = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num <= 0) return "Zero";
        
        StringBuilder result = new StringBuilder();
        if (num >= 1000000000)
         result.append(numberToWords(num/1000000000)).append(" Billion ").append((num%1000000000 == 0)? "": numberToWords(num%1000000000));
        else if (num >= 1000000) 
            result.append(numberToWords(num/1000000)).append(" Million ").append(num%1000000 == 0? "" : numberToWords(num % 1000000));
        else if (num >= 1000) 
            result.append(numberToWords(num/1000)).append(" Thousand ").append(num%1000 == 0? "" : numberToWords(num%1000));
        else if (num >= 100) 
            result.append(numberToWords(num/100)).append(" Hundred ").append(num%100 == 0? "": numberToWords(num%100));
        else if (num >= 10 && num%10 == 0)
            result.append(tensMultiple[num/10]);
        else if (num > 10 && num < 20) 
            result.append(twoDigit[num - 10]);
        else if (num > 20)
            result.append(tensMultiple[num/10]).append(" ").append(numberToWords(num%10));
        else if (num < 10)
             result.append(singleDigit[num]);
        return result.toString().trim();
    }
}
