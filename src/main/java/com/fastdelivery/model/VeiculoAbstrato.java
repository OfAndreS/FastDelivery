package com.fastdelivery.model;

public abstract class VeiculoAbstrato implements com.fastdelivery.interfaces.Custo 
{
    protected String modeloVeiculo;
    protected String placaVeiculo;
    protected String anoVeiculo;
    protected String corVeiculo;

    public VeiculoAbstrato(String modelo, String placa, String ano, String cor) 
    {
        this.modeloVeiculo = modelo;
        this.placaVeiculo = placa;
        this.anoVeiculo = ano;
        this.corVeiculo = cor;
    }

    public String getModeloVeiculo() {
        return this.modeloVeiculo;
    }

    public String getPlacaVeiculo() {
        return this.placaVeiculo;
    }

    public String getAnoVeiculo() {
        return this.anoVeiculo;
    }

    public String getCorVeiculo() {
        return this.corVeiculo;
    }
    
}