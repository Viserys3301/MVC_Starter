package org.example.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
                .addAnnotatedClass(Catalog.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Reader.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();

            Author author = new Author();
            author.setName("Viserys");

            Book book1 = new Book();
            Book book2 = new Book();
            Book book3 = new Book();

            book1.setTitle("Ya1");
            book1.setAuthor(author);

            book2.setTitle("Ya2");
            book2.setAuthor(author);

            book3.setTitle("Ya2");
            book3.setAuthor(author);

            List<Book> list = new ArrayList<>();
            list.add(book1);
            list.add(book2);

            List<Book> list2 = new ArrayList<>();
            list2.add(book2);
            list2.add(book3);

            Reader reader1 = new Reader();
            reader1.setName("reader1");
            reader1.setBooks(list);

            Reader reader2 = new Reader();
            reader2.setName("reader1");
            reader2.setBooks(list2);

            session.save(author);
            session.save(book1);
            session.save(book2);
            session.save(book3);
            session.save(reader1);
            session.save(reader2);

            Reader reader = session.get(Reader.class,4L);
            Book book = session.get(Book.class,4L);
            reader.getBooks().add(book);


            session.getTransaction().commit();





        }finally {
            session.close();
            factory.close();
        }
    }
}
