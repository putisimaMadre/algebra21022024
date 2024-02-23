package com.formatoweb.algebra2102024.controller;

import com.formatoweb.algebra2102024.service.TerminoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AlgebraController {
@Autowired
private TerminoService terminoService;
    @PostMapping("/terminos")
    public void separacionTerminos(@RequestBody String expresionAlgebraica){
        System.out.println("Signo: "+terminoService.getSigno(expresionAlgebraica));
        System.out.println("Coeficiente: "+terminoService.getCoeficiente(expresionAlgebraica));
        System.out.println("Literal: "+terminoService.getLiteral(expresionAlgebraica));
        System.out.println("Exponente: "+terminoService.getExponente(expresionAlgebraica));
        System.out.println("----------------------------------------------------------------------------");
    }
}
