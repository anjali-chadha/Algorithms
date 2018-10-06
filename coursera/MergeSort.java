package coursera;

/**
 * Created by anjali_chadha on 5/14/17.
 */
public class MergeSort {

    public int[] sortArray(int[] input) {
        if(input.length <= 1)
            return input;
        return mergeSort(input, 0, input.length-1);
    }

    private int[] mergeSort(int[] input, int start, int end) {
        if(start == end) {
            //Single element in the array
            return new int[]{input[start]};
        } else {
            //More than one element in the array
            int mid = (start + end) / 2;
            int[] leftArr = mergeSort(input, start, mid);
            int[] rightArr = mergeSort(input, mid+1, end);
            return merge(leftArr, rightArr, start, end);
        }
    }

    private int[] merge(int[] left, int right[], int start, int end) {
        int length = end - start + 1;
        int[] result = new int[length];
        int i = 0; //index for left array
        int j = 0; //index for right array
        for(int k = 0; k < length; k ++) {
            if(i < left.length && j< right.length) {
                if (left[i] > right[j]) {
                    result[k] = right[j];
                    j++;
                } else if (i < left.length) {
                    result[k] = left[i];
                    i++;
                }
            } else if(i >= left.length) {
                result[k] = right[j];
                j++;
            } else {
                result[k] = left[i];
                i++;
            }
        }
        return result;
    }

    public void printArray(int[] input) {
        int n = input.length;
        for(int i = 0; i< n; i ++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MergeSort o = new MergeSort();
        int[] arr1 = {1,10,2,9,3,8,100,4,5,7,6};
        int[] result = o.sortArray(arr1);
        o.printArray(result);
    }

}
