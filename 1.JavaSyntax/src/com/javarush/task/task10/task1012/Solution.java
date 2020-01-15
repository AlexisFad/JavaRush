package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв

Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 маленьких букв алфавита). Результат вывести на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Требования:
1. Программа должна 10 раз считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и сколько раз буква встречалась в введенных строках.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        char[] array;
        ArrayList<Character> list2 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            array = list.get(i).toCharArray();
            for (char x:array) {
                list2.add(x);
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (Character x: alphabet) {
            map.put(x,0);
        }

        for (Map.Entry<Character,Integer> pair: map.entrySet()) {
            for (char x: list2) {
                if (x == pair.getKey()){
                    pair.setValue(pair.getValue()+1);
                }
            }
        }
        for (char a: alphabet) {
            for (Map.Entry<Character, Integer> pair : map.entrySet()) {
                if (a == pair.getKey()){
                    System.out.println(a + " "+ pair.getValue());
                }
            }
        }
    }
}