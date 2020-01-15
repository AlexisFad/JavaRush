package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны

Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/

public class Solution {
    public static Map<String, String> createMap() {
       Map<String, String> map = new HashMap<>();
       map.put("Фадеев","Алексей");
       map.put("Амбарцумян", "Амбарцум");
       map.put("Путин", "Владимир");
       map.put("Пулин","Алексей");
       map.put("Фадеева", "Маргарита");
       map.put("Морозова","Маргарита");
       map.put("Морозов","Сергей");
       map.put("Грабовенко", "Сергей");
       map.put("Морохова", "Надежда");
       map.put("Массмао", "Кареера");

       return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> pair: map.entrySet()){
            list.add(pair.getValue());
        }
        for (int i = 0; i < list.size() ; i++) {
            for (int j = list.size() - 1; j > i ; j--) {
                if(list.get(i) == list.get(j))
                    removeItemFromMapByValue(map,list.get(i));
            }
        }
    }


    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
