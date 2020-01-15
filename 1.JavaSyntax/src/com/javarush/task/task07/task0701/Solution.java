package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум

1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива


Требования:
1. Метод initializeArray должен создавать массив из 20 целых чисел.
2. Метод initializeArray должен считать 20 чисел и вернуть их в виде массива.
3. Метод max должен возвращать максимальный элемент из переданного массива.
4. Метод main изменять нельзя.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[20];
        for (int i = 0; i < n.length ; i++) {
            n[i] = Integer.parseInt(r.readLine());
        }
        return n;
    }

    public static int max(int[] array) {
        int maximum = array[0];
        for (int i = 1; i < array.length ; i++) {
            if (array[i] > maximum)
                maximum = array[i];
        }
        return maximum;
    }
}
