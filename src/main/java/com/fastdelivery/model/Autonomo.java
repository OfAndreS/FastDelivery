package com.fastdelivery.model;

public class Autonomo extends EntregadorAbstrato
{
    private static final double AUTONOMOVALUE = 0.95;

    public Autonomo(String nomeFuncionario, String cpfFuncionario)
    {
        super(nomeFuncionario, cpfFuncionario);
    }

    @Override
    public double custoDoFrete(double distanciaEmKm) 
    {
        return distanciaEmKm * AUTONOMOVALUE;
    }

    public static double getAutonomovalue() {
        return AUTONOMOVALUE;
    }
}
