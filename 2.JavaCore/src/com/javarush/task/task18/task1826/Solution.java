package com.javarush.task.task18.task1826;

/* 
Шифровка

Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);

        if (args[0].equals("-e")){
            outputStream.write(Encrypter(data));
        }
        else if (args[0].equals("-d")){
            outputStream.write(Decrypter(data));
        }
        inputStream.close();
        outputStream.close();
        System.out.println("Привет");
    }

    public static byte[] Encrypter(byte[] data){
        byte crypt = 1;

        for (int i = 0; i < data.length; i++){
           int q = (data[i] + crypt)% 256;
           data[i] = (byte) q;
        }
        return  data;
    }

    public static byte[] Decrypter(byte[] data) {
        byte decrypt = 1;

        for (int i = 0; i < data.length; i++){
            int q = (data[i] - decrypt);
            if (q < 0) q = 256 - q;
            data[i] = (byte) q;
        }
        return  data;
    }
}
