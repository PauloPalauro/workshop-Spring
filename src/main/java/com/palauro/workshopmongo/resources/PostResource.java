package com.palauro.workshopmongo.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.palauro.workshopmongo.domain.Post;

import com.palauro.workshopmongo.services.PostService;


// Controladores REST

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET) // Saber o metodo HTTP que será usado nesse endpoint.
    public ResponseEntity<List<Post>> findALl() { // Retornando uma list de UserDTO.
        List<Post> list = service.findALl();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // Saber o metodo HTTP que será usado nesse endpoint.
    public ResponseEntity<Post> findById(@PathVariable String id) { 
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj); 
    }



}
