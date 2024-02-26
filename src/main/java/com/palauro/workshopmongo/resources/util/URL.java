package com.palauro.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
            // Função do Java que decodifica que exige -> (Texto que quero decodificar ,
            // padrão de decodificação) UTF-8 é o padrão da WEB.
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    // Metodo para converter as datas recebidas
    // Date defaultValue = Caso converter a data falhe, utiliza a data padrão.
    public static Date convertDate(String textDate, Date defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textDate); //Formatando a data
        } catch (ParseException e) {
            return defaultValue;
        }
    }

}
