package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт

Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = r.readLine();
        r.close();

        FileInputStream inputStream = new FileInputStream(nameFile);
        while (inputStream.available() > 0){
            list.add(inputStream.read());
        }
        inputStream.close();

        list = new ArrayList<>(new LinkedHashSet<>(list));
        Collections.sort(list);
        for (Integer i: list) {
            System.out.print(i +" ");
        }
    }
}

