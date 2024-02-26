package com.palauro.workshopmongo.dto;

import java.io.Serializable;
import com.palauro.workshopmongo.domain.User;

// Criando um "DTO" para a classe "User".
// DTO (Data Transfer Object): é um objeto que tem o papel de carregar dados das entidades de forma simples, podendo inclusive "projetar" apenas alguns dados da entidade original. 

public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User obj){ // Instanciando um "UserDTO" a partir de um "User"
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
