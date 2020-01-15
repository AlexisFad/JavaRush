package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person

Создать class Person. У человека должно быть имя String name, возраст int age, пол char sex.
Создайте геттеры и сеттеры для всех переменных класса Person.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Person должен быть метод public static void main.
3. Класс Person должен иметь 3 переменные.
4. У класса Person должна быть переменная name с типом String.
5. У класса Person должна быть переменная age с типом int.
6. У класса Person должна быть переменная sex с типом char.
7. У класса Person должен быть сеттер для переменной name.
8. У класса Person должен быть геттер для переменной name.
9. У класса Person должен быть сеттер для переменной age.
10. У класса Person должен быть геттер для переменной age.
11. У класса Person должен быть сеттер для переменной sex.
12. У класса Person должен быть геттер для переменной sex.
*/

public class Person {
    String name;
    int age;
    char sex;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
