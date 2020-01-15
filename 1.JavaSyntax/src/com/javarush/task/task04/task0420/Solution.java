package com.javarush.task.task04.task0420;

/*

Сортировка трех чисел

Ввести с клавиатуры три числа, и вывести их в порядке убывания.
Выведенные числа должны быть разделены пробелом.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Программа должна выводить три числа разделенных пробелами.
4. Программа должна выводить числа в порядке убывания.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());

        if (a >= b & a >= c){
            System.out.print(a + " ");
            if (b >= c)
                System.out.println(b + " " + c);
            else
                System.out.println(c + " " + b);
        }
        else if (b >= a & b >= c){
            System.out.print(b + " ");
            if (a >= c)
                System.out.println(a + " " + c);
            else
                System.out.println(c + " " + a);
        }

        else if (c >= a & c >= b){
            System.out.print(c + " ");
            if (a >= b)
                System.out.println(a + " " + b);
            else
                System.out.println(b + " " + a);
        }

    }
}
