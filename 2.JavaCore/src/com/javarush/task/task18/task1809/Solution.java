package com.javarush.task.task18.task1809;

/* 
Реверс файла

Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file = r.readLine();
        String file2 = r.readLine();
        r.close();

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);

        if(inputStream.available() > 0){

        byte[] data = new byte[inputStream.available()];
        int count = inputStream.read(data);

            for (int i = data.length - 1; i >= 0 ; i--) {
                outputStream.write(data[i]);
            }
        }

        outputStream.close();
        inputStream.close();
    }
}
