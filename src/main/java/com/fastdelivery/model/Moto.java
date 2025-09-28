package com.fastdelivery.model;

public class Moto extends VeiculoAbstrato 
{
    private static final double MOTOVALUE = 0.45;

    public Moto(String modeloVeiculo, String placaVeiculo, String anoVeiculo, String corVeiculo)
    {
        super(modeloVeiculo, placaVeiculo, anoVeiculo, corVeiculo);
    }

    @Override
    public double custoDoFrete(double distanciaEmKm)
    {

        return MOTOVALUE * distanciaEmKm;
    }    

    public static double getMotovalue() {
        return MOTOVALUE;
    }

}
