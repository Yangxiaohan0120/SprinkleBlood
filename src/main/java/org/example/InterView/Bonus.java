package org.example.InterView;

/**
 * @author Chris Yang
 * created 2022-10-05 20:22
 **/
public class Bonus {
    public static void main(String[] args) {
        double profit = 142990;
        double bonus = new Bonus().setBonus(profit);
        System.out.println(bonus);
    }

    public double setBonus(double p){
        if(p <= 100000){
            return p * 0.05;
        }else if(p < 200000){
            return 5000 + (p - 100000) * 0.04;
        }else if(p < 400000){
            return 9000 + (p - 200000) * 0.05;
        }else if(p < 600000){
            return 19000 + (p - 400000) * 0.03;
        }else if(p < 1000000){
            return 25000 + (p - 600000) * 0.015;
        }else {
            return 31000 + (p - 1000000) * 0.01;
        }
    }
}
