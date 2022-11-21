package org.example.EnterpriseInterview.kuaishou;

/**
 * @author Chris Yang
 * created 2022-08-12 09:51
 **/
public class hammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count += 1;
            n &= n-1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        System.out.println(n);
        System.out.println(new hammingWeight().hammingWeight(-3));
    }
}
