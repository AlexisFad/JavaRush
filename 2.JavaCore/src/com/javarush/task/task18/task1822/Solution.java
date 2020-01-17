package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.


Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(r.readLine());
        r.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str= bufferedReader.readLine();

        while(str != null){
            if(str.startsWith(args[0] + " ")) System.out.println(str);
             str= bufferedReader.readLine();
        }

        inputStream.close();
    }
}
