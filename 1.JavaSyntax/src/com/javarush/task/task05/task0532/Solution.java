package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам

Написать программу, которая:
1. считывает с консоли число N, которое должно быть больше 0
2. потом считывает N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.


Требования:
1. Программа должна считывать числа с клавиатуры.
2. Программа должна выводить число на экран.
3. В классе должен быть метод public static void main.
4. Нельзя добавлять новые методы в класс Solution.
5. Программа должна выводить на экран максимальное из введенных N чисел.
6. Программа не должна ничего выводить на экран, если N меньше либо равно 0.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long maximum = 0;

        long n = Long.parseLong(reader.readLine());
        if (n > 0){

            for (int i = 0; i < n ; i++) {
                if (i == 1){
                    long x = Long.parseLong(reader.readLine());
                    maximum = x;
                }
                else {
                long x = Long.parseLong(reader.readLine());
                if (x < -2147483647)
                    maximum = x;
                else
                    maximum = Math.max(maximum, x);
                }
            }
        }
        System.out.println(maximum);
    }
}
