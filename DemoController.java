package com.convertic.spring.demoweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class DemoController {
    @GetMapping(value = "/saludar")
    public String helloWorld(@RequestParam String name) {

        return "hola soy estudiante convertic  ".concat(name);
    }

    @GetMapping(value = "/operacion")
    public String getNumeroPrimo(@RequestParam String numero) {
        int  cont = 0;
        for (int i = 1; i <= Integer.parseInt(numero); i++) {
            if (Integer.parseInt(numero) % i == 0) {
                cont = cont + 1;
            }
        }
        if (cont != 2) {
            return "numero no es primo";
        }else{
            return "numero es primo";
        }
    }
}
