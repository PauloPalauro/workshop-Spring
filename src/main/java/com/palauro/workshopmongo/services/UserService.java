package com.palauro.workshopmongo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palauro.workshopmongo.domain.User;
import com.palauro.workshopmongo.repository.UserRepository;

// Camada de Serviço

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findALl(){
        return repository.findAll();
    }
    
}
