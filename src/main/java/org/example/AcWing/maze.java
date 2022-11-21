package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-25 15:47
 **/


// DijKstra �㷨

//   ������  �ϸ���
// 0    0
// 1    4    0
// 2    12   1
// 3    INF
// 4    INF
// 5    INF
// 6    9    7
// 7    8    0
// 8    15   7

// �㷨��Ҫ��
// ����������������¾���
// ��δѡ���λ������ѡ��������ĵ�����ܱߵľ���


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
        // ����֮������о���������Ϊ����󣬷���֮������״αȽ�
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int l = 0; l < 4; l++) {
                    dist[i][j][l] = INF;
                    // ����λ���뷽������Ϊδ���ʹ�
                    st[i][j][l] = false;
                }

        // ����˫�˶���
        int hh = 0, tt = 0;
        // �����ĸ�����
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        // ���������ĸ����򣺼�����У�������x,����y,����
        for (int i = 0; i < 4; i++) {
            q[tt++] = new Node(sx, sy, i);
            // ��������ľ���Ϊ0
            dist[sx][sy][i] = 0;
        }

        // ִ�ж���
        while (hh != tt) {
            Node t = q[hh];
            hh = get(hh + 1);

            // ���ĸ�����һ�γ��ԣ�ִ�й�������
            if (st[t.x][t.y][t.z]) continue;
            // δ�������ȱ��Ϊtrue
            st[t.x][t.y][t.z] = true;

            // ��ȡ���������������������
            int distance = dist[t.x][t.y][t.z];
            // �������k ����
            if (distance > k) continue;
            // ��������յ㣬����true
            if (tx == t.x && ty == t.y) return true;

            // ���ĸ�����ǰ��
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                int w = 0;
                // �ж��·����Ƿ���ģ�������Ҫdis + 1
                if (i != t.z) w = 1;
                // �ж�·�Ƿ��ߵ�ͨ
                if (x >= 0 && x < n && y >= 0 && y < m && g[x].charAt(y) == '.') {
                    // ���������ͨ�����ж��Ƿ�����Ը���ľ��뵽�������Ը��¾���
                    if (dist[x][y][i] > distance + w) {
                        // ���¾���
                        dist[x][y][i] = distance + w;
                        // ������򲻱䣬����Ϊ��ǰ�ڵ�
                        if (w == 0) {
                            hh = get(hh - 1);
                            q[hh] = new Node(x, y, i);
                        } else {
                            // �������ı䣬�����µĽڵ�
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
            // �Ƿ������ͨ
            if (bfs()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
