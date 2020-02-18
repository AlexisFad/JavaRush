package com.javarush.task.task29.task2907;

import java.math.BigDecimal;

/* 
Этот странный BigDecimal
Исправь ошибку реализации, приводящую к погрешности вычисления, в методе getValue().
Сигнатуру метода не менять. Округление не использовать.
Читай доп. статью про особенности автобоксинга.


Требования:
1. Метод getValue() должен создавать два объекта типа BigDecimal.
2. Метод getValue() должен вызывать метод add() у созданного объекта BigDecimal.
3. Метод getValue() НЕ должен использовать метод round().
4. Метод getValue() должен возвращать результат без погрешности.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        return new BigDecimal(String.valueOf(v1)).add(new BigDecimal(String.valueOf(v2)));
    }
}