package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
        initDishes();
    }

    @Override
    protected void initDishes() throws IOException {
        List<Dish> list = new ArrayList<>();
        for (int i = 0; i < Math.random() * Dish.values().length + 3; i++) {
            Dish[] dishes = Dish.values();
            list.add(dishes[(int) (Math.random() * Dish.values().length-1)]);
        }
        dishes = list;
    }
}