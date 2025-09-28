package com.fastdelivery.model;

public class Funcionario extends EntregadorAbstrato
{

    private static final double ENTREGADORVALUE = 5;

    public Funcionario(String nomeFuncionario, String cpfFuncionario)
    {
        super(nomeFuncionario, cpfFuncionario);
    }

    @Override
    public double custoDoFrete(double distanciaEmKm) 
    {
        return ENTREGADORVALUE;
    }

    public static double getEntregadorvalue() {
        return ENTREGADORVALUE;
    }
}
