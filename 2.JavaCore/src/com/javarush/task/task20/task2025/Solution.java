package com.javarush.task.task20.task2025;


import java.math.BigInteger;
import java.util.*;

/*
Алгоритмы-числа

Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.


Требования:
1. В классе Solution должен присутствовать метод getNumbers c одним параметром типа long.
2. Метод getNumbers должен быть публичным.
3. Метод getNumbers должен быть статическим.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.

*/
public class Solution {

    private static TreeSet<Long> set;
    private static long[][] matrixForSum = matrix(19,10);
    private static long[][] matrixForGenerate = matrix(18,11);

    public static long[] getNumbers(long N) {
        long[] result;
        set = new TreeSet<>();

        generateNumber(N);

        Object[] array = set.toArray();
        result = new long[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = (long) array[i];
        }

        return result;

    }

    public static long[][] matrix(int n,int x){
        long[][] matrix = new long[x][n+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                BigInteger bi = BigInteger.valueOf(i);
               matrix[i][j] = Long.parseLong(String.valueOf(bi.pow(j)));
            }
        }

        return matrix;
    }

    public static void checkNumbers(long number, long maxNumber) {
        long number1 =  sumDegrees(number);

        if (number1 > 0) {
            long number2 = sumDegrees(number1);
            if (number1 == number2 && number1 < maxNumber) set.add(number1);
        }
    }

    public static long sumDegrees (long number){
        long result = 0;
        int numberLength = (number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));

        while (number != 0) {
            long y;
            y = number % 10;
            number = number / 10;
            result += matrixForSum[(int) y][numberLength];
        }
        return result;
    }

    public static void generateNumber(long number) {

        long generatedNumber = 1;
        long tempNumber;
        int count = 0;

        while (generatedNumber <= number) {

            if (generatedNumber % 10 == 0) {
              checkNumbers(generatedNumber, number);
                tempNumber = generatedNumber;

                while (tempNumber % 10 == 0) {
                    tempNumber = tempNumber / 10;
                    count++;
                }
                generatedNumber += (tempNumber % 10) * matrixForGenerate[10][count-1];

                count = 0;
                if (generatedNumber < 0) break;
                continue;
            }

           checkNumbers(generatedNumber, number);
            generatedNumber++;
        }
    }

    public static void main(String[] args) {
        long [] result = getNumbers(Long.MAX_VALUE);
        System.out.println(Arrays.toString(result));

    }
}