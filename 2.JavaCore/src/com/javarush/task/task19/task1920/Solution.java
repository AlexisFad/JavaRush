package com.javarush.task.task19.task1920;

/* 
Самый богатый

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader(args[0]);
        BufferedReader x = new BufferedReader(reader);
        String s = x.readLine();
        TreeMap<String, Double> list = new TreeMap<>();

        while (s != null) {
            String[] q = s.split(" ");
            if (list.containsKey(q[0])) list.put(q[0], list.get(q[0]) + Double.parseDouble(q[1]));
            else list.put(q[0], Double.parseDouble(q[1]));

            s = x.readLine();
        }
          Double[] val = list.values().toArray(new Double[0]);
          Arrays.sort(val, Collections.reverseOrder());

            for (Map.Entry<String,Double>entry:list.entrySet()) {
                 if (entry.getValue().equals(val[0])){
                     System.out.println(entry.getKey());
                 }

                 x.close();
                 reader.close();
            }
    }
}
