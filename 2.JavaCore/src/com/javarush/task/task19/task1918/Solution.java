package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String sr = r.readLine();
        r.close();

        FileReader reader = new FileReader(sr.substring(sr.indexOf(" ") + 1));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String openTag = "<" + args[0];
        String closeTag = "</" + args[0];

        String s = "";

        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> close = new ArrayList<>();

        while (bufferedReader.ready()) {
            s += bufferedReader.readLine();
        }

        findindex(open, s, openTag);
        findindex(close, s, closeTag);

        int count = 0;
        while (open.size() > 1 && count < open.size()) {
            if (count == open.size() - 1) {
                System.out.println(s.substring(open.get(0), close.get(count) + 1));
                open.remove(0);
                close.remove(count);
                count = 0;
                continue;
            } else if (open.get(count + 1) > close.get(count)) {
                System.out.println(s.substring(open.get(0), close.get(count) + 1));
                open.remove(0);
                close.remove(count);
                count = 0;
                continue;
            }
            count++;
        }
        System.out.println(s.substring(open.get(0), close.get(0) + 1));

        bufferedReader.close();
        reader.close();
    }

    public static ArrayList<Integer> findindex(ArrayList<Integer> list, String string, String tag) {
        int fromTag = 0;
        int indexStr = string.indexOf(tag, fromTag);
        int dop = 0;
        if (tag.contains("/")) dop = tag.length();

        while (indexStr >= 0) {
            list.add(indexStr + dop);
            fromTag = indexStr + 1;
            indexStr = string.indexOf(tag, fromTag);
        }
        return list;
    }
}

