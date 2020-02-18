package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable {
    final private Socket socket;
    final private ObjectOutputStream out;
    final private ObjectInputStream in;
    private Object lock1 = new Object();
    private Object lock2 = new Object();


    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

   public void send(Message message) throws IOException {
       synchronized (out) {
           out.writeObject(message);
           out.flush();

       }
   }
   public Message receive() throws IOException, ClassNotFoundException{
        synchronized (in){
            Message message = (Message) in.readObject();
            return message;
        }
    }

    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }

    @Override
    public void close() throws IOException {
        socket.close();
        in.close();
        out.close();

    }
}
