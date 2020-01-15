package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения

Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();

        map.put("Фадеев", "Алексей");
        map.put("Путинк", "Владимир");
        map.put("Карабас", "Алексей");
        map.put("Путин", "Ильяс");
        map.put("Караывы", "Выв");
        map.put("Йцу", "ОШО");
        map.put("Си", "Ципинь");
        map.put("Дроздов", "Николай");
        map.put("Леонтьев", "Валерий");
        map.put("Фадеева", "Маргарита");

        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int countFirstName = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue().equals(name))
                countFirstName++;

        }
        return countFirstName;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int countLastname = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if(pair.getKey().equals(lastName))
                countLastname++;
        }
        return countLastname;
    }

    public static void main(String[] args) {


    }
}
