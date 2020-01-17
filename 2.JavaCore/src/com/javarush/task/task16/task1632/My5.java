package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class My5 extends Thread  {

    @Override
    public void run() {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;

        try {
            String s = r.readLine();
            while (!s.equals("N")){
                x = x + Integer.parseInt(s);
                s = r.readLine();
            }
            System.out.println(x);

        } catch (IOException e) {

        }

    }
}
