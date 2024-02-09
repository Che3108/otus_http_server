package ru.otus.cherepanovvs.processors;

import ru.otus.cherepanovvs.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;

public interface RequestProcessor {
    void execute(HttpRequest httpRequest, OutputStream output) throws IOException;
}
