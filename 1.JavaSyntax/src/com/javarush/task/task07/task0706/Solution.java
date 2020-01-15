package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких

1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.


Требования:
1. Программа должна создавать большой массив на 20 целых чисел.
2. Программа должна считывать с клавиатуры 20 чисел для большого массива.
3. Программа должна создавать два маленьких массива на 10 чисел каждый.
4. Программа должна скопировать одну половину большого массива в первый маленький, а вторую - во второй и вывести второй маленький массив на экран.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int odd = 0;
        int even = 0;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[15];

        for (int i = 0; i < n.length; i++) {
            int x = Integer.parseInt(r.readLine());
            n[i] = x;

            if (i % 2 == 0)
                even += n[i];
            else
                odd += n[i];

        }

        String winner = even > odd ? "В домах с четными номерами проживает больше жителей." :
                "В домах с нечетными номерами проживает больше жителей.";
        System.out.println(winner);
    }
}
