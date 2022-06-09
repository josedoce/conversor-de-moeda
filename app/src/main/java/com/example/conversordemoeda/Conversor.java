package com.example.conversordemoeda;

public class Conversor {
    //cotação de 09/06/2022
    private final double VALOR_DOLAR = 4.90;
    private final double VALOR_REAL_EM_DOLAR = 1 / VALOR_DOLAR;

    public double realParaDolar(double real){
        return real * VALOR_REAL_EM_DOLAR;
    }

}
