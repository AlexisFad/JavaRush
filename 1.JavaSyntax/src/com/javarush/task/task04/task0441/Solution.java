package com.javarush.task.task04.task0441;

/* 
Как-то средненько

Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить среднее из трех чисел.
4. Если все числа равны, вывести любое из них.
5. Если два числа из трех равны, вывести любое из двух.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());

        if (a > b && a < c || a > c && a < b)
            System.out.println(a);
        else if (b > a && b < c || b > c && b < a)
            System.out.println(b);
        else if (c > a && c < b || c > b && c < a)
            System.out.println(c);
        else if (a == b && a < c || a == b && a > c || a == b && a == c || a == c && a > b || a == c && a < b)
            System.out.println(a);
        else if (b == c && b < a || b == c && b > a)
            System.out.println(b);

    }
}
