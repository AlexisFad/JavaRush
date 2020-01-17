package com.javarush.task.task18.task1827;

/* 
Прайсы

CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {

            BufferedReader r1 = new BufferedReader(new InputStreamReader(System.in));
            String s1 = r1.readLine();
            if (args.length > 0 && args[0].equals("-c")) {
            FileInputStream fileinputStream = new FileInputStream(s1);
            BufferedReader x = new BufferedReader(new InputStreamReader(fileinputStream, "UTF-8"));
            ArrayList<Integer> listID = new ArrayList<>();


            String priceString = x.readLine();
            while (priceString != null) {
                String idString = priceString.substring(0, 8);
                listID.add(Integer.parseInt(idString.replaceAll("\\D+", "")));
                priceString = x.readLine();
            }
            Collections.sort(listID);
            int id = (listID.get(listID.size() - 1)) + 1;


            String newProduct = String.format("\n%-8.8s%-30.30s%-8.8s%-4.4s", Integer.toString(id), args[1], args[2], args[3]);

            FileOutputStream fileOutputStream = new FileOutputStream(s1, true);
            BufferedWriter z = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            z.write(newProduct);

            z.close();
            fileinputStream.close();
            fileOutputStream.close();
            x.close();

        }
        r1.close();
    }
}
