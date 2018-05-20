public class Solution {
   //First attempt - Unpolished solution
   public ArrayList<Integer> plusOne_v1(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        
        //Error checking
        if(A == null || A.size() == 0) return result;
        
        int size = A.size();
        boolean carry = false;
        
        int index = size - 1;
        while(index >= 0) {
            int add1 = A.get(index) + 1;
            carry = (add1/10) != 0;
            A.set(index, add1%10);
            
            if(!carry) break;
            index--;
        }
        
        if(carry) {
        //Shift the list to right by 1;
        result.add(1);
        result.addAll(A);
        } else {
            //Remove the starting zeros
           
            int i = 0;
            while(A.get(i) == 0){i++;}
            while(i < size) {
                result.add(A.get(i++));
            }
        }
        return result;
    }
}
