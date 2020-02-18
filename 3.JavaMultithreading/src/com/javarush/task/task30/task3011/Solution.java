package com.javarush.task.task30.task3011;

/* 
Сделай одно изменение кода

Внеси одну правку в код программы, чтобы вывод всегда был "ABC", даже если в метод doSmth
передавать параметрами null.
Не изменяй и не добавляй строковые литералы. Не изменяй строки с выводом данных на экран.
Не добавляй сеттеры.


Требования:
1. Вывод метода doSmth должен быть "ABC", если в него передать объекты типа A, B и C.
2. Вывод метода doSmth должен быть "ABC", если в него передать null, null, null.
3. Запрещено изменять или добавлять строковые литералы, запрещено добавлять сеттеры.
4. Запрещено изменять строки с выводом данных на экран.
5. Необходимо внести одну правку в код программы.
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.doSmth(new A(), null, null);
    }

    public void doSmth(A a, B b, C c) {
        try {
            if (a != null && a.getName() != null) {
                //do nothing
            }
        } catch (NullPointerException e) {
            a = new A();
            a.setName("A");
        }
        try {
            if (a != null && a.getName() == null) {
                a.setName("A");
            }
        } catch (NullPointerException e) {
        }
        if (a == null) {
            a = new A();
            a.setName("A");
        }
        try {
            if (b != null && b.getName() != null) {
                //do nothing
            }
        } catch (NullPointerException e) {
            b = new B();
            b.setName("B");
        }
        try {
            if (b != null && b.getName() == null) {
                b.setName("B");
            }
        } catch (NullPointerException e) {
        }
        if (b == null) {
            b = new B();
            b.setName("B");
        }
        try {
            if (c != null & c.getName() != null) {
            }
        } catch (NullPointerException e) {
            c = new C();
            c.setName("C");
        }
        try {
            if (c != null && c.getName() == null) {
                c.setName("C");
            }
        } catch (NullPointerException e) {
        }
        if (c == null) {
            c = new C();
            c.setName("null");
        }
        System.out.print(a.getName());
        System.out.print(b.getName());
        System.out.print(c.getName());
    }

    static class A {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class B {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class C {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}