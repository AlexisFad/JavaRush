package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок

Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.

Пример вывода на экран:
8
88
888
8888
88888
888888
8888888
88888888
888888888
8888888888


Требования:
1. Программа не должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Программа должна выводить прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
4. В программе должен использоваться цикл for.
*/


public class Solution {
    public static void main(String[] args) {

        int m = 10;

        for (int i = m; i > 0; i--){

            for (int x = m + 1; x > i; x--){
                System.out.print("8");
            }

            System.out.println("");
        }
    }
}
