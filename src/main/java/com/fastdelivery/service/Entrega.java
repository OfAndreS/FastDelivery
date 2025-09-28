package com.fastdelivery.service;

import com.fastdelivery.model.VeiculoAbstrato;
import com.fastdelivery.model.EntregadorAbstrato;

public class Entrega 
{
    private VeiculoAbstrato myVeiculo;
    private EntregadorAbstrato myEntregador;
    private double distanciaEmKm;
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

    
}
