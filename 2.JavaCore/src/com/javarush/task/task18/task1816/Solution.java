package com.javarush.task.task18.task1816;

/* 
Английские буквы

В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int count = 0;
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        for (int i = 0; i < data.length ; i++) {
            if ( data[i] > 64 && inputStream.read() < 91 || data[i] > 96 && inputStream.read() < 123) count++;
        }

        inputStream.close();
        System.out.println(count);
    }
}

