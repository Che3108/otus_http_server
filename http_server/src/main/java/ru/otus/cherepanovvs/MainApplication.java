package ru.otus.cherepanovvs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApplication {
    private static final Logger logger = LogManager.getLogger(MainApplication.class.getName());
    // Домашнее задание:
    // - Реализуйте возможность указания статус кода ответа (404)
    // - Реализуйте возможность добавления в тело http ответа JSON объекта

    public static void main(String[] args) {
        logger.info("Запуск приложения");
        HttpServer server = new HttpServer(Integer.parseInt((String)System.getProperties().getOrDefault("port", "8189")));
        server.start();
    }
}

/**
 * HTTP/1.1 200 OK
 * Content-Type: text/html
 *
 * <html>
 *     <body>
 *         <h1>Hello World!</h1>
 *     </body>
 * </html>
 */
