package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BestAverageGrade {
    /*
 * Complete the function below.
 */

   /*
 * Complete the function below.
 */

    static int bestAverageGrade(String[][] scores) {
        int n = scores.length;

        double ans = -99999999;

        Map<String, DT> map = new HashMap<>();


        for(int i = 0; i < n; i++) {
            String name = scores[i][0];
            double marks = Double.parseDouble(scores[i][1]);

            if(!map.containsKey(name)) {
                map.put(name, new DT(marks, 1));
            } else {
                DT oldValue = map.get(name);
                map.put(name, new DT(oldValue.total + marks, oldValue.count + 1));
            }
        }

        for(DT e: map.values()) {
            double a = (e.total/e.count);
            ans = Math.max(ans, (double)a);
        }
        return (int)ans;
    }
    static class DT {
        double total;
        int count;

        DT(double total, int count) {
            this.total = total;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        String[][] s = {{"a", "-99"}, {"a", "-88"}};
        System.out.println(bestAverageGrade(s));
    }

}
