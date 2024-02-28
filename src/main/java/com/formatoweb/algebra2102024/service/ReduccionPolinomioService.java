package com.formatoweb.algebra2102024.service;

import java.util.List;

public interface ReduccionPolinomioService {
    List<String> separacionTerminos(String polinomio);
    void reduccionPolinomio(List<String> polinomio);
}
