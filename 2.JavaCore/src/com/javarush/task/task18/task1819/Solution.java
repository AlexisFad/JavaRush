package com.javarush.task.task18.task1819;

/* 
Объединение файлов

Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = r.readLine();
        String nameFile2 = r.readLine();
        r.close();

        FileInputStream inputStream = new FileInputStream(nameFile);
        FileInputStream inputStream1 = new FileInputStream(nameFile2);

        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        byte[] data2 = new byte[inputStream1.available()];
        inputStream1.read(data2);
        inputStream1.close();

        FileOutputStream outputStream = new FileOutputStream(nameFile);
        outputStream.write(data2);
        outputStream.write(data);

        outputStream.close();

    }
}
