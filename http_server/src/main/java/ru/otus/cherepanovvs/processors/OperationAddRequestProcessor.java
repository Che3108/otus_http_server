package ru.otus.cherepanovvs.processors;

import ru.otus.cherepanovvs.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OperationAddRequestProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(OperationAddRequestProcessor.class.getName());
    
    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        logger.info("Клиент запустил операцию сложения");
        int a = Integer.parseInt(httpRequest.getParameter("a"));
        int b = Integer.parseInt(httpRequest.getParameter("b"));
        String result = a + " + " + b + " = " + (a + b);
        String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body><h1>" + result + "</h1></body></html>";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
