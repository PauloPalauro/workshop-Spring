package com.palauro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palauro.workshopmongo.domain.User;
import com.palauro.workshopmongo.repository.UserRepository;
import com.palauro.workshopmongo.services.exception.ObjectNotFoundException;

// Camada de Serviço

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findALl() {
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
