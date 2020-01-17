package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты

Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
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
            if (pair.getValue() == Collections.max(map.values())) System.out.print(pair.getKey()+" ");
        }
        int maxVal = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
        System.out.println(maxVal);
        int max = Collections.max(map.values());
        System.out.println(max);

        }
    }

