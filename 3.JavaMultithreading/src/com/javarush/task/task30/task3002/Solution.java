package com.javarush.task.task30.task3002;

/*
Осваиваем методы класса Integer

Используя метод Integer.parseInt(String, int) реализуй логику метода convertToDecimalSystem, который должен переводить переданную строку в десятичное число и возвращать его в виде строки.

Требования:
1. В классе Solution должен существовать метод convertToDecimalSystem(String), возвращающий String.
2. Метод convertToDecimalSystem(String) должен иметь модификаторы доступа: public, static.
3. Метод convertToDecimalSystem(String) должен вызывать метод Integer.parseInt(String, int).
4. Метод convertToDecimalSystem(String) должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.startsWith("0b")) return String.valueOf(Integer.parseInt(s.substring(2),2));
        else if (s.startsWith("0x")) return String.valueOf(Integer.parseInt(s.substring(2),16));
        else if (s.startsWith("0")) return String.valueOf(Integer.parseInt(s,8));
        else return s;
    }
}