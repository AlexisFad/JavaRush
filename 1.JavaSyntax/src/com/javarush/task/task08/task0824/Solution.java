package com.javarush.task.task08.task0824;

import java.util.ArrayList;

/* 
Собираем семейство

1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Human ded1 = new Human("Вася", true, 90);
        Human ded2 = new Human("Дед", true, 90);
        Human babka = new Human("бабка", false, 90);
        Human babka2 = new Human("бабка2", false, 90);
        Human father = new Human("Отец",true , 90);

        Human mother = new Human("Мать",false , 90);
        Human children = new Human("Сын",true , 10);
        Human children2 = new Human("Сын2",true , 10);
        Human children3 = new Human("дочь",false , 10);


        ded1.children.add(father);
        ded2.children.add(mother);
        babka.children.add(father);
        babka2.children.add(mother);


        father.children.add(children);
        father.children.add(children3);
        father.children.add(children2);

        mother.children.add(children2);
        mother.children.add(children);
        mother.children.add(children3);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(babka);
        System.out.println(babka2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children);
        System.out.println(children2);
        System.out.println(children3);

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
