package com.palauro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palauro.workshopmongo.domain.User;
import com.palauro.workshopmongo.dto.UserDTO;
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

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id); // verificar se não é nulo
        repository.deleteById(id);

    }

    public User fromDTO(UserDTO objDTO) { // Caminho inverso da classe "UserDTO". Instanciando um "User" atraves de um "UserDTO".
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
