package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;
/* 
Кроссворд

1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен существовать метод detectAllWords.
2. В классе Solution должен существовать статический класс Word.
3. Класс Solution не должен содержать статические поля.
4. Метод detectAllWords должен быть статическим.
5. Метод detectAllWords должен быть публичным.
6. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'm', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'},
        };

        detectAllWords(crossword, "one").forEach(System.out::println);

    }
    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        int[][] result;
        List<Word> list = new ArrayList<>();

        for (String s: words) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == chars[0]) {
                    result = detectAllWords1(crossword, s, i, j);
                        for (int q = 0; q < result.length; q++) {
                            if (result[q][1] > -1 || result[q][2] > -1) {
                                    Word newWord = new Word(s);
                                    newWord.setStartPoint(j,i);
                                    newWord.setEndPoint(result[q][2],result[q][1]);
                                   list.add(newWord);
                            }
                        }
                    }
                }
            }
                }

        return list;
    }

    public static int[][] detectAllWords1(int[][] crossword, String word, int i, int j) {

        int[][] result = new int[8][3];

        int finishI = i;
        int finishJ = j;

        int count = 0;

        char[] chars = word.toCharArray();

        while (count < chars.length - 1 ) { //диагональ
                if (finishI > 0 && finishJ > 0 && crossword[finishI - 1][finishJ - 1] == chars[count + 1]) {
                    count++;
                    finishI = finishI - 1;
                    finishJ = finishJ - 1;
                }
                     else {
                        finishI = -1;
                        finishJ = -1;
                        break;
                    }
                }

            result[0][1] = finishI;
            result[0][2] = finishJ;

            finishI = i;
            finishJ = j;
            count = 0;

                    while (count < chars.length - 1 ) { //ищем по диагонали сверху-вниз
                        if (finishI < crossword.length - 1 && finishJ < crossword[0].length - 1 &&
                                crossword[finishI + 1][finishJ + 1] == chars[count + 1])
                        {
                            count++;
                            finishI = finishI + 1;
                            finishJ = finishJ + 1;

                        } else {
                            finishI = -1;
                            finishJ = -1;
                            break;
                        }
                    }

                result[1][1] = finishI;
                result[1][2] = finishJ;

                finishI = i;
                finishJ = j;
                count = 0;

                    while (count < chars.length - 1) {  //ищем по диагонали снизу-вверх 2
                        if (finishI > 0 && finishJ < crossword[0].length -1 &&
                                crossword[finishI - 1][finishJ + 1] == chars[count + 1]) {
                                count++;
                                finishI = finishI - 1;
                                finishJ = finishJ + 1;
                            } else
                                {
                                finishI = -1;
                                finishJ = -1;
                                break;
                            }
                        }

                result[2][1] = finishI;
                result[2][2] = finishJ;

                finishI = i;
                finishJ = j;
                count = 0;

            while (count < chars.length - 1) {  //ищем по диагонали сверху-вниз 2
                if (finishI < crossword.length -1 && finishJ > 0 &&
                        crossword[finishI + 1][finishJ - 1] == chars[count + 1]) {
                        count++;
                        finishI = finishI + 1;
                        finishJ = finishJ - 1;
                    } else
                        {
                        finishI = -1;
                        finishJ = -1;
                        break;
                    }
            }

        result[3][1] = finishI;
        result[3][2] = finishJ;

        finishI = i;
        finishJ = j;
        count = 0;

            while (count < chars.length - 1) {  //слева направо
                if (finishJ < crossword[0].length -1 && crossword[finishI][finishJ + 1] == chars[count + 1]) {
                        count++;
                        finishJ = finishJ + 1;
                    } else {
                        finishI = -1;
                        finishJ = -1;
                        break;
                    }
            }

        result[4][1] = finishI;
        result[4][2] = finishJ;

        finishI = i;
        finishJ = j;

        count = 0;

            while (count < chars.length - 1) {   //справа налево
                if (finishJ > 0 && crossword[finishI][finishJ -1 ] == chars[count + 1]) {
                        count++;
                        finishJ = finishJ - 1;
                    } else {
                        finishI = -1;
                        finishJ = -1;
                        break;
                    }
            }

        result[5][1] = finishI;
        result[5][2] = finishJ;

        finishI = i;
        finishJ = j;

        count = 0;

            while (count < chars.length - 1) {   //сверху-вних
                if (finishI < crossword.length-1 && (crossword[finishI+1][finishJ] == chars[count + 1])) {
                        count++;
                        finishI = finishI + 1;
                    }
                    else
                        {
                        finishI = -1;
                        finishJ = -1;
                        break;
                    }
                }

        result[6][1] = finishI;
        result[6][2] = finishJ;

        finishI = i;
        finishJ = j;

        count = 0;

            while (count < chars.length - 1) {  //снизу-вверх
                if (finishI > 0 && crossword[finishI-1][finishJ] == chars[count + 1]) {
                        count++;
                        finishI = finishI - 1;
                    }
                else {
                        finishI = -1;
                        finishJ = -1;
                        break;
                    }
                }

        result[7][1] = finishI;
        result[7][2] = finishJ;

            return result;
        }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
