package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage( "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            SimpleDateFormat simpleDateFormat = null;

            Calendar calendar = Calendar.getInstance();

            if (message.contains(": ")){
                String[]strings = message.split(": ");
                if(strings.length > 1){

                if(strings[1].equals("дата")) simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                else if (strings[1].equals("день")) simpleDateFormat = new SimpleDateFormat("d");
                else if (strings[1].equals("месяц")) simpleDateFormat = new SimpleDateFormat("MMMM");
                else if (strings[1].equals("год")) simpleDateFormat = new SimpleDateFormat("YYYY");
                else if (strings[1].equals("время")) simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                else if (strings[1].equals("час")) simpleDateFormat = new SimpleDateFormat("H");
                else if (strings[1].equals("минуты")) simpleDateFormat = new SimpleDateFormat("m");
                else if (strings[1].equals("секунды")) simpleDateFormat = new SimpleDateFormat("s");

                if (simpleDateFormat != null) sendTextMessage("Информация для " + strings[0] + ": "
                        + simpleDateFormat.format(calendar.getTime()));

                }

            }

        }
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
