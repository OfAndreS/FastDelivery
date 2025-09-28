package com.fastdelivery.application; // <-- ADICIONE ESTA LINHA

import com.fastdelivery.factory.EntregadorFactory;
import com.fastdelivery.factory.VeiculoFactory;
import com.fastdelivery.model.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n| SISTEMA DE CRIAÇÃO FASTDELIVERY ");
            System.out.println("1 ) Criar objetos interativamente (pelo console)");
            System.out.println("2 ) Criar objetos de teste (pelo arquivo dados_teste.txt)");
            System.out.println("0 ) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = consoleScanner.nextInt();
            consoleScanner.nextLine(); 

            switch (opcao) {
                case 1:
                    modoInterativo(consoleScanner);
                    break;
                case 2:
                    modoAutomatizado();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
        
        consoleScanner.close();
    }

    public static void modoInterativo(Scanner scanner) {
        VeiculoFactory veiculoFactory = new VeiculoFactory(scanner);
        EntregadorFactory entregadorFactory = new EntregadorFactory(scanner);

        System.out.println("\n| MODO INTERATIVO ");
        Carro carro = veiculoFactory.createCarro();
        System.out.println("| >>> Carro criado com sucesso: " + carro.getModeloVeiculo());

        Funcionario func = entregadorFactory.createFuncionario();
        System.out.println("| >>> Funcionário criado com sucesso: " + func.getNomeFuncionario());
    }

    public static void modoAutomatizado() {
        System.out.println("\n| MODO AUTOMATIZADO ");
        System.out.println("| Lendo do arquivo 'dados_teste.txt'...");

        try (Scanner fileScanner = new Scanner(new File("dados_teste.txt"))) {
            VeiculoFactory veiculoFactory = new VeiculoFactory(fileScanner);
            EntregadorFactory entregadorFactory = new EntregadorFactory(fileScanner);

            List<Object> objetosCriados = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                String tipo = fileScanner.nextLine();
                if (tipo.isBlank()) continue; // Pular linhas em branco

                switch (tipo.toUpperCase()) {
                    case "CARRO":
                        Carro c = veiculoFactory.createCarro();
                        System.out.println(">>> [Arquivo] Carro criado: " + c.getModeloVeiculo() + " (" + c.getPlacaVeiculo() + ")");
                        objetosCriados.add(c);
                        break;
                    case "MOTO":
                        Moto m = veiculoFactory.createMoto();
                        System.out.println(">>> [Arquivo] Moto criada: " + m.getModeloVeiculo() + " (" + m.getPlacaVeiculo() + ")");
                        objetosCriados.add(m);
                        break;
                    case "FUNCIONARIO":
                        Funcionario f = entregadorFactory.createFuncionario();
                        System.out.println(">>> [Arquivo] Funcionário criado: " + f.getNomeFuncionario());
                        objetosCriados.add(f);
                        break;
                    case "AUTONOMO":
                        Autonomo a = entregadorFactory.createAutonomo();
                        System.out.println(">>> [Arquivo] Autônomo criado: " + a.getNomeFuncionario());
                        objetosCriados.add(a);
                        break;
                    default:
                        System.out.println("!!! Tipo desconhecido no arquivo: " + tipo);
                        break;
                }
            }
            System.out.println("\nLeitura do arquivo concluída. Total de " + objetosCriados.size() + " objetos criados.");

        } catch (FileNotFoundException e) {
            System.err.println("!!! ERRO: Arquivo 'dados_teste.txt' não encontrado na raiz do projeto.");
        }
    }
}