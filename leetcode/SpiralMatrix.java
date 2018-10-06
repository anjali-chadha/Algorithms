package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

        if(A == null || A.size() == 0) return null;

        int m = A.size();
        int n = A.get(0).size();


        int [][] arr = create2DArray(A);
        return spiralArray(m, n, arr);
    }

    private ArrayList<Integer> spiralArray(int m, int n, int[][] arr) {
        ArrayList<Integer> result = new ArrayList<>(m * n);

        int rowBegin = 0, rowEnd = m - 1;
        int colBegin = 0, colEnd = n - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {

            //Traverse right
            for(int i = colBegin; i <= colEnd; i++) {
                result.add(arr[rowBegin][i]);
            }
            rowBegin++;

            //Traverse down
            for(int i = rowBegin; i <= rowEnd; i++) {
                result.add(arr[i][colEnd]);
            }
            colEnd--;

            //Traverse Left
            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i --) {
                    result.add(arr[rowEnd][i]);
                }
                rowEnd--;
            }

            //Traverse Up
            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    result.add(arr[i][colBegin]);
                }
                colBegin ++;
            }
        }

        return result;
    }

    private int[][] create2DArray(List<ArrayList<Integer>> inputList) {
        int m = inputList.size();
        int n = inputList.get(0).size();
        int[][] inputArray = new int[m][n];

        int i = 0;
        for(List<Integer> l: inputList) {
            int j = 0;
            for(Integer item: l) {
                inputArray[i][j] = item;
                j++;
            }
            i++;
        }
        return inputArray;
    }

    public static void main(String args[]) {
        SpiralMatrix o = new SpiralMatrix();
        int[][] array = {{1,2},
                        {3,4},
                        {5,6}};
        o.spiralArray(3,2, array);
    }
}

