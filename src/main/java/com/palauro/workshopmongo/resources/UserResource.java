package com.palauro.workshopmongo.resources;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.palauro.workshopmongo.domain.User;
import com.palauro.workshopmongo.services.UserService;

// Controladores RESST

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) // Saber o metodo HTTP que será usado nesse endpoint.
    public ResponseEntity<List<User>> findALl() {
        List<User> list = service.findALl();
        return ResponseEntity.ok().body(list);
    }

}
