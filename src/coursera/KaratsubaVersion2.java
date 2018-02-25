package coursera;

import java.math.BigInteger;

/**
 * Created by anjali_chadha on 5/15/17.
 */

/**
 * Stanford Assignment: Karatsuba Multiplication
 *
 * This algorithm will handle multiplication of long numbers.
 * Handles numbers of unequal length.
 * Handles the case where length of a number is not a power of two or odd  number.
 */
public class KaratsubaVersion2 {

    public BigInteger multiply(String m1, String m2) {
        int n1 = m1.length();
        int n2 = m2.length();
        int n = 0;
        int lengthDiff = Math.abs(n1 - n2);

        //When length of two numbers is not equal, padd zeroes to the left of the number
        StringBuffer zeroesString = new StringBuffer();
        while (lengthDiff > 0 ) {
            zeroesString.append("0");
            lengthDiff --;
        }
        if(n1 > n2) {
            n = n1;
            m2 = zeroesString + m2;
        } else if (n1 < n2) {
            n = n2;
            m1 = zeroesString + m1;
        } else {
            n = n1;
        }

        if(n <= 1) {
            return new BigInteger(Integer.parseInt(m1) * Integer.parseInt(m2) + "");
        } else {
            int mid = 0;
            if(n%2 == 0) {
                mid = n/2;
            } else {
                mid = n/2+1;
            }
            String a = m1.substring(0, mid);
            String b = m1.substring(mid);
            String c = m2.substring(0, mid);
            String d = m2.substring(mid);

            BigInteger partOne = multiply(a, c);
            BigInteger partTwo = multiply(b, d);
            BigInteger partThree = multiply(new BigInteger(a).add(new BigInteger(b)) + "",
                    (new BigInteger(c).add(new BigInteger(d)) + ""))
                    .subtract(partOne).subtract(partTwo);

            BigInteger powerBy2 = BigInteger.TEN.pow(n/2);
            //Note: If this step is confusing for the odd numbers, check out the derivation of the theorem.
            //Also, if we multiply the partOne with 10^n, instead of (10^(n/2))^2, the answer will be incorrect for odd numbers.
            //Check derivation for more clarity.
            BigInteger result = powerBy2.multiply(powerBy2).multiply(partOne)
                     .add(partTwo)
                     .add(powerBy2.multiply(partThree));
            return result;
        }
    }

    public static void main(String args[]) {
        KaratsubaVersion2 o = new KaratsubaVersion2();
        BigInteger result = o.multiply("3141592653589793238462643383279502884197169399375105820974944592"
                , "2718281828459045235360287471352662497757247093699959574966967627");
        System.out.println(result);
        //Correct answer is ---->
        // 8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184
    }
}
