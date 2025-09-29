package com.fastdelivery.factory;

import java.util.Scanner;

import com.fastdelivery.model.EntregadorAbstrato;
import com.fastdelivery.model.VeiculoAbstrato;
import com.fastdelivery.service.Entrega;
import com.fastdelivery.util.ConsoleUI;
import com.fastdelivery.util.AppConfig;

public class EntregaFactory {

    private final Scanner scanner;
    private final ConsoleUI ui;
    private final VeiculoFactory veiculoFactory;
    private final EntregadorFactory entregadorFactory;

    public EntregaFactory(Scanner scanner, ConsoleUI ui) 
    {
        this.scanner = scanner;
        this.ui = ui;
        this.veiculoFactory = new VeiculoFactory(scanner);
        this.entregadorFactory = new EntregadorFactory(scanner);
    }

    public Entrega createNewEntrega() 
    {
        System.out.println("| CRIANDO UMA NOVA ENTREGA");
        ui.printHead();

        // Criando Veiculo
        System.out.println("| Selecione o tipo de veículo:");
        int indiceVeiculo = ui.selector(AppConfig.TIPOS_DE_VEICULO);
        String tipoVeiculo = AppConfig.TIPOS_DE_VEICULO.get(indiceVeiculo);
        
        VeiculoAbstrato myVeiculo = veiculoFactory.create(tipoVeiculo);

        ui.printHead();

        // Criando Entregador
        System.out.println("| Selecione o tipo de entregador:");
        int indiceEntregador = ui.selector(AppConfig.TIPOS_DE_ENTREGADOR);
        String tipoEntregador = AppConfig.TIPOS_DE_ENTREGADOR.get(indiceEntregador);

        EntregadorAbstrato myEntregador = entregadorFactory.create(tipoEntregador);
        
        ui.printHead();

        // Dados Restantes
        System.out.print("| Digite a Distância da Entrega em Km: ");
        double distanciaEmKm = scanner.nextDouble(); scanner.nextLine(); 
        System.out.println("| Entrega criada com sucesso!");
        
        return new Entrega(myVeiculo, myEntregador, distanciaEmKm);
    }

    
}