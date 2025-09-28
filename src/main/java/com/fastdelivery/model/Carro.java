package com.fastdelivery.model;

public class Carro extends VeiculoAbstrato
{
    private static final double CARROVALUE = 1.25;

    public Carro(String modeloVeiculo, String placaVeiculo, String anoVeiculo, String corVeiculo)
    {
        super(modeloVeiculo, placaVeiculo, anoVeiculo, corVeiculo);
    }

    @Override
    public double custoDoFrete(double distanciaEmKm)
    {
        return CARROVALUE * distanciaEmKm;
    }

    public static double getCarrovalue() {
        return CARROVALUE;
    }   
    
}
