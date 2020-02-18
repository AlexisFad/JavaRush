package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public static void writeMessage(String message){
       System.out.println(message);
    }

    public static String readString() throws IOException {
       return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
       List<Dish> dishes = new ArrayList<>();
       Dish[] dish = Dish.values();
       String sr= Arrays.toString(dish);
       writeMessage(Dish.allDishesToString());
       writeMessage("Введите название блюда:");
        String s = readString();

           while (!s.equals("exit")) {
               if (sr.contains(s)) {
               for (int i = 0; i < dish.length; i++) {
                   if (dish[i].name().equals(s)) {
                       dishes.add(dish[i]);
                   }
               }
           }
               else writeMessage("Блюда не существует");
               s = readString();
       }
           return dishes;
    }
}
