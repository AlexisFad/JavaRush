package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина

1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name (String), age (int), address (String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате: name + " " + age + " " + address


Требования:
1. В классе Solution создай public static класс Man.
2. В классе Solution создай public static класс Woman.
3. Класс Man должен содержать переменные: name(String), age(int) и address(String).
4. Класс Woman должен содержать переменные: name(String), age(int) и address(String).
5. У классов Man и Woman должны быть конструкторы, принимающие параметры с типами String, int и String.
6. Конструкторы должны инициализировать переменные класса.
7. В методе main необходимо создать по два объекта каждого типа.
8. Метод main должен выводить созданные объекты на экран в указанном формате.
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Alex",31, "Moscow");
        Man man2 = new Man("Vasya",31,"Suzdal");
        System.out.println(man1);
        System.out.println(man2);

        Woman woman1 = new Woman("Tus", 31, "Moscow");
        Woman woman2 = new Woman("Varvara", 20, "Suzdal");
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man{
        String name, address;
        int age;

     public String toString(){return name + " " + age + " " + address;}

     public Man(String name, int age, String address){
         this.name = name;
         this.age = age;
         this.address = address;
     }

     public Man(){}
     public Man(String name, int age){
         this.name = name;
         this.age = age;
     }
     public Man(String name){
         this.name = name;
     }
        }

    public static class Woman{
        String name, address;
        int age;

        public String toString(){return name + " " + age + " " + address;}

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Woman(){}
        public Woman(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Woman(String name){
            this.name = name;
        }
    }

    }

