package com.formatoweb.algebra2102024.model;

public class Termino {
    //es una expresion algebraica que consta de un solo o de varios simbolos
    //NO SEPARADOS ENTRE SI POR EL SIGNO + o -

    private char signo;
    private int coeficiente;
    private String literal;
    private int grado;

    public Termino(char signo, int coeficiente, String literal, int grado) {
        this.signo = signo;
        this.coeficiente = coeficiente;
        this.literal = literal;
        this.grado = grado;
    }

    public char getSigno() {
        return signo;
    }

    public void setSigno(char signo) {
        this.signo = signo;
    }

    public int getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Termino{" +
                "signo=" + signo +
                ", coeficiente=" + coeficiente +
                ", literal=" + literal +
                ", grado=" + grado +
                '}';
    }
}
