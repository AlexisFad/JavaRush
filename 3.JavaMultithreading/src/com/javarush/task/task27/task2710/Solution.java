package com.javarush.task.task27.task2710;

/* 
Расставьте wait-notify
Расставь wait-notify.

Пример вывода:
Thread-0 MailServer received: [Person [Thread-1] wrote an email 'AAA'] in 1001 ms after start


Требования:
1. Объекты класса MailServer должны работать корректно в многопоточном окружении.
2. Объекты класса Person должны работать корректно в многопоточном окружении.
3. В методе run класса MailServer должен присутствовать synchronized блок, монитор - mail.
4. В методе run класса Person должен присутствовать synchronized блок, монитор - mail.
*/

public class Solution {
    public static void main(String[] args) {
        Mail mail = new Mail();
        Thread server = new Thread(new MailServer(mail));
        Thread amigo = new Thread(new Person(mail));

        server.start();
        amigo.start();
    }
}
