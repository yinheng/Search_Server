package com;

import com.search.Search;
import com.socketServer.SocketServer;

public class Lanucher {
    public static void main(String[] args) {
        SocketServer  socketServer = new SocketServer();
        socketServer.startServer();
    }
}
