package ru.otus.cherepanovvs.processors;

import ru.otus.cherepanovvs.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnknownRequestProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(UnknownRequestProcessor.class.getName());

    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        logger.warn("Клиент запросил несуществующую страницу");
        String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html;charset=utf-8\r\n\r\n<html><body><h1>Получен неизвестный запрос</h1></body></html>";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
