package com.formatoweb.algebra2102024.service.impl;

import com.formatoweb.algebra2102024.service.TerminoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TerminoServiceImpl implements TerminoService {

    public char getSigno(String expresionAlgebraica){
        char[] expresionAlgebraicaChar = expresionAlgebraica.toCharArray();
        char signo;
        if (expresionAlgebraicaChar[0] == '-'){
            signo = '-';
        }else{
            signo = '+';
        }
        return signo;
    }

    public String getCoeficiente(String expresionAlgebraica){
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
    public List<String> getLiteral(String expresionAlgebraica) {
        char[] expresionAlgebraicaChar = expresionAlgebraica.toCharArray();
        boolean banderaGuardadoLetra = true;
        List<String> base = new ArrayList<>();
        for (int i = 0; i < expresionAlgebraicaChar.length; i++) {
            if (Character.isAlphabetic(expresionAlgebraicaChar[i])){
                if (banderaGuardadoLetra) {
                    base.add(String.valueOf(expresionAlgebraicaChar[i]));
                }else {
                    if (Character.isAlphabetic(expresionAlgebraicaChar[i-1])){
                        base.add(String.valueOf(expresionAlgebraicaChar[i]));
                    }
                }
            } else if (expresionAlgebraicaChar[i] == '('){
                banderaGuardadoLetra = false;
            } else if (expresionAlgebraicaChar[i] == ')'){
                banderaGuardadoLetra = true;
            }else if (expresionAlgebraicaChar[i] == '/'){
                base.add(String.valueOf(expresionAlgebraicaChar[i]));
            }
        }
        return base;
    }

    @Override
    public List<String> getExponente(String expresionAlgebraica) {
        char[] expresionAlgebraicaChar = expresionAlgebraica.toCharArray();
        boolean banderaExponente = false;
        //boolean banderaBase = false;
        String exponenteCadena = "";
        List<String> exponente = new ArrayList<>();
        int exponenteLength = expresionAlgebraicaChar.length;

        for (int i = 0; i < expresionAlgebraicaChar.length; i++) {
            if (expresionAlgebraicaChar[i] == '('){
                banderaExponente = true;
                exponenteCadena = "";
            }
            if (banderaExponente){
                exponenteCadena = exponenteCadena + expresionAlgebraicaChar[i];
            }
            if (expresionAlgebraicaChar[i] == ')'){
                banderaExponente = false;
                exponente.add(exponenteCadena);
                exponenteCadena = "";
            }
            if (Character.isAlphabetic(expresionAlgebraicaChar[i]) && !banderaExponente){
                if (i>0) {
                    if (Character.isAlphabetic(expresionAlgebraicaChar[i - 1])) {
                        exponente.add("1");
                    }
                }
            }
            if (exponenteLength-1 == i){
                if (Character.isAlphabetic(expresionAlgebraicaChar[exponenteLength-1])) {
                    exponente.add("1");
                }
            }
        }
        return exponente;
    }
}
