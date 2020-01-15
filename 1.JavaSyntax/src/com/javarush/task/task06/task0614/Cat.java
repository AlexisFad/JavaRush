package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты

1. В классе Cat добавь публичную статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.


Требования:
1. Добавь в класс Cat публичную статическую переменную cats (ArrayList<Cat>).
2. Переменная cats должна быть проинициализирована.
3. Метод main должен создавать 10 объектов Cat (используй конструктор Cat()).
4. Метод main должен добавить всех созданных котов в переменную cats.
5. Метод printCats должен выводить всех котов из переменной cats на экран. Каждого с новой строки.
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>(10);

    public Cat() {
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        Cat cat10 = new Cat();
        Cat.cats.add(cat1);
        Cat.cats.add(cat2);
        Cat.cats.add(cat3);
        Cat.cats.add(cat4);
        Cat.cats.add(cat5);
        Cat.cats.add(cat6);
        Cat.cats.add(cat7);
        Cat.cats.add(cat8);
        Cat.cats.add(cat9);
        Cat.cats.add(cat10);

        printCats();
    }

    public static void printCats() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(cats.get(i));
        }


    }
}
