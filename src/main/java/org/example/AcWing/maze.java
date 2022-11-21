package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-25 15:47
 **/


// DijKstra 算法

//   出发点  上个点
// 0    0
// 1    4    0
// 2    12   1
// 3    INF
// 4    INF
// 5    INF
// 6    9    7
// 7    8    0
// 8    15   7

// 算法纲要：
// 如果距离更近，则更新距离
// 从未选择的位点中挑选距离最近的点更新周边的距离


class Node {
    int x, y, z;

    Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class maze {
    private final static int N = 110, M = N * N * 4, INF = 100000000;
    private static int n, m, k;
    private static int sx, sy, tx, ty;
    private static String[] g = new String[N];
    private static int[][][] dist = new int[N][N][4];
    private static boolean[][][] st = new boolean[N][N][4];
    private static Node[] q = new Node[M];

    private static int get(int x) {
        return (x + M) % M;
    }

    private static boolean bfs() {
        // 相邻之间的所有距离先设置为无穷大，方便之后进行首次比较
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int l = 0; l < 4; l++) {
                    dist[i][j][l] = INF;
                    // 所有位点与方向都设置为未访问过
                    st[i][j][l] = false;
                }

        // 设置双端队列
        int hh = 0, tt = 0;
        // 设置四个方向
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        // 从起点出发四个方向：加入队列，（坐标x,坐标y,方向）
        for (int i = 0; i < 4; i++) {
            q[tt++] = new Node(sx, sy, i);
            // 自身到自身的距离为0
            dist[sx][sy][i] = 0;
        }

        // 执行队列
        while (hh != tt) {
            Node t = q[hh];
            hh = get(hh + 1);

            // 从四个方向一次尝试，执行过则跳过
            if (st[t.x][t.y][t.z]) continue;
            // 未来过则先标记为true
            st[t.x][t.y][t.z] = true;

            // 获取距离这里距离计作拐弯次数
            int distance = dist[t.x][t.y][t.z];
            // 如果大于k 跳过
            if (distance > k) continue;
            // 如果到达终点，返回true
            if (tx == t.x && ty == t.y) return true;

            // 向四个方向前进
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                int w = 0;
                // 判断新方向是否更改，更改需要dis + 1
                if (i != t.z) w = 1;
                // 判断路是否走的通
                if (x >= 0 && x < n && y >= 0 && y < m && g[x].charAt(y) == '.') {
                    // 如果可以走通，再判断是否可以以更快的距离到达，如果可以更新距离
                    if (dist[x][y][i] > distance + w) {
                        // 更新距离
                        dist[x][y][i] = distance + w;
                        // 如果方向不变，更新为当前节点
                        if (w == 0) {
                            hh = get(hh - 1);
                            q[hh] = new Node(x, y, i);
                        } else {
                            // 如果方向改变，增加新的节点
                            q[tt] = new Node(x, y, i);
                            tt = get(tt + 1);
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i < n; i++) g[i] = sc.next();
            k = sc.nextInt();
            sy = sc.nextInt() - 1;
            sx = sc.nextInt() - 1;
            ty = sc.nextInt() - 1;
            tx = sc.nextInt() - 1;
            // 是否可以走通
            if (bfs()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
