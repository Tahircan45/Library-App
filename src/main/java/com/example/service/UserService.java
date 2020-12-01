package com.example.service;

import com.example.models.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public Iterable<User> listAll(){
        return repository.findAll();
    }
    public void save(User user){
        repository.save(user);
    }
    public User get(int id){
        return repository.findById(id).get();
    }
    public void delete(int id){
        repository.deleteById(id);
    }
}
