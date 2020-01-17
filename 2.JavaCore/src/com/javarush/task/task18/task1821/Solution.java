package com.javarush.task.task18.task1821;

/* 
Встречаемость символов

Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream  = new FileInputStream(args[0]);
        TreeMap<Byte, Integer> map = new TreeMap<>();

        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();

        for (byte x: data) map.put(x,0);

        Iterator<Map.Entry<Byte,Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Byte,Integer> pair = iterator.next();
            for (byte x: data) {
                if (x == pair.getKey()) pair.setValue(pair.getValue()+1);
            }
        }

        iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Byte,Integer> pair = iterator.next();
            byte a = pair.getKey();
            System.out.println((char) a +" "+ pair.getValue());

        }
    }
}

