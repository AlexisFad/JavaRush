package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт

Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int min = Integer.MAX_VALUE;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = r.readLine();
        r.close();

       FileInputStream inputStream = new FileInputStream(name);
       while (inputStream.available() > 0){
           int i = inputStream.read();
           if (i < min) min = i;
       }
       inputStream.close();
        System.out.println(min);
    }
}
