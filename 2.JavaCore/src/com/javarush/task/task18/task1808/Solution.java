package com.javarush.task.task18.task1808;

/* 
Разделение файла

Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        String file3 = r.readLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);

       if (inputStream.available() % 2 == 0){

           byte[] buffer = new byte[inputStream.available()/2];
           byte[] buffer2 = new byte[inputStream.available()/2];

           int count = inputStream.read(buffer);
           int count2 = inputStream.read(buffer2);
           outputStream.write(buffer,0,count);
           outputStream2.write(buffer2,inputStream.available()/2,count2);

           outputStream.close();
           inputStream.close();
           outputStream2.close();

       }
       else {

           byte[] buffer = new byte[(inputStream.available()+1)/2];
           byte[] buffer2 = new byte[(inputStream.available()-1)/2];


           int count = inputStream.read(buffer);
           int count2 = inputStream.read(buffer2);
           outputStream.write(buffer,0,count);
           outputStream2.write(buffer2,(inputStream.available() - 1)/2,count2);

           outputStream.close();
           inputStream.close();
           outputStream2.close();
       }
    }
}




