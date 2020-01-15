package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.

Пример вывода на экран:
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS


Требования:
1. Программа не должна считывать текст c клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна выводить квадрат из 10х10 букв S.
4. В программе должен использоваться цикл while.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args)  throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(r.readLine());

        int a = s;
        int b = s;
        while (s > 0){
            s--;

            while (a > 0) {
                a--;
                System.out.print("S");
            }

            System.out.println();
            a = b;
        }
    }
}

