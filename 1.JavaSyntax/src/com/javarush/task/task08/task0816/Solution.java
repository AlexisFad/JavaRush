package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы

Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Путин", dateFormat.parse("OCTOBER 7 1965"));
        map.put("Фадеев", dateFormat.parse("MARCH 30 1988"));
        map.put("Фадеева", dateFormat.parse("AUGUST 30 1988"));
        map.put("ОШОШО", dateFormat.parse("JUNE 30 1988"));
        map.put("Раввав", dateFormat.parse("JULY 30 1988"));
        map.put("уцуцуцу", dateFormat.parse("JUNE 30 1988"));
        map.put("Рлаввав", dateFormat.parse("September 30 1988"));
        map.put("Рлаkввав", dateFormat.parse("October 30 1988"));
        map.put("Цуцу", dateFormat.parse("November 30 1988"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
         while (iterator.hasNext()) {
             Map.Entry<String, Date> pair = iterator.next();
             if(pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() < 8)
                 iterator.remove();
         }
    }

    public static void main(String[] args) {

    }
}
