package coursera; /**
 * Created by anjali_chadha on 5/14/17.
 */

/**
 * This algorithm will be suitable for multiplying numbers that fit into long data type.
 *
 */
public class KaratsubaVersion1 {

    private int findNumberOfDigits(long n) {
        long q = n;
        int count = 0;
        while(q != 0) {
            count++;
            q = q / 10;
        }
        return count;
    }

    public long multiply(long m1, long m2) {
        int n1 = findNumberOfDigits(m1);
        int n2 = findNumberOfDigits(m2);
        int n = (n1 > n2)? n1 : n2;
        if(n <= 1) {
            return m1 * m2;
        } else {
            long power = (long)Math.pow(10.0,(n/2));
            long a = m1 / power;
            long b = m1 % power;
            long c = m2 / power;
            long d = m2 % power;

            long partOne = multiply(a, c);
            long partTwo = multiply(b, d);
            long partThree = multiply((a+b), (c+d));

            long result = power * power * partOne + partTwo + power * (partThree - partOne - partTwo);
            return result;
        }
    }

    public static void main(String args[]) {
        KaratsubaVersion1 o = new KaratsubaVersion1();
        long result = o.multiply(102, 102);
        System.out.println(result);
    }
}
