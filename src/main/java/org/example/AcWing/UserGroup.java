package org.example.AcWing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-08-16 16:02
 **/
public class UserGroup {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if(!map.containsKey(groupSizes[i])){
                List list = new ArrayList();
                List s1 = new ArrayList();
                s1.add(i);
                list.add(s1);
                map.put(groupSizes[i],list);
            }else{
                List<List<Integer>> list = map.get(groupSizes[i]);
                boolean add = false;
                for(List s1 : list){
                    if(s1.size() < groupSizes[i]){
                        s1.add(i);
                        map.put(groupSizes[i],list);
                        add = true;
                        break;
                    }
                }
                if(!add){
                    List s1 = new ArrayList();
                    s1.add(i);
                    list.add(s1);
                    map.put(groupSizes[i],list);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i : map.keySet()){
            List<List<Integer>> list = map.get(i);
            for(List s1 : list){
                res.add(s1);
            }
        }
        return res;
    }

    public List<List<Integer>> groupThePeopleArray(int[] groupSizes){
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        //n+1的哈希表
        ArrayList[] hash = new ArrayList[n + 1];
        for (int i = 0; i < groupSizes.length; i++) {
            //哈希表的key
            int key = groupSizes[i];
            if (hash[key] == null) {
                hash[key] = new ArrayList();
            }
            //添加人
            hash[key].add(i);
            //组内人数和key相同 划分为一个组
            if (hash[key].size() == key) {
                ans.add(new ArrayList<>(hash[key]));
                hash[key].clear();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] groupSize = {3,3,3,3,3,1,3};
        List<List<Integer>> list =  new UserGroup().groupThePeopleArray(groupSize);
        for(List<Integer> s1 : list){
//            System.out.println(s1.size());
            System.out.println("=============");
            for(int s : s1){
                System.out.println(s);
            }
        }
    }

}
