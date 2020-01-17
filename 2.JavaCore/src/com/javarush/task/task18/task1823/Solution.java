package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты

Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while(!(str = reader.readLine()).equals("exit")){
           ReadThread x =  new ReadThread(str);
           x.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            synchronized (Solution.class){
                try {
                    ArrayList<Integer> list = new ArrayList<>();
                    HashMap<Integer, Integer> map = new HashMap<>();

                    FileInputStream inputStream = new FileInputStream(fileName);

                    while (inputStream.available() > 0){
                        list.add(inputStream.read());
                    }
                    inputStream.close();

                    for (Integer i: list) {
                        if (map.containsKey(i)){
                            map.put(i, map.get(i) + 1);
                        }
                        else map.put(i,1);
                    }

                    Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<Integer,Integer> pair = iterator.next();
                        if (pair.getValue() == Collections.max(map.values())){
                            resultMap.put(fileName,pair.getKey());
                        }
                    }

                    } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




