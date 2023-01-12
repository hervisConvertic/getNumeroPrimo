package com.convertic.spring.demoweb;

public class ExcepcionDatoNumerico extends Exception {
    public ExcepcionDatoNumerico() {
        super("SOLO SE PERMITE INGRESAR NUMEROS");
    }
}
