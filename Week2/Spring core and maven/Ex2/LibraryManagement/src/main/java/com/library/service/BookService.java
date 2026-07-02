package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceInfo() {
        System.out.println("BookService is active.");
        if (bookRepository != null) {
            bookRepository.printRepositoryInfo();
        } else {
            System.out.println("BookRepository is not injected.");
        }
    }
}
