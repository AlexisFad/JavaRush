package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Требования:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {


      SpecialThread b1 = new SpecialThread();
      SpecialThread b2 = new SpecialThread();
      SpecialThread b3 = new SpecialThread();
      SpecialThread b4 = new SpecialThread();
      SpecialThread b5 = new SpecialThread();

      Thread a1 = new Thread(b1);
      Thread a2 = new Thread(b2);
      Thread a3 = new Thread(b3);
      Thread a4 = new Thread(b4);
      Thread a5 = new Thread(b5);


      list.add(a1);
      list.add(a2);
      list.add(a3);
      list.add(a4);
      list.add(a5);

    }

    public static class SpecialThread extends Thread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
