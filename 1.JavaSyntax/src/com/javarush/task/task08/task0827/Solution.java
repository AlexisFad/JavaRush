package com.javarush.task.task08.task0827;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* 
Работа с датой

1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудьте учесть первый день года.

Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false


Требования:
1. Программа должна выводить текст на экран.
2. Класс Solution должен содержать два метода.
3. Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
4. Метод main() должен вызывать метод isDateOdd().
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) {

        ArrayList<String> list = new ArrayList<>();
        for (String x : date.split(" ")) {
            list.add(x);
        }
        int parsM = 0;

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "JANUARY");
        map.put(1, "FEBRUARY");
        map.put(2, "MARCH");
        map.put(3, "APRIL");
        map.put(4, "MAY");
        map.put(5, "JUNE");
        map.put(6, "JULY");
        map.put(7, "AUGUST");
        map.put(8, "SEPTEMBER");
        map.put(9, "OCTOBER");
        map.put(10, "NOVEMBER");
        map.put(11, "DECEMBER");

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            if (pair.getValue().equals(list.get(0)))
                parsM = pair.getKey();
        }

            Date yearStartTime = new Date();

            yearStartTime.setDate(1);
            yearStartTime.setMonth(0);
            yearStartTime.setYear(Integer.parseInt(list.get(2)));

            Date currentDate = new Date();

            currentDate.setDate(Integer.parseInt(list.get(1)));
            currentDate.setMonth(parsM);
            currentDate.setYear(Integer.parseInt(list.get(2)));

            long timedist = currentDate.getTime() - yearStartTime.getTime();
            long msday = 24 * 60 * 60 * 1000;
            int dayCount = (int) (timedist / msday);

            return  dayCount > 0 && dayCount % 2 == 0 ? true : false;
        }
}