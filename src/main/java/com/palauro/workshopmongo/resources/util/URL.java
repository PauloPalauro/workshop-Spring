package com.palauro.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Classe para decodificar o parâmetro de URL

/*
    Protocolo HTTP 
    (?)(nome do paramentro=)(valor)
    bom dia -> Espaço é um caracter especial, encodado fica -> bom%20dia
    Essa classe decodifica a URL.
*/

public class URL {

    public static String decodeParam(String text) {
        try {
            // Função do Java que decodifica que exige -> (Texto que quero decodificar , padrão de decodificação) UTF-8 é o padrão da WEB.
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return ""; 
        }
    }

}
