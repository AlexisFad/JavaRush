package com.javarush.task.task05.task0524;

/* 
Конструктор

Разберись, что делает программа.
Найди и исправь одну ошибку в классе Circle. Метод main изменять нельзя.

Подсказка:
изучи конструктор по умолчанию.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод main изменять нельзя.
3. Программа должна вывести слово "Red" на экран.
4. Метод getDescription класса Color должен возвращать значение переменной description.
5. Метод setDescription класса Color должен устанавливать значение переменной description.
*/

public class Circle {
    public double x;
    public double y;
    public double r;

    public Circle(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;

    }

    public static void main(String[] args) {

    }
}