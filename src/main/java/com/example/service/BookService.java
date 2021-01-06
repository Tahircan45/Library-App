package com.example.service;

import com.example.models.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> listAllBooks(){
        return repository.findAll();
    }

    public List<Book> listAllBooks(String keyword) {
        return repository.findAll(keyword);
    }

    public void save(Book book){
        repository.save(book);
    }

    public Book get(long id){
        return repository.findById(id).get();
    }

    public void delete(long id){
        repository.deleteById(id);
    }

}
