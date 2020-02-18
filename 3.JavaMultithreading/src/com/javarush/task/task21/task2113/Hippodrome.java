package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/*
Ипподром
 */

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

     Hippodrome(List list){
        this.horses = list;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <=100 ; i++) {

            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse horse:horses) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse:horses){
            horse.print();
        }
    }

    public Horse getWinner(){
         double winner = 0;
         int id = -1;

        for (int i = 0; i < horses.size() ; i++) {
            if (horses.get(i).distance > winner){
                winner = horses.get(i).distance;
                id = i;
            }
        }
         return horses.get(id);
    }

    public void printWinner(){
        System.out.println("Winner is "+ getWinner().name + "!");

    }

    public static void main(String[] args) throws InterruptedException {
         game = new Hippodrome(new ArrayList<Horse>());
         game.horses.add(new Horse("Амбо", 3,0));
         game.horses.add(new Horse("Сергей", 3,0));
         game.horses.add(new Horse("Александр", 3,0));
         game.run();
         game.printWinner();
    }
}
