package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт

Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int max = 0;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = r.readLine();


        FileInputStream inputStream = new FileInputStream(name);
        while (inputStream.available() > 0){
            int x = inputStream.read();
            if(x > max) max = x;
        }
        inputStream.close();
        System.out.println(max);
    }
}
