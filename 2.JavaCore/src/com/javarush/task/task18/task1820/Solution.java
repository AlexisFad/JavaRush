package com.javarush.task.task18.task1820;

/* 
Округление чисел

Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameRead = r.readLine();
        String nameWrite = r.readLine();
        r.close();

        FileInputStream inputStream = new FileInputStream(nameRead);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        FileOutputStream outputStream = new FileOutputStream(nameWrite, true);

        while (s != null){
            for (String x: s.split(" "))
                outputStream.write(String.format("%d ",Math.round(Double.parseDouble(x))).getBytes());
            s = bufferedReader.readLine();
        }

        inputStream.close();
        outputStream.close();

    }
}
