package com.formatoweb.algebra2102024.service.impl;

import com.formatoweb.algebra2102024.service.ReduccionPolinomioService;
import com.formatoweb.algebra2102024.service.TerminoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReduccionPolinomioServiceImpl implements ReduccionPolinomioService {
    @Autowired
    TerminoService terminoService;
    @Override
    public List<String> separacionTerminos(String polinomio) {
        List<String> polinomioSeparado = new ArrayList<>();
        char[] polinomioChar = polinomio.toCharArray();
        String polinomioSeparadoString = "";
        String signo = "";
        int polinomioLength = polinomioChar.length;

        for (int i = 0; i < polinomioChar.length; i++) {
            polinomioSeparadoString = polinomioSeparadoString + polinomioChar[i];
            if (polinomioChar[i] == '+' || polinomioChar[i] == '-' && i > 1){
                signo = polinomioSeparadoString.substring(0,1);
                if (signo.equals("+") ){
                    polinomioSeparadoString = polinomioSeparadoString.substring(1);
                }
                polinomioSeparadoString = polinomioSeparadoString.substring(0, polinomioSeparadoString.length() - 1);
                polinomioSeparado.add(polinomioSeparadoString);
                polinomioSeparadoString = String.valueOf(polinomioChar[i]);
            }
            if (polinomioLength-1 == i){
                polinomioSeparado.add(polinomioSeparadoString);
            }
        }
        return polinomioSeparado;
    }

    @Override
    public void reduccionPolinomio(List<String> polinomio) {
        for (String monomio: polinomio){
            System.out.print(terminoService.getSigno(monomio));
            System.out.print(terminoService.getCoeficiente(monomio));
            System.out.print(terminoService.getLiteral(monomio));
            System.out.print(terminoService.getExponente(monomio));
        }
    }
}
