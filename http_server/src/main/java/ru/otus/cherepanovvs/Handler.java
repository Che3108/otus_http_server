package ru.otus.cherepanovvs;

import java.io.IOException;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Handler implements Runnable {
    private final Socket socket;
    private Dispatcher dispatcher;
    private static final Logger logger = LogManager.getLogger(Handler.class.getName());
    private byte[] buffer;

    public Handler(Socket socket) {
        this.socket = socket;
        this.dispatcher = new Dispatcher();
        this.buffer = new byte[8192];
    }

    public void run() {
        try {
            int n = socket.getInputStream().read(buffer);
            String rawRequest = new String(buffer, 0, n);
            HttpRequest httpRequest = new HttpRequest(rawRequest);
            httpRequest.printInfo(true);
            dispatcher.execute(httpRequest, socket.getOutputStream());
            socket.close();
        } catch (IOException e) {
            logger.error("Ошибка cоединения", e);
        }
    }
}
