package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»

Создать множество строк (Set<String>), занести в него 20 слов на букву "Л".


Требования:
1. Не изменяй заголовок метода createSet().
2. Программа не должна выводить текст на экран.
3. Программа не должна считывать значения с клавиатуры.
4. Метод createSet() должен создавать и возвращать множество (реализация HashSet).
5. Множество из метода createSet() должно содержать 20 слов на букву «Л».
*/

public class Solution {
    public static Set<String> createSet() {
        Set<String> set = new HashSet<>();
        set.add("Лвваа");
        set.add("Ллаваа");
        set.add("Ллававававва");
        set.add("Ллвававаа");
        set.add("Ллввваваа");
        set.add("Ллвававававва");
        set.add("Ллвавава");
        set.add("Ллвавва");
        set.add("Ллввава");
        set.add("Ллввавававававаа");
        set.add("Ллвававвваваа");
        set.add("Ллцува");
        set.add("Ллвававава");
        set.add("Ллвваваа");
        set.add("Ллвававававававава");
        set.add("Ллвцуа");
        set.add("Ллвавававав");
        set.add("Ллвуцуцуца");
        set.add("Ллццува");
        set.add("Ллцуцува");

        return set;
    }

    public static void main(String[] args) {

    }
}
