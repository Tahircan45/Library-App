package com.example.service;

import com.example.models.Author;
import com.example.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> listAll(){
        return repository.findAll();
    }

    public void save(Author author){
        repository.save(author);
    }

    public Author get(long id){
        return repository.findById(id).get();
    }

    public void delete(long id){
        repository.deleteById(id);
    }
}
