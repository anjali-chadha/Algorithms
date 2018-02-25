package leetcode;

public class Powerxn {
    public double myPow(double x, long n) {
        if(n < 0) {
            n = n * -1;
            return 1.0 / myPow(x, n);
        }

        if(n == 0) return 1;
        else if(n % 2 == 0) {
            double temp = myPow(x, n/2);
            return temp * temp;
        } else {
            double temp = myPow(x, n/2);
            return temp * temp * x;
        }

    }

    public static void main(String[] args) {
        Powerxn o = new Powerxn();
        o.myPow( 1.00000,-2147483648);
    }
}
