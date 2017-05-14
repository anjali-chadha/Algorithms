import org.junit.Test;

/**
 * Created by anjali_chadha on 5/14/17.
 */

public class MergeSortTest {

    @Test
    public void testEmptyArray(){
        MergeSort o = new MergeSort();
        int[] input = {};
        o.printArray(o.sortArray(input));
    }

    @Test
    public void testSingleElementArray(){
        MergeSort o = new MergeSort();
        int[] input = {4};
        o.printArray(o.sortArray(input));
    }

    @Test
    public void testEvenLengthArray(){
        MergeSort o = new MergeSort();
        int[] input = {10,9,8,7};
        o.printArray(o.sortArray(input));
    }

    @Test
    public void testOddLengthArray(){
        MergeSort o = new MergeSort();
        int[] input = {10,9,8,7};
        o.printArray(o.sortArray(input));
    }

    @Test
    public void testArrayWithDuplicates(){
        MergeSort o = new MergeSort();
        int[] input = {10,9,8,7,10,8,4,4};
        o.printArray(o.sortArray(input));
    }

}
