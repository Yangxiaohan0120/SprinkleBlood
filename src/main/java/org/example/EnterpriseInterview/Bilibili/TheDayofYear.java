package org.example.EnterpriseInterview.Bilibili;

/**
 * @author Chris Yang
 * created 2022-08-11 14:45
 **/
public class TheDayofYear {
    public int dayOfYear(String date) {
        int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        boolean isRun = (year % 4 == 0 && year % 100 != 0) || year% 400 == 0 ? true : false;
        int month = Integer.parseInt(dates[1]);
        int day = (isRun && month > 2) ? days[month - 1] + Integer.parseInt(dates[2]) + 1 : days[month - 1] + Integer.parseInt(dates[2]);
        return day;
    }

    public static void main(String[] args) {
        System.out.println(new TheDayofYear().dayOfYear("2000-03-01"));
    }
}
