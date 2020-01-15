package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите

Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createSet() должен создавать и возвращать множество Set состоящих из 20 различных чисел.
5. Метод removeAllNumbersGreaterThan10() должен удалять из множества все числа больше 10.
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        set.add(1423423);
        set.add(232410);
        set.add(431);
        set.add(954);
        set.add(1340);
        set.add(745);
        set.add(5456);
        set.add(8544);
        set.add(92320);
        set.add(1231);
        set.add(13230);
        set.add(1033);
        set.add(1);
        set.add(9);
        set.add(1220);
        set.add(7);
        set.add(6);
        set.add(8);
        set.add(90);
        set.add(11);
        return set;

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            if(next > 10)
                iterator.remove();
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
