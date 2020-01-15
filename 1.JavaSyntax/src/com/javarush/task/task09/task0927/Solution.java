package com.javarush.task.task09.task0927;


import java.util.*;

/* 
Десять котов
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод createMap должен создавать новый объект HashMap<String, Cat>.
3. Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
4. Метод createMap должен возвращать созданный словарь.
5. Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
6. Программа должна вывести всех котов из множества на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> map = new HashMap<>();
        map.put("Барсик", new Cat("Барсик"));
        map.put("Барсик2", new Cat("Барсик2"));
        map.put("Барсик3", new Cat("Барсик3"));
        map.put("Барсик4", new Cat("Барсик4"));
        map.put("Барсик5", new Cat("Барсик5"));
        map.put("Барсик6", new Cat("Барсик6"));
        map.put("Барсик7", new Cat("Барсик7"));
        map.put("Барсик8", new Cat("Барсик8"));
        map.put("Барсик9", new Cat("Барсик9"));
        map.put("Барсик10", new Cat("Барсик10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> cat = new HashSet<>();

        for (Map.Entry<String, Cat> i : map.entrySet()){
            cat.add(i.getValue());
        }

       return cat;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }
}
