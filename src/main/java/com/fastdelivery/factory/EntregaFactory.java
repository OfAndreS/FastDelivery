package com.fastdelivery.factory;

import java.util.Scanner;

import com.fastdelivery.model.Carro;
import com.fastdelivery.model.Funcionario;
import com.fastdelivery.service.Entrega;
import com.fastdelivery.util.ConsoleUI;

public class EntregaFactory 
{
        private final Scanner scanner;
        private final ConsoleUI ui;

        public EntregaFactory(Scanner scanner, ConsoleUI ui)
        {
            this.scanner = scanner;
            this.ui = ui;
        }

        public int EntregaFactoryMenu(String str)
        {
            System.out.println(str);

            String userInput = scanner.nextLine();

            while (true) 
            {
                switch (userInput) 
                {
                    case "1":
                        return 1;

                    case "2":
                        return 2;

                    default:
                        ui.printMensagemDeErro();
                        break;
                }    
            }
        }

        public Entrega modoInterativo() 
        {
            VeiculoFactory veiculoFactory = new VeiculoFactory(scanner);
            EntregadorFactory entregadorFactory = new EntregadorFactory(scanner);

            int veiculoResult = this.EntregaFactoryMenu(ui.printEntregaFactoryVeiculo());
            int entregadorResult = this.EntregaFactoryMenu(ui.printEntregaFactoryEntregador());

            // Criando um Veiculo
            if (veiculoResult == 1)
            {
                veiculoFactory.createCarro();
            }
            else if (veiculoResult == 2) 
            {
                veiculoFactory.createMoto();
            }

            // Criando um Entregador
            if (veiculoResult == 1)
            {
                veiculoFactory.createCarro();
            }
            else if (veiculoResult == 2) 
            {
                veiculoFactory.createMoto();
            }

            Entrega myEntrega = new Entrega(veiculoFactory, entregadorFactory, entregadorResult);

            return myEntrega;
            
        }
}
