package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pascal1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        if(numRows != 0) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            output.add(l);
        }

        int i = 1;
        while(i < numRows) {
            List<Integer> previousList = output.get(i-1);
            List<Integer> e = new ArrayList<>();
            int n = previousList.size();

            e.add(previousList.get(0));
            for(int j = 1; j < n; j++) {
                int a = previousList.get(j - 1);
                int b = previousList.get(j);
                e.add(a+b);
            }

            e.add(previousList.get(n-1));
            output.add(e);
            i++;
        }
        return output;
    }

    public static void main(String[] args) {
        Pascal1 o = new Pascal1();
        System.out.println(o.generate(4));
    }
}
