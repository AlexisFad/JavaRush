package com.javarush.task.task19.task1908;

/* 
Выделяем числа

Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader x = new BufferedReader(new FileReader(r.readLine()));
        BufferedWriter y = new BufferedWriter (new FileWriter(r.readLine()));

        String s = x.readLine();
        while (s != null){
             for (String q: s.split(" ")) {
                 if (q.matches("[0-9]*$")) {
                     y.write(q);
                     y.write(" ");
                 }
             }
              s = x.readLine();
        }

      r.close();
      x.close();
      y.close();
    }
}
