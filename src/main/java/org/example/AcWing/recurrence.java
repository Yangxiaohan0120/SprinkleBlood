package org.example.AcWing;

/**
 * @author Chris Yang
 * created 2022-08-26 21:36
 **/
public class recurrence {
    public static int fun1(int n ){
        return n <= 5 ? n : fun1(n-1)* fun1(n-3);
    }

    public static int fun2(int n){
        return fun1(n) % 4;
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 35 ; i ++) {
            System.out.println(fun2(i));
        }
    }
}
