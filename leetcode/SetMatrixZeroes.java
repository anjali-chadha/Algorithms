package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;

        Set<Location> zeroSet = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    zeroSet.add(new Location(i, j));
                }
            }
        }

        for(Location l: zeroSet) {
            for(int j = 0; j < n; j++) {
                matrix[l.row][j] = 0;
            }
            for(int i = 0; i < m; i++) {
                matrix[i][l.column] = 0;
            }
        }
        return;
    }
    class Location{
        int row;
        int column;

        Location(int row, int column) {
            this.row = row;
            this.column= column;
        }
    }
}
