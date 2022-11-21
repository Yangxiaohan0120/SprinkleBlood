package org.example.LeetcodeThousand;

/**
 * @author Chris Yang
 * created 2022-09-04 10:29
 **/
public class Main03 {
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int i = 0;
        int max = 0;
        int j = 1;
        for (; j < nums.length; j++) {
            if(((long) nums[i] & (long) nums[j]) == 0){
                i++;j++;
            }else{
                max = Math.max(max,j-start);
                start = j;
                i = start;
            }
        }
        max = Math.max(max,j-start);
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {135745088,609245787,16,2048,2097152};
//        int[] nums = {45106826,547958667,823366125,332020148,611677524,510346561,555831456,436600904,12594192,127206768,540754485,201997978,473116514,233000361,538246458,729745279,343417143,892046691,376031730};
        int[] nums = {178830999,19325904,844110858,806734874,280746028,64,256,33554432,882197187,104359873,453049214,820924081,624788281,710612132,839991691};
        int res = new Main03().longestNiceSubarray(nums);
        System.out.println(res);
    }
}
