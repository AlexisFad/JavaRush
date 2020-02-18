package com.javarush.task.task21.task2113;

public class Horse {
    String name;
    double speed;
    double distance;

   public Horse(String name, double speed, double distance){
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move(){
       this.distance += (this.speed * (Math.random()*1));

    }
    public void print(){
       String print = "";
        for (int i = 0; i < Math.floor(distance); i++) print +=".";
        print += this.name;
        System.out.println(print);

    }

}
