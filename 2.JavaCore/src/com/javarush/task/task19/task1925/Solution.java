package com.javarush.task.task19.task1925;

/* 
Длинные слова

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(reader);

        FileWriter writer = new FileWriter(args[1]);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String result = "";

        while (bufferedReader.ready()){
            String string = bufferedReader.readLine();

            for (String s: string.split(" ")) {
                int count = 0;
                for (String s1: s.split("")) {
                    count++;
                }
                if (count > 6){
                    result += s + ",";
                }
            }
        }
        bufferedWriter.write(result.substring(0,result.length()-1));

        bufferedReader.close();
        reader.close();
        bufferedWriter.close();
        writer.close();
    }
}
