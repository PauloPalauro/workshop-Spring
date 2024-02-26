package com.palauro.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.palauro.workshopmongo.domain.Post;

// Camada de acesso a dados (Repository)

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // Precisa saber o "Tipo da classe de dominio" que ele ira gerenciar, e o tipo do ID da classe.

    // Um "query method" que Busca post contendo um dado String no titulo, IgnoreCase = não importa maisculo ou minusculo
    // https://docs.spring.io/spring-data/mongodb/reference/repositories/query-methods-details.html
    List<Post> findByTitleContainingIgnoreCase(String text);

}
