package org.example.EnterpriseInterview.huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-13 16:36
 **/
public class string {
    public  static void  main(String [] args) throws Exception{
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        if(!s.contains(" ")){
            System.out.println(s.length());
        }else{
            String[] temps = s.split(" ");
            int n = temps[temps.length -1].length();
            System.out.println(n);
        }
       int n = in.nextInt();


    }
}
