package com.javarush.task.task03.task0314;

/* 
Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 4 ...
2 4 6 8 ...
3 6 9 12 ...
4 8 12 16 ...
...


Требования:
1. Программа должна выводить текст.
2. Выведенный текст должен содержать 10 строк.
3. Каждая выведенная строка должна содержать 10 чисел, разделенных пробелом.
4. Выведенные числа должны быть таблицей умножения.
*/

public class Solution {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        while (a < 10) {
            a++;
            while (b < 10){
                b++;
                System.out.print(b * a + " ");
            }

            b = 0;
            System.out.println(" ");
        }
    }
}

