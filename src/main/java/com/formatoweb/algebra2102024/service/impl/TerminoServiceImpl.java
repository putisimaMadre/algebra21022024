package com.formatoweb.algebra2102024.service.impl;

import com.formatoweb.algebra2102024.service.TerminoService;
import com.formatoweb.algebra2102024.model.Termino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TerminoServiceImpl implements TerminoService {
    @Override
    public Map<String, Object> separacionElementos(String expresionAlgebraica) {
        Map<String, Object> elementos = new HashMap<>();
        elementos.put("signo", getSigno(expresionAlgebraica));
        elementos.put("coeficiente", getCoeficiente(expresionAlgebraica));
        return elementos;
    }

    private char getSigno(String expresionAlgebraica){
        char[] expresionAlgebraicaChar = expresionAlgebraica.toCharArray();
        char signo;
        if (expresionAlgebraicaChar[0] == '-'){
            signo = '-';
        }else{
            signo = '+';
        }
        return signo;
    }

    private String getCoeficiente(String expresionAlgebraica){
        char[] expresionAlgebraicaChar = expresionAlgebraica.toCharArray();
        int contador = 0;
        boolean banderaPrimeraEntrada = true;
        String coeficiente = "";

        if (expresionAlgebraicaChar[0] == '-'){
            contador = 1;
        }else{
            contador = 0;
        }
        for (int i = contador; i < expresionAlgebraicaChar.length; i++) {
            if (Character.isDigit(expresionAlgebraicaChar[i]) && contador == i){ //Cuando son numeros
                contador++;
                coeficiente = coeficiente + expresionAlgebraicaChar[i];
            }else if (expresionAlgebraicaChar[i] == '/'){   //Cuando es una fraccion
                contador=i;
                contador++;
                banderaPrimeraEntrada = true;
                coeficiente = coeficiente + expresionAlgebraicaChar[i];
                if (coeficiente.equals("/")){
                    coeficiente = "1/";
                }
            }else {     //Cuando es una letra o un simbolo (Cuando es algo que no es un numero)
                //Para Coeficiente
                char[] coeficienteChar = coeficiente.toCharArray();
                int coeficienteLength = coeficienteChar.length;
                if (banderaPrimeraEntrada){
                    banderaPrimeraEntrada = false;
                    if (coeficienteLength > 1) {
                        if (coeficienteChar[coeficienteLength - 1] == '/') {
                            coeficiente = coeficiente + "1";
                        }
                    }
                    if (coeficiente.isEmpty()){
                        coeficiente = "1";
                    }
                }
            }
        } //fin for
        return coeficiente;
    }

    @Override
    public String getLiteral(String literal) {
        return null;
    }

    @Override
    public List<Termino> getTermino(String expresionAlgebraica) {
        List<Termino> terminos = new ArrayList<>();
        Termino termino = new Termino('-', 5, "a2+1b3c", 2);
        Termino termino2 = new Termino('-', 3, "d4f5k", 2);
        terminos.add(termino);
        terminos.add(termino2);
        return terminos;
    }
}
