package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;

    LoggingStateThread(Thread target){
        this.target = target;
    }

    @Override
    public void run() {
        State state = target.getState();
        State statePrint = null;

        while (state != State.TERMINATED) {
            if (state != statePrint) System.out.println(state);
            statePrint = state;
            state = target.getState();
        }
        System.out.println(target.getState());
    }

}
