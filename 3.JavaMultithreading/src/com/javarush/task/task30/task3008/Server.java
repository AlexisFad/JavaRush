package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        public void run(){
            ConsoleHelper.writeMessage("Было установлено соединение" + socket.getRemoteSocketAddress());
            try {
                Connection connection = new Connection(socket);
                String userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection,userName);
                serverMainLoop(connection,userName);

                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соеденение с удаленным адресом закрыто");


            } catch (IOException | ClassNotFoundException e) {
               ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();

                if (answer.getType() == MessageType.USER_NAME) {

                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    try {
                        connection.send((new Message(MessageType.USER_ADDED, entry.getKey())));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                    if (message.getType() == MessageType.TEXT)
                        sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                    else ConsoleHelper.writeMessage("Ошибка");
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            int port = ConsoleHelper.readInt();
            ServerSocket server = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                try {
                    Socket socket = server.accept();
                    new Handler(socket).start();

                } catch (Exception e) {
                    e.printStackTrace();
                    r.close();
                    break;
                }
            }
        }


    }
    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение");
            }

        }

    }
}
