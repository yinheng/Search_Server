package com.socketServer;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    private Socket socket;
    protected void setSocket(Socket socket) {
        this.socket = socket;
    }
    protected Socket getSocket() {
        return socket;
    }
    protected void close() {
        try {
            socket.close();

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("socket close failed");
        }
    }
}
