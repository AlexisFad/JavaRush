package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл

Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer,String> list = new TreeMap<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (!(str = r.readLine()).equals("end")){
            for (String s: str.split("\\.")) {
                if (s.startsWith("part")){
                  String s1 = s.replaceAll("\\D+","");
                    list.put(Integer.parseInt(s1),str);
                }
            }
        }
        r.close();
        String xr = list.get(list.firstKey()).substring(0,list.get(list.firstKey()).lastIndexOf("."));
        FileOutputStream fileOutputStream = new FileOutputStream(xr,true);

        Iterator<Map.Entry<Integer,String>> iterator = list.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> pair = iterator.next();
            FileInputStream inputStream = new FileInputStream(pair.getValue());
            BufferedReader x = new BufferedReader(new InputStreamReader(inputStream));
            String xy = x.readLine();
            while (xy != null){
                fileOutputStream.write(xy.getBytes());
                xy = x.readLine();
            }
            inputStream.close();
            x.close();
            fileOutputStream.close();
        }
    }
}
