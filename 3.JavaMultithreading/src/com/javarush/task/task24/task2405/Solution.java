package com.javarush.task.task24.task2405;

/* 
Black box
1. Восстанови логику метода someAction для поля solutionAction.
2. Пример вывода смотри в комментарии к методу main.
3. Подсказка: метод someAction анонимного класса поля solutionAction должен вызвать метод сабкласса FirstClass, если param > 0, иначе вызвать метод сабкласса SecondClass.

Не изменяй метод main!


Требования:
1. Вывод на экран должен соответствовать условию задачи.
2. Для вывода должны быть использованы строковые константы объявленные в классе SecondClass.
3. В методе someAction анонимного класса Action созданного в классе Solution должен содержаться вызов метода someAction родительского класса (super.someAction()).
4. В методе someAction
*/
public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! Изменения могут быть тут

        public void someAction() {
                if (param <= 0) {
                    SecondClass secondClass = new SecondClass(){
                        @Override
                        public void someAction() {
                            System.out.println(sb.append
                                    (SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM).append(param));
                        }
                    };
                    secondClass.someAction();

                }
                else{
                    FirstClass firstClass = new FirstClass() {
                        @Override
                        public void someAction() {
                            super.someAction();
                        }

                        @Override
                        public Action getDependantAction() {
                            return null;
                        }
                    };

                    for (int i = param; i >= 1 ; i--) {
                        System.out.println(i);
                    }
                    param = 0;

                    firstClass.getDependantAction();
                    firstClass.someAction();
                    someAction();

                }
                //!!!!! Все изменения должны быть только тут
            }
        };

    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
