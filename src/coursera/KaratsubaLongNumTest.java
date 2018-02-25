package coursera;

//import org.junit.Test;

/**
 * Created by anjali_chadha on 5/15/17.
 */
public class KaratsubaLongNumTest {
  //  @Test
    public void testNumbersWithDigitsPower2n() {
     KaratsubaVersion1 o = new KaratsubaVersion1();
     long result = o.multiply(12345678, 87654321);
     assert (result == 1082152022374638L);
    }

    //@Test
    public void testNumbersWithDigitsPowerNot2n() {
        KaratsubaVersion1 o = new KaratsubaVersion1();
        long result = o.multiply(123456, 654321);
        assert (result == 80779853376L);
    }

    //@Test
    public void testNumbersWithUnequalLength() {
        KaratsubaVersion1 o = new KaratsubaVersion1();
        long result = o.multiply(9876543210L, 123);
        assert (result == 1214814814830L);
    }

}
