package org.example.HuaweiACM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 13:52
 **/
public class Sudoku {
    public static void main(String[] args) {

        //5 0 0 0 3 0 7 4 0
        //0 0 0 0 0 0 0 0 1
        //0 6 1 9 0 8 0 0 0
        //4 0 6 5 0 9 0 2 0
        //0 1 7 3 2 0 8 6 5
        //0 0 0 0 6 7 4 3 0
        //3 7 0 8 5 0 0 1 2
        //0 2 8 4 9 0 0 0 6
        //0 5 9 7 1 2 3 8 4
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] data = new int[9][9];
            ArrayList<HashSet<Integer>> row = new ArrayList<HashSet<Integer>>();
            ArrayList<HashSet<Integer>> col = new ArrayList<HashSet<Integer>>();
            ArrayList<HashSet<Integer>> squ = new ArrayList<HashSet<Integer>>();

            for (int i = 0; i < 9; i++) {
                row.add(new HashSet<Integer>());
                col.add(new HashSet<Integer>());
                squ.add(new HashSet<Integer>());
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    data[i][j] = sc.nextInt();
                    if (data[i][j] != 0) {
                        row.get(i).add(data[i][j]);
                        col.get(j).add(data[i][j]);
                        squ.get(i / 3 * 3 + j / 3).add(data[i][j]);
                    }
                }
            }

            dfs(data, row, col, squ, 0);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (j != 8)
                        System.out.print(data[i][j] + " ");
                    else
                        System.out.println(data[i][j]);
                }
            }
        }
        sc.close();
    }


    public static boolean dfs(int[][] data, ArrayList<HashSet<Integer>> row, ArrayList<HashSet<Integer>> col, ArrayList<HashSet<Integer>> squ, int index) {
        if (index == 81)
            return true;
        int m = index / 9;
        int n = index % 9;
        int k = m / 3 * 3 + n / 3;

        if (data[m][n] != 0) {
            return dfs(data, row, col, squ, index + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!row.get(m).contains(i) && !col.get(n).contains(i) && !squ.get(k).contains(i)) {
                    data[m][n] = i;
                    row.get(m).add(i);
                    col.get(n).add(i);
                    squ.get(k).add(i);
                    if (dfs(data, row, col, squ, index + 1))
                        return true;
                    data[m][n] = 0;
                    row.get(m).remove(i);
                    col.get(n).remove(i);
                    squ.get(k).remove(i);
                }
            }
            return false;
        }
    }
}
