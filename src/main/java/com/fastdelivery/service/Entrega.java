package com.fastdelivery.service;

import com.fastdelivery.model.VeiculoAbstrato;

import java.util.ArrayList;

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

    public void listarTodasAsEntregas(ArrayList<Entrega> myEntregaArray)
    {
        System.out.println("| LISTA DE ENTREGAS");
        System.out.println("| ");

        if( myEntregaArray.isEmpty())
        {
            System.out.println("| ERRO - Nenhuma Entrega foi adicionada");
            return;
        }

        for(Entrega myEntrega : myEntregaArray)
        {
            System.out.println("| Veiculo: " + myEntrega.myVeiculo.getModeloVeiculo() + " - Entregador: " + myEntrega.myEntregador.getNomeFuncionario() + " - ValorTotal: " + myEntrega.calcularCustoTotal() );
        }
    }

    
}
