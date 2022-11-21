package org.example.EnterpriseInterview.Honor;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-10-11 17:59
 **/
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            String[] temps = temp.split(" ");
            int a = Integer.valueOf(temps[1]);
            int b = Integer.valueOf(temps[2]);
            int c = Integer.valueOf(temps[3]);
            if(a >= 60 && b >= 60 && c >= 60) {
                list.add(new Student(temps[0], Integer.valueOf(temps[1]), Integer.valueOf(temps[2]), Integer.valueOf(temps[3])));
            }
        }
        Student[] students = list.toArray(new Student[list.size()]);
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.sum > o2.sum){
                    return -1;
                }else if(o1.sum == o2.sum){
                    if(o1.a != o2.a){
                        return o2.a - o1.a;
                    }else if(o1.b != o2.b){
                        return o2.b - o1.b;
                    }else if(o1.c != o2.c){
                        return o2.c - o1.c;
                    }else {
                        int n = Math.min(o1.name.length(), o2.name.length());
                        for (int i = 0; i < n; i++) {
                            if (o1.name.charAt(i) == o2.name.charAt(i)) continue;
                            else return o1.name.charAt(i) - o2.name.charAt(i);
                        }
                    }
                }else{
                    return 1;
                }
                return 0;
            }
        });

        System.out.println("[First round name list]");
        for (Student s : students) {
            System.out.println(s.name + " " + s.a + " " + s.b + " "+ s.c);
        }

        HashSet<Integer> set = new HashSet<>();
        System.out.println();
        System.out.println("[Final name list]");
        for (Student s : students) {
            if(set.contains(s.sum)){
                System.out.println(s.name + " " + s.a + " " + s.b + " "+ s.c);
            }else if(!set.contains(s.sum) && set.size() < 3){
                set.add(s.sum);
                System.out.println(s.name + " " + s.a + " " + s.b + " "+ s.c);
            }else{
                break;
            }
        }
    }
}

class Student {
    String name;
    int a;
    int b;
    int c;
    int sum;

    public Student(String name, int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.sum = a + b + c;
    }
}
