package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты

Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = r.readLine();
        r.close();

        int[] array = new int[256]; //индексы элементов массива и есть наши байты от 0 до 255 = всего 256

        FileInputStream inputStream = new FileInputStream(nameFile);
        while (inputStream.available() > 0){
            list.add(inputStream.read());
        }
        inputStream.close();

        for (Integer i: list) {
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }
            else map.put(i,1);
        }

        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> pair = iterator.next();
            if (pair.getValue() == Collections.min(map.values())) System.out.print(pair.getKey()+" ");

        }
    }
}
