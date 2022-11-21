package org.example.HuaweiACM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 14:26
 **/
public class FileName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<MyPair,Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            int n = Integer.parseInt(str[1]);
            String[] temps = str[0].split("\\\\");
            String FileName = temps[temps.length - 1];
            if (FileName.length() > 16) {
                FileName = FileName.substring(FileName.length() - 16, FileName.length());
            }
            MyPair pair = new MyPair(FileName, n);
            if (!map.containsKey(pair)) {
                map.put(pair,1);
            }else{
                map.put(pair,map.get(pair) + 1);
            }
        }

        for(MyPair pair : map.keySet()){
            System.out.println(pair.FileName + " " + pair.line +  " " + map.get(pair) + "\n");
        }


    }
}

class MyPair {
    String FileName;
    int line;

    public MyPair(String FileName, int line) {
        this.FileName = FileName;
        this.line = line;
    }
}

