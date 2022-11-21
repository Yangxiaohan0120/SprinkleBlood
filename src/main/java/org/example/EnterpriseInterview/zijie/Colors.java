package org.example.EnterpriseInterview.zijie;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-09 10:05
 **/
public class Colors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        String color = sc.nextLine();
        HashMap<Integer,Integer> mapB = new HashMap<>();
        HashMap<Integer,Integer> mapR = new HashMap<>();
        for (int i = 0; i < color.length(); i++) {
            if(color.charAt(i) == 'B'){
                if(mapB.containsKey(nums[i])){
                    mapB.put(nums[i],mapB.get(nums[i]) + 1);
                }else{
                    mapB.put(nums[i],1);
                }
            }else{
                if(mapR.containsKey(nums[i])){
                    mapR.put(nums[i],mapR.get(nums[i]) + 1);
                }else{
                    mapR.put(nums[i],1);
                }
            }
        }

        List<Pair<Integer,Long>> listB = new ArrayList<>();
        List<Pair<Integer,Long>> listR = new ArrayList<>();



    }
}
