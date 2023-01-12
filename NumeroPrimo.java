package com.convertic.spring.demoweb;

public class NumeroPrimo {
    private String numero;

    public NumeroPrimo(String numero) {
        this.numero = numero;
    }

    public String getNumero() throws ExcepcionCero, ExcepcionDatoNumerico {
        for (int i = 0; i < numero.length(); i++) {
            if (!(numero.charAt(i) >= '0' && numero.charAt(i) <= '9')) {
                throw new ExcepcionDatoNumerico();
            } else if (0 == Integer.parseInt(numero)) {
                throw new ExcepcionCero();
            } else {
                int cont = 0;
                for (int j = 1; j <= Integer.parseInt(numero); j++) {
                    if (Integer.parseInt(numero) % j == 0) {
                        cont = cont + 1;
                    }
                }
                if (cont != 2) {
                    return "numero no es primo";
                } else {
                    if(Integer.parseInt(numero)==2){
                        return "numero es primo y par";
                    }
                    return "numero es primo";
                }
            }
        }
        return null;
    }
}
