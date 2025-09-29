package com.fastdelivery.application;

import com.fastdelivery.factory.EntregaFactory;
import com.fastdelivery.factory.EntregadorFactory;
import com.fastdelivery.factory.VeiculoFactory;
import com.fastdelivery.service.Entrega;
import com.fastdelivery.service.ServicoEntrega; 
import com.fastdelivery.util.ConsoleUI;
import java.util.Scanner;

public class Main 
{
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleUI ui = new ConsoleUI(scanner);
    private final ServicoEntrega servicoEntrega; 

    public Main() 
    {
        VeiculoFactory veiculoFactory = new VeiculoFactory(scanner);
        EntregadorFactory entregadorFactory = new EntregadorFactory(scanner);
        this.servicoEntrega = new ServicoEntrega(veiculoFactory, entregadorFactory);
    }

    public void startMenu() 
    {
        ui.printHead();
        ConsoleUI.printFastDeliveryAscii();
        System.out.println("| Made By: André Soares Gomes Moreira");

        while (true) 
        {
            ui.printHead();
            System.out.println("| START MENU                                         ");
            System.out.println("|                                                    ");
            System.out.println("| ( 1 ) - Criar Nova Entrega - Modo Interativo       ");
            System.out.println("| ( 2 ) - Criar Entregas de Teste - Modo Automático  ");
            System.out.println("| ( 3 ) - Listar Todas as Entregas Cadastradas       ");
            System.out.println("| ( 4 ) - Calcular o Custo de Todas as Entregas      ");
            System.out.println("| ( 0 ) - Sair                                       ");
            System.out.println("|                                                    ");
            System.out.print("| Escolha: ");

            switch (scanner.nextLine()) 
            {
                case "1":
                    EntregaFactory entregaFactory = new EntregaFactory(scanner, ui);
                    Entrega novaEntrega = entregaFactory.createNewEntrega();
                    servicoEntrega.adicionarEntrega(novaEntrega);
                    break;
                case "2":
                    servicoEntrega.criarEntregasModoAutomaticoFixo();
                    break;
                case "3":
                    ui.printHead();
                    servicoEntrega.listarTodasAsEntregas();
                    break;
                case "4":
                    ui.printHead();
                    servicoEntrega.calcularCustoTotalDasEntregas();
                    break;
                case "0":
                    System.out.println("| Saindo do sistema...");
                    return;
                default:
                    System.out.println("| Opção Incorreta!!!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Main newMain = new Main();
        newMain.startMenu();
    }
}