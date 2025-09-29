package com.fastdelivery.application; // <-- ADICIONE ESTA LINHA

import com.fastdelivery.factory.EntregadorFactory;
import com.fastdelivery.factory.VeiculoFactory;
import com.fastdelivery.service.Entrega;
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
}