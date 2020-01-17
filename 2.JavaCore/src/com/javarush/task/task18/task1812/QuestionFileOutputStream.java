package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream

Используя шаблон проектирования Wrapper (Decorator) расширь функциональность AmigoOutputStream.
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу "Вы действительно хотите закрыть поток? Д/Н".
2. Считайте строку.
3. Если считанная строка равна "Д", то закрыть поток.
4. Если считанная строка не равна "Д", то не закрывать поток.


Требования:
1. Интерфейс AmigoOutputStream изменять нельзя.
2. Класс QuestionFileOutputStream должен реализовывать интерфейс AmigoOutputStream.
3. Класс QuestionFileOutputStream должен инициализировать в конструкторе поле типа AmigoOutputStream.
4. Все методы QuestionFileOutputStream должны делегировать свое выполнение объекту AmigoOutputStream.
5. Метод close() должен спрашивать у пользователя "Вы действительно хотите закрыть поток? Д/Н".
6. Метод close() должен закрывать поток только в случае, если считает с консоли ответ "Д".
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream){
        this.original = amigoOutputStream;
    }

    @Override
    public void flush() throws IOException {
        original.flush();

    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);

    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);

    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b,off,len);

    }

    @Override
    public void close() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String s = r.readLine();
        if(s.equals("Д")) original.close();
    }
}

