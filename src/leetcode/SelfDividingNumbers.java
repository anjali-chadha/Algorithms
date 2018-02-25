package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i = left; i<= right; i++) {
            if(isSelfDividing(i)) result.add(i);
        }
        return result;
    }

    private boolean isSelfDividing(int number) {
        int n = number;
        while(n != 0) {
            int rem = n%10;
            if(rem == 0 || number % rem != 0) return false;
            n /= 10;
        }
        return true;
    }
}
