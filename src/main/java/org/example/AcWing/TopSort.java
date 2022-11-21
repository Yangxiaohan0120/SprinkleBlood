package org.example.AcWing;

/**
 * @author Chris Yang
 * created 2022-08-28 14:40
 **/
import java.util.*;

public class TopSort{
    static int N = 100010;
    static int n, m = 0;
    static int[] h = new int[N];//存储头结点下标
    static int[] e = new int[N];//存储元素
    static int[] ne = new int[N];//存储下一个元素的位置
    static int[] d = new int[N];//有向图的入度
    static int[] q = new int[N];//BFS队列
    static int idx = 0;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        for(int i=0; i<N; i++){
            h[i] = -1;
        }

        for(int i=0; i<m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx++;
            d[b]++;//a->b：b的入度+1
        }

        if(topsort()){
            for(int i=0; i<n; i++){
                System.out.print(q[i] + " ");
            }
        }else{
            System.out.println(-1);
        }
    }


    public static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static boolean topsort(){

        int hh = 0;
        int tt = -1;

        //将入度为0的结点全部加入进队列中作为起始结点
        for(int i=1; i<=n; i++){
            if(d[i] == 0){
                q[++tt] = i;
            }
        }

        while(hh <= tt){
            int t = q[hh++];
            //遍历t所在的邻接表，每次将对应元素的入度-1，若为0则加入队列
            for(int i=h[t]; i!=-1; i=ne[i]){
                int j = e[i];
                d[j]--;
                if(d[j] == 0){
                    q[++tt] = j;
                }
            }
        }

        return tt == n - 1;
    }
}
