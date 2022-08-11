package org.example.EnterpriseInterview.Ali;

/**
 * @author Chris Yang
 * created 2022-08-11 10:51
 **/
public class plantWatering {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0, r = plants.length - 1;
        int count = 0;
        int capA = capacityA;
        int capB = capacityB;
        while (l < r) {
            if (capA < plants[l]) {
                // 接水浇花
                count += 1;
                capA = capacityA - plants[l];
            } else {
                // 浇花下一个
                capA = capA - plants[l];
            }
            l++;

            if (capB < plants[r]) {
                // 接水浇花
                count += 1;
                capB = capacityB - plants[r];
            } else {
                // 浇花下一个
                capB = capB - plants[r];
            }
            r--;
        }
        // 相遇（可能不相遇直接错开）
        if (l == r) {
            int max = Math.max(capA,capB);
            if(max < plants[l]){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] plants = {2, 2, 3, 3};
        int res = new plantWatering().minimumRefill(plants, 5, 5);
        System.out.println(res);
    }
}
