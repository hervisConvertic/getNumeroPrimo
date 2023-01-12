package com.convertic.spring.demoweb;

public class ExcepcionCero extends Exception{
    public ExcepcionCero() {
        super("NUMERO CERO NO PERMITIDO");
    }
}
