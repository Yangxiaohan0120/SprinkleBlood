package org.example.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-09 19:51
 **/
public class findIsland {


    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static List<Integer> count = new ArrayList<>();

    static int max = 0;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
//            System.out.println(sc.nextLine());
            list.add(sc.nextLine());
        }
        int m = list.size();
        int n = list.get(0).split(",").length;
        System.out.println(m);
        System.out.println(n);
        int[][] arr = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String temp = list.get(i);
            String[] temps = temp.split(",");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temps[j]);
            }
        }

        find(arr, m, n, 0, 0, 0);

        for (int i = 0; i < count.size(); i++) {
            max = Math.max(count.get(i), max);
        }
        System.out.println(max);
    }

    public static int test(){
        int max = 0;
        for (int i = 0; i < count.size(); i++) {
            max = Math.max(count.get(i), max);
        }
        return max;
    }



    public static void find(int[][] arr, int m, int n, int x, int y, int area) {
        // 如果访问过或者出界则返回
        if (!inArea(m, n, x, y) || visited[x][y]) return;

        visited[x][y] = true;

        if (arr[x][y] == 1) {
            for (int i = 0; i < dir.length; i++) {
                find(arr, m, n, x + dir[i][0], y + dir[i][1], area + arr[x][y]);
            }
        } else {
            count.add(area);
            for (int i = 0; i < dir.length; i++) {
                find(arr, m, n, x + dir[i][0], y + dir[i][1], 0);
            }
        }
    }

    public static boolean inArea(int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        else return true;
    }


}

//class test {
//    public static void main(String[] args) {
//        int[][] arr = {
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//        };
//
//        int m = arr.length;
//        int n = arr[0].length;
//        Main test = new Main();
//        test.find(arr,m,n,0,0,0);
//        System.out.println(test.max);
//    }
//}
