package org.example.EnterpriseInterview.MIhayou;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Chris Yang
 * created 2022-08-12 10:22
 **/
public class KthLargest {

    Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length -1;
        int target = nums.length - k;
        while(true){
            int p = partition(nums,l,r);
            if(p == target)return nums[p];
            else if(p < target){
                l = p + 1;
            }else {
                r = p -1;
            }
        }
    }

    public int partition(int[] nums,int l ,int r){
        int v = l + random.nextInt(r - l + 1);
        swap(nums,l,v);

        int p = nums[l];
        int i = l;
        l += 1;

        while(true){
            while(l <= r && nums[l] < p){
                l ++;
            }


            while(l <= r && p < nums[r]){
                r --;
            }

            if(l >= r)break;

            swap(nums,l,r);
            l++;
            r--;
        }

        swap(nums,i,r);
        return r;
    }

    public void swap(int[] nums,int a ,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new KthLargest().findKthLargest(nums,k));
    }

}
