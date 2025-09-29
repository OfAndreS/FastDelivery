package com.fastdelivery.application;

import com.fastdelivery.factory.EntregaFactory;
import com.fastdelivery.factory.EntregadorFactory;
import com.fastdelivery.factory.VeiculoFactory;
import com.fastdelivery.model.EntregadorAbstrato;
import com.fastdelivery.model.VeiculoAbstrato;
import com.fastdelivery.service.Entrega;
import com.fastdelivery.util.ConsoleUI;   

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleUI ui = new ConsoleUI(scanner);
    private final ArrayList<Entrega> myEntregaArray = new ArrayList<>();
    private final VeiculoFactory veiculoFactory = new VeiculoFactory(scanner);
    private final EntregadorFactory entregadorFactory = new EntregadorFactory(scanner);

    private void criarEntregasModoAutomaticoFixo() {
        System.out.println("| Iniciando criação de entregas com dados fixos...");

        try {
            VeiculoAbstrato carro1 = veiculoFactory.createFromData("CARRO", "Ford Ka", "FKT-2015", "2015", "Preto");
            EntregadorAbstrato func1 = entregadorFactory.createFromData("FUNCIONARIO", "Joao da Silva", "111.222.333-44");

            VeiculoAbstrato moto1 = veiculoFactory.createFromData("MOTO", "Honda Biz", "HDA-2022", "2022", "Vermelha");
            EntregadorAbstrato auto1 = entregadorFactory.createFromData("AUTONOMO", "Maria Souza", "555.666.777-88");

            VeiculoAbstrato carro2 = veiculoFactory.createFromData("CARRO", "Fiat Uno", "UNO-1998", "1998", "Branco");
            EntregadorAbstrato auto2 = entregadorFactory.createFromData("AUTONOMO", "Carlos Pereira", "888.777.666-55");

            myEntregaArray.add(new Entrega(carro1, func1, 12.5)); // Distância de 12.5 km
            myEntregaArray.add(new Entrega(moto1, auto1, 8.0));   // Distância de 8.0 km
            myEntregaArray.add(new Entrega(carro2, auto2, 25.2)); // Distância de 25.2 km

            System.out.println("| 3 entregas de teste foram criadas com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("| ERRO ao criar dados de teste: " + e.getMessage());
        }
    }

    private void calcularCustoTotalDasEntregas() {
        ui.printHead();
        System.out.println("| CÁLCULO DO CUSTO TOTAL DAS ENTREGAS");

        if (myEntregaArray.isEmpty()) 
        {
            System.out.println("| Nenhuma entrega foi cadastrada ainda.");
            return; 
        }

        double custoTotal = 0.0;

        for (Entrega entrega : myEntregaArray) 
        {
            custoTotal += entrega.calcularCustoTotal();
        }

        Locale ptBr = new Locale("pt", "BR");
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(ptBr);

        System.out.println("|                                               ");
        System.out.println("| Total de entregas cadastradas: " + myEntregaArray.size());
        System.out.println("| O custo total de todas as entregas é: " + formatoMoeda.format(custoTotal));
        System.out.println("|                                               ");
    }

    public void startMenu() {
        while (true) {
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

            switch (scanner.nextLine()) {
                case "1":
                    EntregaFactory entregaFactory = new EntregaFactory(scanner, ui);
                    myEntregaArray.add(entregaFactory.createNewEntrega());
                    break;
                case "2":
                    criarEntregasModoAutomaticoFixo();
                    break;
                case "3":
                    ui.printHead();
                    if (myEntregaArray.isEmpty()) 
                    {
                        System.out.println("| Nenhuma entrega cadastrada ainda.");
                    } else {
                        new Entrega(null, null, 0).listarTodasAsEntregas(myEntregaArray);
                    }
                    break;
                case "4":
                    calcularCustoTotalDasEntregas();
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