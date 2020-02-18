package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Составить цепочку слов

В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(fileName.readLine()));
        fileName.close();

        String s = reader.readLine();
        StringBuilder stringWords = new StringBuilder();

        while (s != null) {
            stringWords.append(s);
            s = reader.readLine();
        }

        reader.close();

        String[] words = stringWords.toString().split(" ");
        StringBuilder result = getLine(words);

        System.out.println(result.toString());

    }

    public static StringBuilder getLine(String... words) {

        HashMap<String, Integer> out = new HashMap<>();
        HashMap<String, Integer> in = new HashMap<>();
        ArrayList<String> words1 = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        if (words.length == 0) return new StringBuilder();
        for (String s : words) {
            words1.add(s);

                if (in.containsKey(s.substring(0, 1).toLowerCase()))
                    in.put(s.substring(0, 1).toLowerCase(), in.get(s.substring(0, 1).toLowerCase()) + 1);
                else {
                    in.put(s.substring(0, 1).toLowerCase(), 1);
                }

                if (out.containsKey(s.substring(s.length() - 1).toLowerCase()))
                    out.put(s.substring(s.length() - 1).toLowerCase(), out.get(s.substring(s.length() - 1).toLowerCase()) + 1);
                else {
                    out.put(s.substring(s.length() - 1).toLowerCase(), 1);
                }
            }

        HashMap<String, Integer> all = new HashMap<>(out);
        for (Map.Entry<String, Integer> pair : in.entrySet()) {
            if (all.containsKey(pair.getKey())) all.put(pair.getKey(), pair.getValue() + all.get(pair.getKey()));
            else all.put(pair.getKey(), 1);
        }

        ArrayList<String> startFinishPoint = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : all.entrySet()) {
            if (pair.getValue() % 2 != 0) startFinishPoint.add(pair.getKey());
        }

        if (startFinishPoint.size() > 2) {
            System.out.println("Не эйлеров граф");
            return null;
        } else if (startFinishPoint.size() == 2) {


            int x1 = in.get(startFinishPoint.get(0)) == null ? 0 : in.get(startFinishPoint.get(0));
            int x2 = in.get(startFinishPoint.get(1)) == null ? 0 : in.get(startFinishPoint.get(1));

            int x1_2 = out.get(startFinishPoint.get(0)) == null ? 0 : out.get(startFinishPoint.get(0));
            int x2_2 = out.get(startFinishPoint.get(1)) == null ? 0 : out.get(startFinishPoint.get(1));


            String startPoint = x1 - x1_2 > x2 - x2_2 ? startFinishPoint.get(0) : startFinishPoint.get(1);

            doubless(words1);

            for (int i = 0; i < words1.size(); i++) {
                if (words1.get(i).substring(0, 1).toLowerCase().equals(startPoint)) {
                    result.add(words1.get(i));
                    words1.remove(i);
                    break;
                }
            }

        } else if (startFinishPoint.size() == 0) {
            result.add(words1.get(0));
            words1.remove(0);
        }

        if (startFinishPoint.size() == 0) {
             startFinishPoint.add(words1.get(0));
            return findWay(doubless(words1), result);
        } else if (startFinishPoint.size() <= 2) return findWay(words1, result);



   return new StringBuilder();
    }


    public static StringBuilder findWay(ArrayList<String> graph, ArrayList<String> result) {

            for (int i = 0; i < graph.size(); i++) {
                if (graph.get(i).substring(0, 1).equalsIgnoreCase(result.get(result.size()
                        - 1).substring(result.get(result.size() - 1).length() - 1))) {

                    result.add(graph.get(i));
                    graph.remove(i);
                    i = -1;
                }
            }

            while (graph.size()>0) {
                for (int i = result.size() - 1; i >= 0; i--) {

                    for (int j = 0; j < graph.size(); j++) {
                        if (result.get(i).substring(result.get(i).length()
                                - 1).equalsIgnoreCase(graph.get(j).substring(0, 1))) {

                            result.add(i+1,graph.get(j));
                            graph.remove(graph.get(j));
                            i = result.size()-1;
                        }
                    }
                }
            }

        StringBuilder sb = new StringBuilder();
        for (String s : result) sb.append(s).append(" ");

        return sb.deleteCharAt(sb.length()-1);

    }

    public static ArrayList<String> doubless (ArrayList<String> words){

        for (int i = 0; i < words.size(); i++) {
            String temp = " ";
            if (words.get(i).substring(0, 1).equalsIgnoreCase(words.get(i).substring(words.get(i).length()
                    - 1).toLowerCase())) {

                temp = words.get(i);
            }
            for (int j = 0; j < words.size(); j++) {
                if (words.get(j).substring(0, 1).equalsIgnoreCase(temp.substring(0, 1)) &&
                        !(words.get(j).substring(0, 1).equalsIgnoreCase(words.get(j).substring(words.get(j).length() - 1)))) {

                    words.set(j, temp + " " + words.get(j));
                    words.remove(i);
                    i = 0;
                    break;
                }
            }
        }
        return words;
    }
}