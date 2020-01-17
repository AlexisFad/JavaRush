package com.javarush.task.task18.task1807;

/* 
Подсчет запятых

С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = r.readLine();
        r.close();

        FileInputStream inputStream = new FileInputStream(nameFile);
        while (inputStream.available() > 0){
            if (inputStream.read() == 44) count++;
        }
        inputStream.close();
        System.out.println(count);

    }
}
