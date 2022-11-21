package org.example.EnterpriseInterview.ShunFeng;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

public class Main {
    static int[][] arr;
    static int m ;
    static int n;
    static boolean[][] visited;
    static List<Integer> list;
    static int startx;
    static int starty;
    static int endx;
    static int endy;
    static int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i ++){
            for(int j  = 0 ; j < n ; j ++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 2){
                    startx = i;
                    starty = j;
                }
                if(arr[i][j] == 3){
                    endx = i;
                    endy = j;
                }
            }
        }

        list = new ArrayList<>();
        visited[startx][starty] = true;
        for (int i = 0; i < d.length ; i++) {
            dfs(1,startx+d[i][0],starty+d[i][1]);
        }

        System.out.println(min);
    }

    public static void dfs(int count,int x,int y){
        // 判断是否到终点
        if(x == endx && y == endy){
            min = Math.min(min,count);
            return;
        }

        // 是否超出或者已访问或者是墙
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || arr[x][y] == 1)return;
        // 访问
        visited[x][y] = true;
        int p = 0;
        // 可以访问的点
        if(arr[x][y] == 0){
            p = 1;
        }
        // 可以访问的陷阱
        if(arr[x][y] == 4){
            p = 3;
        }
        // 可以访问的炸弹
        if(arr[x][y] == 6){
            if(x-1 >= 0)arr[x-1][y] = 0;
            if(x+1 < m)arr[x+1][y] = 0;
            if(y-1 >= 0)arr[x][y-1] = 0;
            if(y+1 < n)arr[x][y+1] = 0;
            arr[x][y] = 0;
            p = 1;
        }

        for(int i = 0 ; i < d.length ; i ++){
            dfs(count+p,x+d[i][0],y+d[i][1]);
        }

        visited[x][y] = false;

        return;
    }
}
