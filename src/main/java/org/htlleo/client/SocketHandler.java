package org.htlleo.client;

import org.htlleo.models.Message;
import org.htlleo.models.MessageDistributor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class SocketHandler extends Thread {
    private Socket socket;
    private ObjectInputStream ois = null;

    public SocketHandler(Socket socket) {
        if (socket == null)
            throw new IllegalArgumentException("socket");

        this.socket = socket;
        try {
            ois = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDaemon(true);
    }
    @Override
    public void run() {
        try {
            Message clientMessage = (Message)ois.readObject();

            System.out.printf("%s\n", clientMessage.toString());
            MessageDistributor.getInstance().addMessage(clientMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
            ois = null;
            socket.close();
            socket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
