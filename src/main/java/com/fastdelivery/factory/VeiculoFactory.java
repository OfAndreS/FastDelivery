package com.fastdelivery.factory;

import com.fastdelivery.model.Carro;
import com.fastdelivery.model.Moto;
import java.util.Scanner;

public class VeiculoFactory {

    private final Scanner scanner;

    public VeiculoFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public Carro createCarro() {
        System.out.println("--- Criando Carro ---");
        System.out.println("| Digite - Modelo do Veiculo:");
        String modeloVeiculo = scanner.nextLine();
        System.out.println("| Digite - Placa do Veiculo:");
        String placaVeiculo = scanner.nextLine();
        System.out.println("| Digite - Ano do Veiculo:");
        String anoVeiculo = scanner.nextLine();
        System.out.println("| Digite - Cor do Veiculo:");
        String corVeiculo = scanner.nextLine();
        return new Carro(modeloVeiculo, placaVeiculo, anoVeiculo, corVeiculo);
    }

    public Moto createMoto() {
        System.out.println("--- Criando Moto ---");
        System.out.println("| Digite - Modelo do Veiculo:");
        String modeloVeiculo = scanner.nextLine();
        System.out.println("| Digite - Placa do Veiculo:");
        String placaVeiculo = scanner.nextLine();
        System.out.println("| Digite - Ano do Veiculo:");
        String anoVeiculo = scanner.nextLine();
        System.out.println("| Digite - Cor do Veiculo:");
        String corVeiculo = scanner.nextLine();
        return new Moto(modeloVeiculo, placaVeiculo, anoVeiculo, corVeiculo);
    }

    
}