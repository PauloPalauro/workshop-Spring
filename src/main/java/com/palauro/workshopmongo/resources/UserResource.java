package com.palauro.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.palauro.workshopmongo.domain.User;
import com.palauro.workshopmongo.dto.UserDTO;
import com.palauro.workshopmongo.services.UserService;

// Controladores REST

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) // Saber o metodo HTTP que será usado nesse endpoint.
    public ResponseEntity<List<UserDTO>> findALl() { // Retornando uma list de UserDTO.
        List<User> list = service.findALl();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // Convertendo cada item da lista original de user em userDTO. 
        return ResponseEntity.ok().body(listDto);
    }

}
