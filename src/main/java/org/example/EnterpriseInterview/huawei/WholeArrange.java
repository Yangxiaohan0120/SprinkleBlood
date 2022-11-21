package org.example.EnterpriseInterview.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-09-27 16:19
 **/
public class WholeArrange {

    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> arrange(int n) {
        visited = new boolean[n + 1];
        List<Integer> res = new ArrayList<>();
        dfs(0, n, res);

        return list;
    }

    public void dfs(int index, int n, List res) {
        if (index == n) {
            list.add(new ArrayList<>(res));
            return;
        }


        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res.add(i);
                dfs(index + 1, n, res);
                visited[i] = false;
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>> list = new WholeArrange().arrange(n);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
    }

}
