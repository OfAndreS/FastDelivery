package com.fastdelivery.util;

public class ConsoleUI 
{

    public void printHead()
    {
        System.out.println("|  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
    }
    
    public String printEntregaFactoryVeiculo()
    {
        return "\n|\n| ESCOLHA:\n| Carro: ( 1 )\n| Moto: ( 2 ) ";
    }

    public String printEntregaFactoryEntregador()
    {
        return "\n|\n| ESCOLHA:\n| Funcionario: ( 1 )\n| Autonomo: ( 2 ) ";
    }

    public void printMensagemDeErro()
    {
        System.out.println("\n| INPUT INCORRETO!!! ");
    }

}
