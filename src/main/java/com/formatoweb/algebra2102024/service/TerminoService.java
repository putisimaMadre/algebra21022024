package com.formatoweb.algebra2102024.service;

import com.formatoweb.algebra2102024.tools.Termino;

import java.util.List;
import java.util.Map;

public interface TerminoService {
    Map<String, Object> separacionElementos(String expresionAlgebraica);
    String getLiteral(String literal);
    List<Termino> getTermino(String expresionAlgebraica);
}