package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/*
Чат
 */

public class Client {
   protected Connection connection;
   private volatile boolean clientConnected = false;

   public class SocketThread extends Thread {
      protected void processIncomingMessage(String message){
          ConsoleHelper.writeMessage(message);
      }

      protected void informAboutAddingNewUser(String userName){
          ConsoleHelper.writeMessage(userName + ": Присоединился к чату");
      }

      protected void informAboutDeletingNewUser(String userName){
          ConsoleHelper.writeMessage(userName + ": Покинул чат");
      }

      protected void notifyConnectionStatusChanged(boolean connected){
          clientConnected = connected;
          synchronized (Client.this){
              Client.this.notify();
          }
      }

      protected void clientHandshake() throws IOException, ClassNotFoundException {

          while (true){
              Message message = connection.receive();

              if (message.getType() == MessageType.NAME_REQUEST){
                  String name = getUserName();
                  connection.send(new Message(MessageType.USER_NAME, name));
              }
             else if (message.getType() == MessageType.NAME_ACCEPTED){
                  notifyConnectionStatusChanged(true);
                  break;
              }
              else
                  throw new IOException("Unexpected MessageType");

          }

       }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
          Message message = connection.receive();
          while (true){
              if(message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
              else if(message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
              else if(message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
              else throw new IOException("Unexpected MessageType");

              message = connection.receive();

          }

        }
       @Override
       public void run() {
           try {
               String serverAddress = getServerAddress();
               int port = getServerPort();
               Socket socket = new Socket(serverAddress,port);
               connection = new Connection(socket);

               clientHandshake();
               clientMainLoop();

           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
               notifyConnectionStatusChanged(false);
           }

       }
   }
   protected String getServerAddress() throws IOException {
       return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        return ConsoleHelper.readString();

    }

    protected boolean shouldSendTextFromConsole(){
       return true;
    }

    protected SocketThread getSocketThread(){
       return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Сообщение не отпарвлено");
            clientConnected = false;
        }
    }

    public void run(){
       SocketThread socketThread = getSocketThread();
       socketThread.setDaemon(true);

       socketThread.start();

        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Сорян");
            }
        }

       if(clientConnected == true) ConsoleHelper.writeMessage("Соединение установлено." +
               "Для выхода наберите команду 'exit'.");
       else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

      while (clientConnected == true){
          String client =  ConsoleHelper.readString();
          if (client.equals("exit")) clientConnected = false;
          if(shouldSendTextFromConsole()){
              sendTextMessage(client);
          }
      }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();

    }
}
