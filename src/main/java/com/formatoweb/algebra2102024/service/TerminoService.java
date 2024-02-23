package com.formatoweb.algebra2102024.service;

import com.formatoweb.algebra2102024.model.Termino;

import java.util.List;
import java.util.Map;

public interface TerminoService {
    public char getSigno(String expresionAlgebraica);
    public String getCoeficiente(String expresionAlgebraica);
    List<String> getLiteral(String expresionAlgebraica);
    List<String> getExponente(String expresionAlgebraica);

}