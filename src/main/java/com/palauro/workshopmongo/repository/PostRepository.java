package com.palauro.workshopmongo.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.palauro.workshopmongo.domain.Post;

// Camada de acesso a dados (Repository)

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // Precisa saber o "Tipo da classe de dominio" que ele ira gerenciar, e o tipo do ID da classe.

    // Buscar posts contendo um dado string no título
    // Um "query method" que Busca post contendo um dado String no titulo,
    // IgnoreCase = não importa maisculo ou minusculo
    // https://docs.spring.io/spring-data/mongodb/reference/repositories/query-methods-details.html
    List<Post> findByTitleContainingIgnoreCase(String text);

    /*
     * Mesma consulta usando @Query
     * Permite que possa entrar com uma consulta do mongoDB em formato JSON
     */

    // 'title' -> Campo que quero efetuar a busca
    // $regex: ?0 -> é na verdade o valor que for recebido como paramentro, ?0 ->
    // primeiro parametro que veio no metodo
    // $options: 'i' -> ignorar maiusculo e minisculo
    // https://www.mongodb.com/docs/manual/reference/operator/query/regex/
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);


    // Query em mongoDB para -> "Buscar posts contendo um dado string em qualquer lugar (no título, corpo ou comentários) e em um dado intervalo de datas"
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
