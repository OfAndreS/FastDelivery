package com.fastdelivery.service;

import com.fastdelivery.factory.EntregadorFactory;
import com.fastdelivery.factory.VeiculoFactory;
import com.fastdelivery.model.EntregadorAbstrato;
import com.fastdelivery.model.VeiculoAbstrato;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ServicoEntrega {

    private final List<Entrega> entregas = new ArrayList<>();
    private final VeiculoFactory veiculoFactory;
    private final EntregadorFactory entregadorFactory;

    public ServicoEntrega(VeiculoFactory veiculoFactory, EntregadorFactory entregadorFactory) {
        this.veiculoFactory = veiculoFactory;
        this.entregadorFactory = entregadorFactory;
    }

    public void adicionarEntrega(Entrega entrega) {
        this.entregas.add(entrega);
    }

    public boolean nenhumaEntregaCadastrada() {
        return this.entregas.isEmpty();
    }

    public void criarEntregasModoAutomaticoFixo() 
    {
        System.out.println("| Iniciando criação de entregas com dados fixos...");
        try {
            VeiculoAbstrato carro1 = veiculoFactory.createFromData("CARRO", "Ford Ka", "FKT-2015", "2015", "Preto");
            EntregadorAbstrato func1 = entregadorFactory.createFromData("FUNCIONARIO", "Joao da Silva", "111.222.333-44");

            VeiculoAbstrato moto1 = veiculoFactory.createFromData("MOTO", "Honda Biz", "HDA-2022", "2022", "Vermelha");
            EntregadorAbstrato auto1 = entregadorFactory.createFromData("AUTONOMO", "Maria Souza", "555.666.777-88");

            VeiculoAbstrato carro2 = veiculoFactory.createFromData("CARRO", "Fiat Uno", "UNO-1998", "1998", "Branco");
            EntregadorAbstrato auto2 = entregadorFactory.createFromData("AUTONOMO", "Carlos Pereira", "888.777.666-55");

            adicionarEntrega(new Entrega(carro1, func1, 12.5));
            adicionarEntrega(new Entrega(moto1, auto1, 8.0));
            adicionarEntrega(new Entrega(carro2, auto2, 25.2));

            System.out.println("| 3 entregas de teste foram criadas com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("| ERRO ao criar dados de teste: " + e.getMessage());
        }
    }


    public void listarTodasAsEntregas() 
    {
        System.out.println("| LISTA DE ENTREGAS");
        System.out.println("| ");

        if (nenhumaEntregaCadastrada()) {
            System.out.println("| Nenhuma Entrega foi adicionada");
            return;
        }

        for (Entrega entrega : this.entregas) {
            System.out.println(
                "| Veiculo: " + entrega.getMyVeiculo().getModeloVeiculo() +
                " - Entregador: " + entrega.getMyEntregador().getNomeFuncionario() +
                " - ValorTotal: " + formatarMoeda(entrega.calcularCustoTotal())
            );
        }
    }

    public void calcularCustoTotalDasEntregas() {
        System.out.println("| CÁLCULO DO CUSTO TOTAL DAS ENTREGAS");

        if (nenhumaEntregaCadastrada()) {
            System.out.println("| Nenhuma entrega foi cadastrada ainda.");
            return;
        }

        double custoTotal = 0.0;
        for (Entrega entrega : this.entregas) {
            custoTotal += entrega.calcularCustoTotal();
        }

        System.out.println("|                                               ");
        System.out.println("| Total de entregas cadastradas: " + this.entregas.size());
        System.out.println("| O custo total de todas as entregas é: " + formatarMoeda(custoTotal));
        System.out.println("|                                               ");
    }

    private String formatarMoeda(double valor) {
        Locale ptBr = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(ptBr).format(valor);
    }
}