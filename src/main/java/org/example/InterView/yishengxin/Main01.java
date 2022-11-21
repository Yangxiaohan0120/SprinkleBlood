package org.example.InterView.yishengxin;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-10-20 16:55
 **/
public class Main01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回符合条件的组合个数
     *
     * @param candidates int整型一维数组
     * @param target int整型
     * @return int整型
     */

    int count = 0;
    int min = -1;

    public int combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        min = candidates[0];
        if(target < min)return 0;
        // write code here
        for (int i = 0; i < candidates.length; i++) {
            dfs(i, candidates, target);
        }
        return count;
    }

    public void dfs(int index, int[] candidates, int target) {
        if (target == candidates[index]) {
            count++;
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            dfs(i, candidates, target - candidates[index]);
        }

    }

    public static void main(String[] args) {
        int[] c = {2, 3, 4, 5};
        int t = 9;
        int res = new Main01().combinationSum(c, t);
        System.out.println(res);
    }


}