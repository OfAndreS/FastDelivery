package com.fastdelivery.factory;

import com.fastdelivery.model.Carro;
import com.fastdelivery.model.Moto;
import com.fastdelivery.model.VeiculoAbstrato; // Importe a classe abstrata
import java.util.Scanner;

public class VeiculoFactory {

    private final Scanner scanner;

    public VeiculoFactory(Scanner scanner) 
    {
        this.scanner = scanner;
    }

    public VeiculoAbstrato create(String tipoVeiculo) 
    {
        switch (tipoVeiculo) 
        {
            case "CARRO":
                return createCarro();
            case "MOTO":
                return createMoto();
            default:
                throw new IllegalArgumentException("Tipo de veículo desconhecido: " + tipoVeiculo);
        }
    }
    
    public VeiculoAbstrato createFromData(String tipoVeiculo, String modelo, String placa, String ano, String cor) {
        switch (tipoVeiculo) {
            case "CARRO":
                return new Carro(modelo, placa, ano, cor);
            case "MOTO":
                return new Moto(modelo, placa, ano, cor);
            default:
                throw new IllegalArgumentException("Tipo de veículo desconhecido: " + tipoVeiculo);
        }
    }

    private Carro createCarro() 
    {
        System.out.println("| CRIANDO CARRO");
        System.out.print("| Digite - Modelo do Veiculo:  ");
        String modeloVeiculo = scanner.nextLine();
        System.out.print("| Digite - Placa do Veiculo:   ");
        String placaVeiculo = scanner.nextLine();
        System.out.print("| Digite - Ano do Veiculo:     ");
        String anoVeiculo = scanner.nextLine();
        System.out.print("| Digite - Cor do Veiculo:     ");
        String corVeiculo = scanner.nextLine();

        return new Carro(modeloVeiculo, placaVeiculo, anoVeiculo, corVeiculo);
    }

    private Moto createMoto() 
    {
        System.out.println("--- Criando Moto ---");
        System.out.print("| Digite - Modelo do Veiculo: ");
        String modeloVeiculo = scanner.nextLine();
        System.out.print("| Digite - Placa do Veiculo:  ");
        String placaVeiculo = scanner.nextLine();
        System.out.print("| Digite - Ano do Veiculo:    ");
        String anoVeiculo = scanner.nextLine();
        System.out.print("| Digite - Cor do Veiculo:    ");
        String corVeiculo = scanner.nextLine();

        return new Moto(modeloVeiculo, placaVeiculo, anoVeiculo, corVeiculo);
    }
}