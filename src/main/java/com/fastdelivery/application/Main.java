package com.fastdelivery.application; // <-- ADICIONE ESTA LINHA

import com.fastdelivery.model.EntregadorAbstrato;
import com.fastdelivery.model.VeiculoAbstrato;
import com.fastdelivery.util.ConsoleUI;
import com.fastdelivery.factory.EntregaFactory;
import com.fastdelivery.model.Carro;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner((System.in));
        ConsoleUI ui = new ConsoleUI(scanner);

        EntregaFactory myEntrega = new EntregaFactory(scanner, ui);

        myEntrega.createNewEntrega();
    
    }
}