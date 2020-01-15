package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные

Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить две строки.
3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
5. Каждая строка должна заканчиваться пробелом.
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
    static String p = " ";

    public static void main(String[] args) throws Exception {
        BufferedReader r  = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        String s1 = " ";
        char[]a1 = s1.toCharArray();
        char[]a =  s.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (isVowel(a[i]) == true){
                System.out.print(a[i]);
                if(i != a.length-1){
                    System.out.print(" ");
                }
            }
        }
        System.out.print(" ");
        System.out.println("");
        for (int i = 0; i < a.length; i++) {
            if (isVowel(a[i]) == false && a[i] != ' '){
                System.out.print(a[i]);
                if(i != a.length-1){
                    System.out.print(" ");
                }

            }
        }
        System.out.print(" ");
    }
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}