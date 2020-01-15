package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.

Пример ввода:
3
2
15
6
17

Пример вывода:
2
3
6
15
17


Требования:
1. Программа должна считывать 5 чисел с клавиатуры.
2. Программа должна выводить 5 чисел, каждое с новой строки.
3. Выведенные числа должны быть отсортированы по возрастанию.
4. Вывод должен содержать те же числа, что и были введены (порядок не важен).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int mina = Integer.parseInt(reader.readLine());
        int minb = Integer.parseInt(reader.readLine());
        int minc = Integer.parseInt(reader.readLine());
        int mind = Integer.parseInt(reader.readLine());
        int mine = Integer.parseInt(reader.readLine());

        int a = mina;
        int b = minb;
        int c = minc;
        int d = mind;
        int e = mine;

        int a1 = mina;
        int b1 = minb;
        int c1 = minc;
        int d1 = mind;
        int e1 = mine;


        for (int i = 0; i < 5 ; i++) {
            if (a <= b && a <= c && a <= d & a <= e){
                a = Integer.MAX_VALUE;

                if (i == 0)
                    mina = a1;
                if (i == 2)
                    mina = c1;
                if (i == 3)
                    mina = d1;
                if (i == 4)
                    mina = e1;
                if (i == 1)
                    mina = b1;
            }

            else if (b <= a && b <= c && b <= d && b <= e){
                a = Integer.MAX_VALUE;

                if (i == 0)
                    minb = a1;
                if (i == 2)
                    minb = c1;
                if (i == 3)
                    minb = d1;
                if (i == 4)
                    minb = e1;
                if (i == 1)
                    minb = b1;


            }
            else if (c <= a && c <= b && c <= d && c <= e){
                a = Integer.MAX_VALUE;

                if (i == 0)
                    minc = a1;
                if (i == 2)
                    minc = c1;
                if (i == 3)
                    minc = d1;
                if (i == 4)
                    minc = e1;
                if (i == 1)
                    minc = b1;
            }
            else if (d <= a && d <= b && d <= c && d <= e){
                a = Integer.MAX_VALUE;

                if (i == 0)
                    mind = a1;
                if (i == 2)
                    mind = c1;
                if (i == 3)
                    mind = d1;
                if (i == 4)
                    mind = e1;
                if (i == 1)
                    mind = b1;
            }

            else if (e <= a && e <= b && e <= c && e <= d){
                a = Integer.MAX_VALUE;

                if (i == 0)
                    mine = a1;
                if (i == 2)
                    mine = c1;
                if (i == 3)
                    mine = d1;
                if (i == 4)
                    mine = e1;
                if (i == 1)
                    mine = b1;
            }

        }
        System.out.println(mina);
        System.out.println(minb);
        System.out.println(minc);
        System.out.println(mind);
        System.out.println(mine);

    }
}
