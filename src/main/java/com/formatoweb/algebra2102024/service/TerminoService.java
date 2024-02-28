package com.formatoweb.algebra2102024.service;

import java.util.List;

public interface TerminoService {
    public char getSigno(String expresionAlgebraica);
    public String getCoeficiente(String expresionAlgebraica);
    List<String> getLiteral(String expresionAlgebraica);
    List<String> getExponente(String expresionAlgebraica);

}