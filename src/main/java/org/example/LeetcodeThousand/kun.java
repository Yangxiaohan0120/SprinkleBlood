package org.example.LeetcodeThousand;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-09-11 10:33
 **/
public class kun {
    public int mostFrequentEven(int[] nums) {
        int[] hash = new int[100010];
        int max = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                hash[nums[i]]++;
                if (hash[nums[i]] == max && nums[i] < res) {
                    res = nums[i];
                } else if (hash[nums[i]] > max) {
                    res = nums[i];
                    max = hash[nums[i]];
                }
            }
        }
        return res;
    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] res = new int[intervals.length];
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (res[i] == 1) {
                continue;
            } else {
                max++;
                int start = intervals[i][0];
                int end = intervals[i][1];
                res[i] = 1;
                for (int j = i + 1; j < intervals.length; j++) {
                    if (res[j] == 1) continue;
                    if (intervals[j][0] > end) {
                        res[j] = 1;
                        end = intervals[j][1];
                    }
                }
            }
        }
        return max;
    }

    public int partitionString(String s) {
        int l = 0;
        int max = 0;
        while (l < s.length()) {
            int[] has = new int[26];
            int r = l + 1;
            has[s.charAt(l) - 'a'] = 1;
            while (r < s.length() && has[s.charAt(r) - 'a'] == 0) {
                has[s.charAt(r) - 'a']++;
                r++;
            }
            if (l < r) {
                max += 1;
            }
            l = r;
        }
        return max;
    }

    public int minGroups1(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });
//        int[] res = new int[intervals.length];
        int max = 1;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                end = intervals[i][1];
            } else {
                queue.add(new Pair<>(intervals[i][0], intervals[i][1]));
            }
        }

        while (!queue.isEmpty()) {
            max++;
            Pair pair = queue.poll();
            end = (int) pair.getValue();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                if (queue.peek().getKey() > end) {
                    end = queue.peek().getValue();
                    queue.poll();
                } else {
                    queue.add(queue.poll());
                }
            }
        }
        return max;
    }

    public int minGroups2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });
        Queue<Integer> q = new PriorityQueue<>();
        for(int[] cur : intervals){
            int start = cur[0];
            int end = cur[1];
            if(q.isEmpty()){
                q.offer(end);
            }else{
                if(start <= q.peek())q.offer(end);
                else{
                    q.poll();
                    q.offer(end);
                }
            }
        }

        return q.size();

    }

    public int lengthOfLIS(int[] nums, int k) {
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && nums[i] - nums[j] <= k) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < f.length; i++) {
            res = Math.max(f[i], res);
        }
        return res;
    }

    public int lengthOfLIS1(int[] nums, int k) {

        int len = 0;
        int[] f = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (f[mid] < nums[i]) l = mid;
                else{
                    r = mid - 1;
                }
            }
            len = Math.max(len, r + 1);
            f[r + 1] = nums[i];
        }

        int max = 0;
        int l = 1;
        while (l < f.length) {
            int r = l + 1;
            while (r < f.length && f[r] != 0 && f[r] - f[r-1] <= k) {
                r++;
            }
            max = Math.max(max,r-l);
            l = r;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {8154, 9139, 8194, 3346, 5450, 9190, 133, 8239, 4606, 8671, 8412, 6290};
//        System.out.println(new kun().mostFrequentEven(nums));
//        int[][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
//        int[][] intervals1 = {{1,3},{5,6},{8,10},{11,13}};
//        System.out.println(new kun().minGroups1(intervals));
//        int[] nums = {7,4,5,1,8,12,4,7};
//        int[] nums = {4,2,1,4,3,4,5,8,15};
//        int k = 5;
//        int[] nums = {1,5}; int k = 1;
//        int[] nums = {1,100,500,100000,100000};
//        int k = 100000;

        int[] nums = {10,3,20,2,16,12};
        int k = 4;
        System.out.println(new kun().lengthOfLIS1(nums,k));
//        String s = "abacaba";
//        System.out.println(new kun().partitionString(s));
    }
}
