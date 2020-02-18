package com.javarush.task.task23.task2305;

/* 
Inner

Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solution = new Solution[2];

        Solution s1 = new Solution();
        s1.innerClasses[0] = new Solution().new InnerClass();
        s1.innerClasses[1] = new Solution().new InnerClass();
        solution[0] = s1;

        Solution s2 = new Solution();
        s2.innerClasses[0] = new Solution().new InnerClass();
        s2.innerClasses[1] = new Solution().new InnerClass();
        solution[1] = s2;

        return solution;
    }

    public static void main(String[] args) {

    }
}
