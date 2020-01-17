package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения

Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader file1 = new BufferedReader(new FileReader(r.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(r.readLine()));
        r.close();

        ArrayList<String> f1 = new ArrayList<>();
        ArrayList<String> f2 = new ArrayList<>();

        while (file1.ready()) {
            f1.add(file1.readLine());
        }

        while (file2.ready()) {
            f2.add(file2.readLine());
        }

        file1.close();
        file2.close();
        
        for (int i = 0; i < f1.size(); i++) {
            if (i < f2.size()) {
                if (f1.get(i).equals(f2.get(i))) ;
                else if (i < f1.size() +1 && f1.get(i + 1).equals(f2.get(i))) {
                    f2.add(i, "null   ");
                } else {
                    f1.add(i, "null   ");
                }
            }
        }
        if (f1.size() > f2.size()) f2.add("null   ");
        else if (f1.size() < f2.size()) f1.add("null   ");


        for (int i = 0; i < f1.size(); i++) {
            if (i < f2.size()) {
                if (f1.get(i).equals(f2.get(i))) lines.add(new LineItem(Type.SAME, f1.get(i)));
                else if (f1.get(i).equals("null   ")) lines.add(new LineItem(Type.ADDED, f2.get(i)));
                else if (f2.get(i).equals("null   ")) lines.add(new LineItem(Type.REMOVED, f1.get(i)));
            }
        }
        System.out.println(f1);
        System.out.println(f2);
        for (LineItem x: lines) {
            System.out.println(x.type + " "+ x.line);
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}