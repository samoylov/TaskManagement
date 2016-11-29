package taskman.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");

//        BookService bookService = (BookService) context.getBean("bookService");
//
//        Book book = bookService.findBookWithUsers("assembler");
//
//        System.out.println(book.getUsers());

    }
}
