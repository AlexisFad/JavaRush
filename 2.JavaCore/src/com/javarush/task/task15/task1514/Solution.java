package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1

В статическом блоке инициализировать labels 5 различными парами ключ-значение.


Требования:
1. В классе Solution должен быть только один метод (main).
2. В классе Solution должно быть объявлено статическое поле labels типа Map.
3. Поле labels должно быть заполнено 5 различными парами ключ-значение в статическом блоке.
4. Метод main должен выводить содержимое labels на экран.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(12.9,"sdsd");
        labels.put(11.,"a");
        labels.put(12.,"b");
        labels.put(13.,"c");
        labels.put(14.,"d");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
