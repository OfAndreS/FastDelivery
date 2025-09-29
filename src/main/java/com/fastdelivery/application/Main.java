package com.fastdelivery.application; 

import com.fastdelivery.factory.EntregaFactory;
import com.fastdelivery.service.Entrega;
import com.fastdelivery.util.ConsoleUI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public final Scanner scanner = new Scanner((System.in));
    public final ConsoleUI ui = new ConsoleUI(scanner);
    public ArrayList<Entrega> myEntregaArray;

    public void startMenu()
    {
        while (true) 
        {
            ui.printHead();
            System.out.println("| START MENU                                    ");
            System.out.println("|                                               ");
            System.out.println("| ( 1 ) - Criar Nova Entrega - Modo Interativo  ");
            System.out.println("| ( 2 ) - Criar Nova Entrega - Modo Automático  ");
            System.out.println("| ( 3 ) - Listar Todas as Entregas Cadastradas  ");
            System.out.println("| ( 4 ) - Calcular o Custo de todas as Entregas ");
            System.out.println("| ( 0 ) - Sair                                  ");
            System.out.println("|                                               ");
            System.out.println("| Escolha:                                      ");
    
            switch (scanner.nextLine()) 
            {
                case "1":
                    EntregaFactory myEntrega = new EntregaFactory(scanner, ui);
                    myEntregaArray.add(myEntrega.createNewEntrega());
                    break;
            
                default:
                    System.out.println("| Opção Incorreta!!!");
                    break;
            }

        }

    }
    public static void main(String[] args) 
    {
        Main newMain = new Main();
        newMain.startMenu();
    }
}