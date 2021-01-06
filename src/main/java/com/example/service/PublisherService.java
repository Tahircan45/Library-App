package com.example.service;

import com.example.models.Publisher;
import com.example.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PublisherService {

    @Autowired
    private PublisherRepository repository;

    public List<Publisher> listAll(){
        return repository.findAll();
    }

    public void save(Publisher publisher){
        repository.save(publisher);
    }

    public Publisher get(long id){
        return repository.findById(id).get();
    }

    public void delete(long id){
        repository.deleteById(id);
    }
}
