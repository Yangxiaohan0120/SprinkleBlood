package org.example.AcWing;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-15 11:06
 **/
public class KMPString {

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter printWriter = new PrintWriter(System.out);
//        int n = br.read();
//        String P = br.readLine();
//        int m = br.read();
//        String S = br.readLine();
//        printWriter.write(n);
//        printWriter.write(P);
//        printWriter.flush();
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        String S = sc.next();
        int n = sc.nextInt();
        String P = sc.next();

        for(int i = 0 ; i < n - m ; i ++){
            String t = P.substring(i,i+m);
            if(t.equals(S)){
                System.out.print(i+" ");
            }
        }
    }
}
