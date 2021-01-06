package com.example.service;

import com.example.models.Role;
import com.example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Iterable<Role> findAll(){
        return roleRepository.findAll();
    }
}
