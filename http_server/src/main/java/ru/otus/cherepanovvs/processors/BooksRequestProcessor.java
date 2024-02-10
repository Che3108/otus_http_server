package ru.otus.cherepanovvs.processors;

import ru.otus.cherepanovvs.HttpRequest;
import ru.otus.cherepanovvs.Book.Book;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

public class BooksRequestProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(OperationAddRequestProcessor.class.getName());
    private Gson gson;
    private List<Book> books = new ArrayList<>();

    public BooksRequestProcessor() {
        this.books.add(
            new Book(
                "Лабиринт отражений",
                "Сергей Лукьяненко",
                "Киберпанк",
                "Будущее наступило. Теперь в виртуальную реальность можно погрузиться полностью. Здесь вы сможете делать все, что душе угодно: пить, убивать, заниматься извращенным сексом, и за это ничего не будет. Заманчиво, не правда ли... "
            )
        );
        this.books.add(
            new Book(
                "Линия Грез",
                "Сергей Лукьяненко",
                "Научная фантастика",
                "В далеком будущем человечество открыло способ путешествий в межзвездном гиперпространстве, а затем приступило к активной колонизации космоса. Это послужило началом Смутной войны между населяющими... "
            )
        );
        this.books.add(
            new Book(
                "И пришёл Лесник! Книга 1",
                "Василий Лазарев",
                "Научная фантастика",
                "Оперативник контрразведки СМЕРШ попал в Улей. Улей пожалел об этом, ибо звали его Лесник. И пришёл Лесник и получили все…Страшная история о том как медленно, а порой и быстро умирало всё живое в Улье.Alex Andr \"Грибы с... "
            )
        );
    }
    
    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        logger.info("Клинент запросил список книг");
        gson = new Gson();
        String response = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n" +  gson.toJson(this.books);
        System.out.println(gson.toJson(this.books));
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
