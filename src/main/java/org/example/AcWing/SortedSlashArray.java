package org.example.AcWing;

/**
 * @author Chris Yang
 * created 2022-08-25 13:02
 **/
public class SortedSlashArray {

    //mat = [
    // [11,25,66,1,69,7],
    // [23,55,17,45,15,52],
    // [75,31,36,44,58,8],
    // [22,27,33,25,68,4],
    // [84,28,14,11,5,50]]
    //


    // [[5,17,4,1,52,7],
    // [11,11,25,45,8,69],
    // [14,23,25,44,58,15],
    // [22,27,31,36,50,66],
    // [84,28,75,33,55,68]]

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            insertSort(mat, i, 0, m, n);
        }
        for (int j = 1; j < n; j++) {
            insertSort(mat, 0, j, m, n);
        }
        return mat;
    }

    public void insertSort(int[][] mat, int x, int y, int m, int n) {
        int i = x + 1;
        int j = y + 1;
        while (i < m && j < n) {
            int cur = mat[i][j];
            int tmpI = i, tmpJ = j;
            while (tmpI > 0 && tmpJ > 0 && cur < mat[tmpI - 1][tmpJ - 1]) {
                mat[tmpI][tmpJ] = mat[tmpI - 1][tmpJ - 1];
                tmpI--;
                tmpJ--;
            }
            mat[tmpI][tmpJ] = cur;
            i++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {11, 25, 66, 1, 69, 7},
                {23, 55, 17, 45, 15, 52},
                {75, 31, 36, 44, 58, 8},
                {22, 27, 33, 25, 68, 4},
                {84, 28, 14, 11, 5, 50}};
        int[][] res = new SortedSlashArray().diagonalSort(mat);
        for(int i = 0 ; i < res.length ; i ++){
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }
    }

}
