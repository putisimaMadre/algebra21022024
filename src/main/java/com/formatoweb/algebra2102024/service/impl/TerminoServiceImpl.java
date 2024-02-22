package com.formatoweb.algebra2102024.service.impl;

import com.formatoweb.algebra2102024.service.TerminoService;
import com.formatoweb.algebra2102024.tools.Termino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TerminoServiceImpl implements TerminoService {
    @Override
    public Map<String, Object> separacionElementos(String expresionAlgebraica) {
        Map<String, Object> terminosSeparados = new HashMap<>();
        boolean banderaPrimeraEntrada = true;
        int j = 0;
        char[] expresionAlgebraicaChar = expresionAlgebraica.toCharArray();
        String coeficiente = "";
        terminosSeparados.put("todo", expresionAlgebraica);
        if (expresionAlgebraicaChar[0] == '-'){
            terminosSeparados.put("signo", expresionAlgebraicaChar[0]);
            j = 1;
            for (int i = 1; i < expresionAlgebraicaChar.length; i++) {
                if (Character.isDigit(expresionAlgebraicaChar[i]) && j == i){ //Cuando son numeros
                    j++;
                    coeficiente = coeficiente + expresionAlgebraicaChar[i];
                    if (expresionAlgebraicaChar.length-1 == i){
                        terminosSeparados.put("coeficiente", coeficiente);
                    }
                }else if (expresionAlgebraicaChar[i] == '/'){   //Cuando es una fraccion
                    j=i;
                    j++;
                    banderaPrimeraEntrada = true;
                    coeficiente = coeficiente + expresionAlgebraicaChar[i];
                    if (coeficiente.equals("/")){
                        coeficiente = "1/";
                    }
                    //System.out.println("esta entrando a la barra: " + expresionAlgebraicaChar[i]);
                }else {     //Cuando es una letra o un simbolo (Cuando es algo que no es un numero)
                    char[] coeficienteChar = coeficiente.toCharArray();
                    int coeficienteLength = coeficienteChar.length;
                    if (banderaPrimeraEntrada){
                        banderaPrimeraEntrada = false;
                        if (coeficienteLength > 1) {
                            if (coeficienteChar[coeficienteLength - 1] == '/') {
                                System.out.println(coeficienteChar[coeficienteLength - 1]);
                                coeficiente = coeficiente + "1";
                            }
                        }
                        if (coeficiente.isEmpty()){
                            coeficiente = "1";
                        }
                        terminosSeparados.put("coeficiente", coeficiente);
                    }
                }
            }
        }else{
            terminosSeparados.put("signo", '+');
        }
        return terminosSeparados;
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
