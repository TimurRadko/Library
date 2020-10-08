package com.epam.library.data.comparator;

import com.epam.library.model.Book;

import java.util.Comparator;

public abstract class AbstractBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book fistBook, Book secondBook) {
        String firstBookFiled = getField(fistBook);
        String secondBookFiled = getField(secondBook);

        return firstBookFiled.compareToIgnoreCase(secondBookFiled);
    }

    abstract String getField(Book book);
}
