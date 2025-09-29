package com.fastdelivery.service;

import com.fastdelivery.model.VeiculoAbstrato;
import com.fastdelivery.model.EntregadorAbstrato;

public class Entrega 
{
    private final VeiculoAbstrato myVeiculo;
    private final EntregadorAbstrato myEntregador;
    private final double distanciaEmKm;
    private double valorTotalDaEntrega;

    public Entrega(VeiculoAbstrato myVeiculo, EntregadorAbstrato myEntregador, double distanciaEmKm) 
    {
        this.myVeiculo = myVeiculo;
        this.myEntregador = myEntregador;
        this.distanciaEmKm = distanciaEmKm;
    }

    public double calcularCustoTotal() 
    {
        this.valorTotalDaEntrega = myVeiculo.custoDoFrete(distanciaEmKm) + myEntregador.custoDoFrete(distanciaEmKm);
        return valorTotalDaEntrega;
    }


    public VeiculoAbstrato getMyVeiculo() 
    {
        return myVeiculo;
    }

    public EntregadorAbstrato getMyEntregador() 
    {
        return myEntregador;
    }

}