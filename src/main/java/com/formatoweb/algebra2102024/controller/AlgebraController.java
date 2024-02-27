package com.formatoweb.algebra2102024.controller;

import com.formatoweb.algebra2102024.service.TerminoService;
import com.formatoweb.algebra2102024.tools.Termino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AlgebraController {
@Autowired
private TerminoService terminoService;
    @PostMapping("/terminos")
    public Map<String, Object> separacionTerminos(@RequestBody String expresionAlgebraica){
        System.out.println("que tal");
        return terminoService.separacionElementos(expresionAlgebraica);
    }
}
