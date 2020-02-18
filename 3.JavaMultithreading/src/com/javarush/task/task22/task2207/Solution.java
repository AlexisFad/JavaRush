package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова

В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder.
3. В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString. Удалять или изменять эти методы нельзя.
4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
5. Список result должен быть заполнен корректными парами согласно условию задачи.
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        r.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        ArrayList<String> list = new ArrayList<>();
        String string = reader.readLine();

        while (string != null){

            list.addAll(Arrays.asList(string.split(" ")));
            string = reader.readLine();

        }
        reader.close();


        for (int i = 0; i < list.size() ; i++) {
            for (int j = 0; j < list.size() ; j++) {

                    StringBuilder sb = new StringBuilder();
                    sb.append(list.get(j)).reverse();

                    if(list.get(i).equals(sb.toString()) && !list.get(i).isEmpty() && j != i){
                        result.add(new Pair(list.get(i),list.get(j)));
                            list.remove(list.get(i));
                            list.remove(sb.toString());
                            i = 0;
                            j = 0;
                    }
            }
        }

        for (Pair p : result) {
            System.out.println(p.toString());
        }

    }

    public static class Pair {
        String first;
        String second;

        Pair(){
        }
        Pair(String first,String second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}