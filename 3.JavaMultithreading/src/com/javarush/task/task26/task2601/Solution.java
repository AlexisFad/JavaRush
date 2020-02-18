package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5


Требования:
1. Программа не должна выводить текст в консоль.
2. Программа не должна считывать данные с консоли.
3. Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
4. Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности от его медианы.

*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 13, 8, 15, 5, 17};
        sort(array);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list);
        double median = list.size() % 2 == 0 ? ((list.get(list.size()/2) + list.get(list.size()/2 - 1))) / 2 :
                list.get(list.size()/2);

        list.sort(Comparator.comparingInt(o -> Math.abs((int) median - o)));
        return list.toArray(new Integer[0]);
    }
}