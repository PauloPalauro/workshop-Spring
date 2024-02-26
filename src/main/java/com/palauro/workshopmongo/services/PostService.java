package com.palauro.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palauro.workshopmongo.domain.Post;
import com.palauro.workshopmongo.repository.PostRepository;
import com.palauro.workshopmongo.services.exception.ObjectNotFoundException;

// Camada de Serviço

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findALl() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) { // Metodo de Busca 
        return repository.findByTitleContainingIgnoreCase(text);
    }

}
