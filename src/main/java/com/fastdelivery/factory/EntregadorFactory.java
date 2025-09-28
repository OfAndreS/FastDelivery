package com.fastdelivery.factory;

import com.fastdelivery.model.Autonomo;
import com.fastdelivery.model.Funcionario;
import java.util.Scanner;

public class EntregadorFactory {

    private final Scanner scanner;

    public EntregadorFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public Funcionario createFuncionario() {
        System.out.println("--- Criando Funcionário ---");
        System.out.println("| Digite - Nome do Funcionário:");
        String nome = scanner.nextLine();
        System.out.println("| Digite - CPF do Funcionário:");
        String cpf = scanner.nextLine();
        return new Funcionario(nome, cpf);
    }

    public Autonomo createAutonomo() {
        System.out.println("--- Criando Autônomo ---");
        System.out.println("| Digite - Nome do Autônomo:");
        String nome = scanner.nextLine();
        System.out.println("| Digite - CPF do Autônomo:");
        String cpf = scanner.nextLine();
        return new Autonomo(nome, cpf);
    }
}