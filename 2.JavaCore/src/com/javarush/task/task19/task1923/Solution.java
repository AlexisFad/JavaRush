package com.javarush.task.task19.task1923;

/* 
Слова с цифрами

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(reader);

        FileWriter writer = new FileWriter(args[1]);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        while (bufferedReader.ready()){
            String s = bufferedReader.readLine();
            String result ="";
            for (String string: s.split(" ")) {
                if (string.matches(".*\\d+.*")) {
                    result = string + " ";
                    bufferedWriter.write((result));
                }
            }
        }
        reader.close();
        bufferedReader.close();
        bufferedWriter.close();
        writer.close();
    }
}
