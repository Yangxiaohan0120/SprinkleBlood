package org.example.EnterpriseInterview.zijie;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-10-09 10:06
 **/
public class FireDragon {

    static List<Pair<Integer,Integer>> list = new ArrayList<>();
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean[][] visited ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        visited = new boolean[n][m];
        int startx = -1, starty = -1;
        int endx = -1, endy = -1;
        Map<Character,Integer> Dirmap = new HashMap<>();
        Dirmap.put('D',1);
        Dirmap.put('S',2);
        Dirmap.put('A',3);
        Dirmap.put('W',4);

        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'O') {
                    startx = i;
                    starty = j;
                }
                if (map[i][j] == 'X') {
                    endx = i;
                    endy = j;
                }
            }
        }
        int[][] ways = findways(map,startx,starty,endx,endy);
        int times = sc.nextInt();
        List<List<Integer>> dragon = new ArrayList<>();
        List<List<Integer>> monster = new ArrayList<>();
        HashMap<Integer,List<Integer>> rollingMap = new HashMap<>();
        int maxtime = 0;
        for (int i = 0; i < times; i++) {
            int index = sc.nextInt();
            if(index == 1){
                int time = sc.nextInt();
                List<Integer> list = new ArrayList<>();
                list.add(sc.nextInt());
                list.add(sc.nextInt());
                list.add(Dirmap.get(sc.next()));
                rollingMap.put(i,list);
                maxtime = Math.max(maxtime,time);
            }else if(index == 2){
                int time = sc.nextInt();
                List<Integer> list = new ArrayList<>();
                list.add(sc.nextInt());
                rollingMap.put(i,list);
                maxtime = Math.max(maxtime,time);
            }
        }

        int[][] monsters = new int[n][m];

        for (int i = 0; i < maxtime; i++) {
            if(rollingMap.containsKey(i)){
                if(rollingMap.get(i).size() == 1){

                }
            }
        }
    }

    public static int[][] findways(char[][] map,int startx,int starty,int endx,int endy) {
        dfs(map,startx,starty,endx,endy);
        int[][] ways = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ways[i][0] = list.get(i).getKey();
            ways[i][1] = list.get(i).getValue();
        }
        return ways;
    }

    public static void dfs(char[][] map,int x,int y,int a,int b){
        if(x == a && y == b)return;
        visited[x][y] = true;
        for (int i = 0; i < directions.length; i++) {
            int newx = x + directions[i][0];
            int newy = y + directions[i][1];
            if(newx >= 0 && newx < map.length && newy >=0 && newy < map[0].length && !visited[newx][newy] && map[newx][newy] == '*'){
                list.add(new Pair<>(directions[i][0],directions[i][1]));
                dfs(map,newx,newy,a,b);
            }
        }
    }
}
