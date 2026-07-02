package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.printServiceInfo();
        
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);
        bookRepository.printRepositoryInfo();
    }
}
