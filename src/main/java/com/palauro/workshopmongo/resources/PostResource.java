package com.palauro.workshopmongo.resources;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.palauro.workshopmongo.domain.Post;
import com.palauro.workshopmongo.resources.util.URL;
import com.palauro.workshopmongo.services.PostService;

// Controladores REST / endpoints

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

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    // @RequestParam = Criterio de Busca vai ser como um parametro com o ?.
    // value = "text" = Para o endpoint indentificar o nome do parametro.
    // defaultValue = "" = Se o parametro nao for informado, sera colocado o valor
    // "" -> String vazia
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text); // Utilizando a função de decodificar que criamos.
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }


    //End Point da FullSearch.
    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text); // Utilizando a função de decodificar que criamos.
        Date min = URL.convertDate(minDate, new Date(0L)); // Tratando a data minina, ou gerar uma data minina do tipo DATE do java que é 01-01-1970.
        Date max = URL.convertDate(maxDate, new Date()); // Tratando a data maxima, ou gerar uma data maxima do tipo DATE do java que é o instante atual do sistema.
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}
