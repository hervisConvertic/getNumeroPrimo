package com.convertic.spring.demoweb;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/app")
public class DemoController {

    @PostMapping(value = "/notaFinal")
    public String getNotas(@RequestBody Notas notas){
        double notaDef;
         notaDef=notas.getNotaDefinitiva();
        System.out.println("se retorna prueba final");
        return "notafinal "+notaDef;
    }


    @GetMapping(value = "/saludar/{name}")
    public String helloWorld(@PathVariable String name) {

        return "hola soy estudiante convertic  ".concat(name);
    }


    @GetMapping(value = "/operacion")
    public ResponseEntity<RespuestaNumeroPrimo> getNumeroPrimo(@RequestParam String numero) {
        ResponseEntity responseEntity = null;
        RespuestaNumeroPrimo respuestaNumeroPrimo = null;

        try {
            NumeroPrimo numeroPrimo = new NumeroPrimo(numero);
            respuestaNumeroPrimo = new RespuestaNumeroPrimo(numeroPrimo.getNumero());
            responseEntity = ResponseEntity.status(HttpStatusCode.valueOf(200)).body(respuestaNumeroPrimo);

        } catch (ExcepcionCero e) {
            respuestaNumeroPrimo = new RespuestaNumeroPrimo(e.getMessage());
            responseEntity = ResponseEntity.status(HttpStatusCode.valueOf(500)).body(respuestaNumeroPrimo);
        } catch (ExcepcionDatoNumerico e) {
            respuestaNumeroPrimo = new RespuestaNumeroPrimo(e.getMessage());
            responseEntity = ResponseEntity.status(HttpStatusCode.valueOf(500)).body(respuestaNumeroPrimo);
        }
        return responseEntity;
    }
}
