package com.javarush.task.task18.task1826;

/* 
��������

��������� �������� ��������/����������.

��������� ����������� � ����� �� ��������� ������� ����������:
-e fileName fileOutputName
-d fileName fileOutputName

���:
fileName - ��� �����, ������� ���������� �����������/������������.
fileOutputName - ��� �����, ���� ���������� �������� ��������� ����������/������������.
-e - ���� ���������, ��� ���������� ����������� ������.
-d - ���� ���������, ��� ���������� ������������ ������.


����������:
1. ��������� � ������� ������ �� �����.
2. ������ ����� ��� ������ �� �����, ������� �������� ������ ���������� ([fileName]).
3. ������ ����� ��� ������ � ����, ������� �������� ������� ���������� ([fileOutputName]).
4. � ������ "-e" ��������� ������ ����������� [fileName] � �������� � [fileOutputName].
5. � ������ "-d" ��������� ������ ������������ [fileName] � �������� � [fileOutputName].
6. ��������� ��� ������ ������ ������ ���� �������.
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
        System.out.println("������");
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
