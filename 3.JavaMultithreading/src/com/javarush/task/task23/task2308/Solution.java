package com.javarush.task.task23.task2308;

/*
Рефакторинг, вложенные классы

Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.


Требования:
1. В классе Solution должен быть создан класс Constants содержащий строковые константы.
2. Класс Constants должен быть публичным.
3. Класс Constants должен быть объявлен с модификатором, запрещающим наследование от этого класса.
4. В классе Constants должна существовать константа SERVER_IS_CURRENTLY_NOT_ACCESSIBLE со значением "The server is not currently accessible.".
5. В классе Constants должна существовать константа USER_IS_NOT_AUTHORIZED со значением "The user is not authorized.".
6. В классе Constants должна существовать константа USER_IS_BANNED со значением "The user is banned.".
7. В классе Constants должна существовать константа ACCESS_IS_DENIED со значением "Access is denied.".
*/

public class Solution {
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_IS_CURRENTLY_NOT_ACCESSIBLE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_IS_CURRENTLY_NOT_ACCESSIBLE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.USER_IS_NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.USER_IS_NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.USER_IS_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.USER_IS_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.ACCESS_IS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.ACCESS_IS_DENIED, cause);

        }
    }

    public static final class Constants{
       public final static String SERVER_IS_CURRENTLY_NOT_ACCESSIBLE  = "The server is not currently accessible.";
       public final static String USER_IS_NOT_AUTHORIZED = "The user is not authorized.";
       public final static String USER_IS_BANNED = "The user is banned.";
       public final static String ACCESS_IS_DENIED = "Access is denied.";

    }

    public static void main(String[] args) {

    }
}
