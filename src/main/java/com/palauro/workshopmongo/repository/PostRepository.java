package com.palauro.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.palauro.workshopmongo.domain.Post;

// Camada de acesso a dados (Repository)

@Repository
public interface PostRepository extends MongoRepository<Post, String> { 
    // Precisa saber o "Tipo da classe de dominio" que ele ira gerenciar, e o tipo do ID da classe.

}
