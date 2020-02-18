package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) return " ";
        else return "Your order: " + dishes + " of " + tablet + ",cooking time " + getTotalCookingTime() + "min";
    }

    public int getTotalCookingTime(){
        int result = 0;
        for (Dish dish: dishes) result += dish.getDuration();
        return result;
    }

    public boolean isEmpty(){
       return dishes.isEmpty();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();

    }
}
