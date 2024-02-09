package ru.otus.cherepanovvs;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpServer {
    private int port;
    private static final Logger logger = LogManager.getLogger(HttpServer.class.getName());
    private final ExecutorService pool;

    public HttpServer(int port) {
        this.port = port;
        pool = Executors.newCachedThreadPool();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Сервер запущен на порту: " + port);

            try {
                while (true) {
                    pool.execute(new Handler(serverSocket.accept()));
                }
            } catch (IOException e) {
                logger.error("Ошибка соединения", e);
                pool.shutdown();
            }

        } catch (Exception e) {
            logger.error("Ошибка запуска сервера", e);
        }
    }
}
