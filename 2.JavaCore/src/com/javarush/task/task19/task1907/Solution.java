package com.javarush.task.task19.task1907;

/* 
Считаем слово

Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(r.readLine());
        int count = 0;
        String z = "";

        while (reader.ready()){
            int data = reader.read();
            z += (char) data;
        }

       String z2 = z.replaceAll("[^A-zА-яЁё]"," ");
        for (String q: z2.split(" ")){
            if(q.equals("world")) count++;
        }

       System.out.println(count);
       r.close();
       reader.close();
    }
}
