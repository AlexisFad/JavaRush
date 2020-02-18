package com.javarush.task.task29.task2913;

import java.util.Random;

/*
Замена рекурсии

В программе случайным образом генерируются два целых числа A и В в диапазоне от 0 (включая) до 1000 (не включая). Нужно вывести все целые числа от A до B включительно, в порядке возрастания, если A меньше B, или в порядке убывания в противном случае.

Задача реализована с использованием рекурсии.
Иногда в результате работы программы получаем Exception in thread "main" java.lang.StackOverflowError.

Твоя задача: перепиши код без использования рекурсии.
Метод recursion() переименуй на getAllNumbersBetween().


Требования:
1. Метод recursion() необходимо переименовать на getAllNumbersBetween().
2. Ни в одном методе класса Solution не должно быть рекурсивных вызовов.
3. В конце строчки вывода последовательности чисел не должно быть пробела.
4. Логика работы программы должна остаться прежней.
5. Метод main() не изменять.
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();

        if (a > b) {
            while (a >= b) {
                stringBuilder.append(a).append(" ");
                a--;
            }
            return stringBuilder.toString().trim();
        }
        if (a < b) {
            while (a <= b) {
                stringBuilder.append(a).append(" ");
                a++;
            }
            return stringBuilder.toString().trim();
        } else
            return String.valueOf(a);
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}