package com.javarush.task.task27.task2702;

/* 
Нужный оператор
Вставьте в код единственную строчку - оператор (не break), чтобы на экран выводился треугольник из букв S.


Требования:
1. Программа должна выводить на экран треугольник из букв S.
2. В программе должен быть использован оператор continue.
3. В программе не должен быть использован оператор break.
4. Программа не должна считывать данные с клавиатуры.
*/

public class Solution {
    public static void main(String args[]) {
        label:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue label;
                }
                System.out.print("S");
            }
        }
    }
}
