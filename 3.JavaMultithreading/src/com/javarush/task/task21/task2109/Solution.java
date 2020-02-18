package com.javarush.task.task21.task2109;

/* 
Запретить клонирование

Разреши клонировать класс А
Запрети клонировать класс B
Разреши клонировать класс C
Не забудь о методах equals и hashCode!


Требования:
1. Класс A должен поддерживать интерфейс Cloneable.
2. Класс B должен быть потомком класса A.
3. При объявлении класса B не должно быть явно указано implements Cloneable.
4. Метод clone в классе B должен быть переопределен таким образом, чтобы при попытке клонирования объекта класса B возникало исключение CloneNotSupportedException.
5. Класс C должен быть потомком класса B.
6. Клонирование объектов класса C должно завершаться успешно.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        @Override
        public boolean equals(Object obj) {
          B b = (B) obj;
          if (name.equals(((B) obj).name)) return super.equals(obj);
          return false;


        }

        private String name;

        @Override
        public B clone() throws CloneNotSupportedException {
            if (!(super.clone() instanceof C)) throw new CloneNotSupportedException();
            return (B) super.clone();
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }

    @Override
    public C clone() throws CloneNotSupportedException {
        return (C) super.clone();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        if (!(obj instanceof C)) return false;

        return super.equals(obj);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        C c = new C(1,1,"ds");
        C d = (C) c.clone();

        B b = new B(1,1,"dsdsd");
        B a = b.clone();
    }
}
