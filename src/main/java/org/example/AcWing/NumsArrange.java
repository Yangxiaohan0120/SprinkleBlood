package org.example.AcWing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-10-11 16:57
 **/
public class NumsArrange {

    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permutation(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        dfs(0, nums, ans, visited);
        return list;
    }

    public void dfs(int index, int[] nums, List<Integer> ans, boolean[] visited) {
        if (index == nums.length) {
            list.add(new ArrayList(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            else {
                visited[i] = true;
                ans.add(nums[i]);
                dfs(index + 1, nums, ans, visited);
                ans.remove(ans.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> list = new NumsArrange().permutation(nums);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
