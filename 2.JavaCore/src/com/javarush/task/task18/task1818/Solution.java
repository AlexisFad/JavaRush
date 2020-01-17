package com.javarush.task.task18.task1818;

/* 
Два в одном

Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = r.readLine();
        String nameFile2 = r.readLine();
        String nameFile3 = r.readLine();
        r.close();

        FileInputStream inputStream = new FileInputStream(nameFile2);
        FileInputStream inputStream1 = new FileInputStream(nameFile3);
        FileOutputStream outputStream = new FileOutputStream(nameFile, true);

        if(inputStream.available() > 0){
        byte[] data = new byte[inputStream.available()];
        int count = inputStream.read(data);

        outputStream.write(data,0,count);

        }
        inputStream.close();

        if (inputStream1.available() > 0 ){
            byte[] data1 = new byte[inputStream1.available()];
            inputStream1.read(data1);
            outputStream.write(data1);

        }
        outputStream.close();
        inputStream1.close();
    }
}
