package com.javarush.task.task16.task1628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
Кто первый встал - того и тапки
1. Разберись, что делает программа.
1.1. Каждая нить должна читать с консоли строки. Используй готовый static BufferedReader reader.
1.2. Используй AtomicInteger readStringCount, чтобы посчитать, сколько строк уже считано с консоли всеми нитями.
2. Реализуй логику метода run:
2.1. Пока нить не прервана (!isInterrupted) читай с консоли строки и добавляй их в поле List<String> result.
2.2. Используй readStringCount для подсчета уже считанных с консоли строк.


Требования:
1. Метод run должен работать пока нить не прервана (!isInterrupted).
2. Метод run НЕ должен создавать свои InputStreamReader-ы или BufferedReader-ы.
3. Метод run должен считывать строки из reader и добавлять их в список result.
4. Метод run должен после каждого считывания увеличивать счетчик прочитанных строк readStringCount на 1.
5. Программа должна выводить данные, считанные каждым потоком.
 */

public class Solution {
    public static volatile AtomicInteger readStringCount = new AtomicInteger(0);
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //read count of strings
        int count = Integer.parseInt(reader.readLine());

        //init threads
        ReaderThread consolReader1 = new ReaderThread();
        ReaderThread consolReader2 = new ReaderThread();
        ReaderThread consolReader3 = new ReaderThread();

        consolReader1.start();
        consolReader2.start();
        consolReader3.start();

        while (count > readStringCount.get()) {
        }

        consolReader1.interrupt();
        consolReader2.interrupt();
        consolReader3.interrupt();

        System.out.println("#1:" + consolReader1);
        System.out.println("#2:" + consolReader2);
        System.out.println("#3:" + consolReader3);
        reader.close();


    }

    public static class ReaderThread extends Thread {
        private List<String> result = new ArrayList<String>();


        public void run() {
            while (!isInterrupted()) {
                try {
                    if(reader.ready()){
                     String line = reader.readLine();
                    result.add(line);
                    readStringCount.incrementAndGet();
                    }

                } catch (IOException e) {

                }

            }
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }
}

