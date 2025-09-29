package com.fastdelivery.factory;

import com.fastdelivery.model.Autonomo;
import com.fastdelivery.model.EntregadorAbstrato; // Importe a classe abstrata
import com.fastdelivery.model.Funcionario;
import java.util.Scanner;

public class EntregadorFactory {

    private final Scanner scanner;

    public EntregadorFactory(Scanner scanner) 
    {
        this.scanner = scanner;
    }

    public EntregadorAbstrato create(String tipoEntregador) 
    {
        switch (tipoEntregador) 
        {
            case "FUNCIONARIO":
                return createFuncionario();
            case "AUTONOMO":
                return createAutonomo();
            default:
                throw new IllegalArgumentException("Tipo de entregador desconhecido: " + tipoEntregador);
        }
    }

    public EntregadorAbstrato createFromData(String tipoEntregador, String nome, String cpf) 
    {
        switch (tipoEntregador) 
        {
            case "FUNCIONARIO":
                return new Funcionario(nome, cpf);
            case "AUTONOMO":
                return new Autonomo(nome, cpf);
            default:
                throw new IllegalArgumentException("Tipo de entregador desconhecido: " + tipoEntregador);
        }
    }

    private Funcionario createFuncionario() 
    {
        System.out.println("| CRIANDO FUNCIONÁRIO          ");
        System.out.println("|                              ");
        System.out.print("| Digite - Nome do Funcionário:  ");
        String nome = scanner.nextLine();
        System.out.print("| Digite - CPF do Funcionário:   ");
        String cpf = scanner.nextLine();
        return new Funcionario(nome, cpf);
    }

    private Autonomo createAutonomo() 
    {
        System.out.println("| CRIANDO AUTÔNOMO          ");
        System.out.println("|                           ");
        System.out.print("| Digite - Nome do Autônomo:  ");
        String nome = scanner.nextLine();
        System.out.print("| Digite - CPF do Autônomo:   ");
        String cpf = scanner.nextLine();
        return new Autonomo(nome, cpf);
    }
}