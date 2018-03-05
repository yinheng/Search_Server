package com.socketServer;

import com.search.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888, 10);
            System.out.println("server init");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Socket socket = serverSocket.accept();
                            System.out.println("socket connect");
                            Connection connection = new Connection();
                            connection.setSocket(socket);
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    readMessage(connection);
                                }
                            }).start();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("connect failed");
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("start server failrd");
        }


    }

    public void readMessage(Connection c) {
        Socket socket = c.getSocket();
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s;
            Search search = new Search();
            search.FireFoxInit();

            while ((s = br.readLine()) != null) {
                //StringBuffer massage = new StringBuffer();
                //massage.append(s);
                System.out.println("massage is :" + s);

                search.search(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("read message failed");
        }
    }
}
