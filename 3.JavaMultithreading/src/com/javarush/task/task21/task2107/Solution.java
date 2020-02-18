package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты

Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.


Требования:
1. Класс Solution должен поддерживать интерфейс Cloneable.
2. Класс User должен поддерживать интерфейс Cloneable.
3. В классе User должен быть корректно реализован метод clone.
4. В классе Solution должен быть корректно реализован метод clone.
*/
public class Solution implements Cloneable {
    @Override
    public Solution clone() throws CloneNotSupportedException {
        Solution clone = (Solution) super.clone();
        clone.users = (Map<String, User>) ((LinkedHashMap<String, User>)users).clone();
        for (Map.Entry<String, User> entry : clone.users.entrySet()) {
            clone.users.replace(entry.getKey(), (User) entry.getValue().clone());}

        return clone;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);


        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            if (!(obj instanceof User)) return false;
            User n = (User) obj;
            if (name != null ? !name.equals(n.name) : n.name != null) return false;
            if (age != n.age) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return 37 * (age + name.hashCode());
        }

        @Override
        public User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }
    }
}
