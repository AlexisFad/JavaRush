package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
4. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Фадеев", 1000000);
        map.put("Амиго", 100);
        map.put("аываы", 200);
        map.put("Фавыаываыадеев", 1000000);
        map.put("Фадммымымеев", 10);
        map.put("Фадевыываывев", 200);
        map.put("лдлд", 65);
        map.put("авыаы", 10004000);
        map.put("ннек", 443);
        map.put("ипик", 4567);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            if(pair.getValue() < 500)
                iterator.remove();
        }
            }


    public static void main(String[] args) {

    }
}