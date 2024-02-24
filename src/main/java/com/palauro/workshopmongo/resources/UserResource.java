package com.palauro.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // Saber o metodo HTTP que será usado nesse endpoint.
    public ResponseEntity<UserDTO> findById(@PathVariable String id) { // Retornando uma list de UserDTO.
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); // Convertendo para DTO.
    }

    @RequestMapping(method = RequestMethod.POST) // Saber o metodo HTTP que será usado nesse endpoint.
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) { 
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // Saber o metodo HTTP que será usado nesse endpoint.
    public ResponseEntity<Void> delete(@PathVariable String id) { 
        service.delete(id);
        return ResponseEntity.noContent().build(); //Resposta sem retornar nada, codigo 204.
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT) // Saber o metodo HTTP que será usado nesse endpoint.
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) { 
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

}
