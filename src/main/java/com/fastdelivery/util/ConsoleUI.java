package com.fastdelivery.util;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printHead() {
        System.out.println("|  * * * * * * * * * * * * * * *");
    }

    public int selector(List<String> myObjList) 
    {
        while (true) 
        {
            for (int i = 0; i < myObjList.size(); i++) 
            {
                System.out.println("| [ " + i + " ] - " + myObjList.get(i));
            }

            try {
                System.out.print("| Escolha: ");
                int userInput = scanner.nextInt(); scanner.nextLine(); 

                if (userInput >= 0 && userInput < myObjList.size()) 
                {
                    return userInput; 
                } else 
                {
                    System.out.println("| Opção inválida! Tente novamente.");
                }

            } 
            catch (InputMismatchException e) 
            {
                System.out.println("| A entrada deve ser um número inteiro! Tente novamente.");
                scanner.nextLine(); 
            }
        }
    }
    
}