package com.example.service;

import com.example.domain.Author;
import com.example.domain.Book;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * StreamDemo
 *
 * @author Kyrie.Wang
 */
public class StreamDemo {

    private static final Faker FAKER = new Faker(Locale.CHINA);

    public List<Author> getAllAutor() {
        ArrayList<Author> authors = new ArrayList<>();
        int count = 50;
        for (int i = 0; i < count; i++) {
            Author author = new Author();
            author.setId(FAKER.number().numberBetween(1L, 100L));
            author.setName(FAKER.leagueOfLegends().quote());
            author.setName(FAKER.name().username());
            author.setAge(FAKER.number().numberBetween(1, 100));

            ArrayList<Book> books = new ArrayList<>();
            Book book = new Book();
            book.setCategory(FAKER.book().genre());
            book.setName(FAKER.book().title());
            book.setIntro(FAKER.book().publisher());
            book.setScore(FAKER.number().numberBetween(0, 10));
            books.add(book);

            author.setBooks(books);
            authors.add(author);
        }
        return authors;
    }
}
