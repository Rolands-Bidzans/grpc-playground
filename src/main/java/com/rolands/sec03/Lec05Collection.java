package com.rolands.sec03;

import com.rolands.models.sec03.Book;
import com.rolands.models.sec03.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Lec05Collection {
    private static final Logger log = LoggerFactory.getLogger(Lec05Collection.class);
    public static void main(String... args){
        var book1 = Book.newBuilder()
                .setTitle("harry potter - part 1")
                .setAuthor("j k rowling")
                .setPublicationYear(1997)
                .build();

        var book2 = book1.toBuilder().setTitle("harry potter - part 2").setPublicationYear(1998).build();
        var book3 = book1.toBuilder().setTitle("harry potter - part 3").setPublicationYear(1999).build();

        var library = Library.newBuilder()
                .setName("fantasy library")
//                .addBooks(book1)
//                .addBooks(book2)
//                .addBooks(book3)
//                .addAllBooks(Set.of(book1, book2, book3))
                .addAllBooks(List.of(book1, book2, book3))
                .build();

        log.info("{}", library);

        log.info("{}", library.getBooks(1));
    }

}
