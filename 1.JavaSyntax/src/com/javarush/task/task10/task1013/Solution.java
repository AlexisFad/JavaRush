package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human

Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private short sex;
        private String name;
        private String eyeColor;
        private int height;
        private int weight;

        public Human(int age){
            this.age = age;
        }
        public Human(int age, short sex){
            this.age = age;
            this.sex = sex;
        }
        public Human(int age, short sex, String name){
            this.age = age;
            this.sex = sex;
            this.name = name;
        }
        public Human(int age, short sex, String name, String eyeColor)
        {
            this.age = age;
            this.sex = sex;
            this.name = name;
            this.eyeColor = eyeColor;
        }
        public Human(int age, short sex, String name, String eyeColor, int height){
            this.age = age;
            this.sex = sex;
            this.name = name;
            this.eyeColor = eyeColor;
            this.height = height;
        }
        public Human(int age, short sex, String name, String eyeColor, int height, int weight){
            this.age = age;
            this.sex = sex;
            this.name = name;
            this.eyeColor = eyeColor;
            this.height = height;
            this.weight = weight;

        }
        public Human (short sex){
            this.sex = sex;
        }
        public Human (String name){
            this.name = name;
        }

        public Human (String name, String eyeColor){
            this.name = name;
            this.eyeColor = eyeColor;
        }
        public Human (int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }
}
