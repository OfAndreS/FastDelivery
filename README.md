<div align="center"\>
  <img width="1024" height="256" alt="FastDelivery" src="https://github.com/user-attachments/assets/c15ca463-4bd3-42aa-8a0b-67692502611d" />
</div>

<br>

-----

<div align="center"\>
  <strong>Um sistema de console em Java para gerenciamento de entregas.</strong\>
</div>

<br>
<br>

<div align="center">
  <img src="https://img.shields.io/github/license/OfAndreS/FastDelivery?style=for-the-badge" alt="Licença">
  <img src="https://img.shields.io/github/stars/OfAndreS/FastDelivery?style=for-the-badge" alt="Stars">
  <img src="https://img.shields.io/github/forks/OfAndreS/FastDelivery?style=for-the-badge" alt="Forks">
  <img src="https://img.shields.io/github/last-commit/OfAndreS/FastDelivery?style=for-the-badge" alt="Último Commit">
</div>

<br>

<p align="center">
  <a href="sobre-o-projeto">Sobre</a> •
  <a href="funcionalidades">Funcionalidades</a> •
  <a href="tecnologias">Tecnologias</a> •
  <a href="como-executar">Como Executar</a> •
  <a href="autor">Autor</a>
</p>

-----

<br>

|**Sobre o Projeto**|
|-|
|O FastDelivery é um sistema de console em Java para gerenciamento de entregas. Ele permite a criação de entregas, associando diferentes tipos de veículos e entregadores, e calcula o custo total com base na distância. O projeto utiliza o padrão de projeto Factory para a criação de veículos e entregadores, promovendo um código mais organizado e extensível.|

<div align="center"\>
<img width="1361" height="626" alt="image" src="https://github.com/user-attachments/assets/b770eb65-a6f0-411f-99e2-bd6fd0eec101" />
</div>

<br>

-----

<br>

| **Funcionalidades** |
|---|
| <p align="justify">  Criação de Entregas: <br> <br> - Permite a criação de novas entregas de forma interativa, selecionando o tipo de veículo e de entregador, e informando a distância. </p> |
| <p align="justify"> Cálculo de Custo: <br> <br> - Calcula o custo de cada entrega com base no tipo de veículo e no tipo de entregador, além da distância percorrida. </p> |
| <p align="justify"> Listagem de Entregas: <br> <br> - Exibe uma lista de todas as entregas cadastradas, com detalhes sobre o veículo, o entregador e o valor total. </p> |
| <p align="justify"> Modo de Teste: <br> <br> - Oferece um modo automático para a criação de entregas com dados fixos, facilitando a demonstração e o teste do sistema. </p> |
| <p align="justify"> Interface de Console: <br> <br> - Interage com o usuário através de um menu de console simples e intuitivo. </p> |

<br>

-----

<br>

## **Estrutura do Projeto**</p> 
<br>

```bash
FastDelivery/
└── src/
    └── com/
        └── fastdelivery/
            ├── application/
            │   └── Main.java               # Classe principal, inicia a aplicação e o menu.
            ├── factory/
            │   ├── EntregaFactory.java     # Cria novas instâncias de Entrega.
            │   ├── EntregadorFactory.java  # Cria entregadores (Funcionário ou Autônomo).
            │   └── VeiculoFactory.java     # Cria veículos (Carro ou Moto).
            ├── interfaces/
            │   └── Custo.java              # Interface que define o método para calcular o frete.
            ├── model/
            │   ├── Autonomo.java           # Modelo para o entregador autônomo.
            │   ├── Carro.java              # Modelo para o veículo carro.
            │   ├── EntregadorAbstrato.java # Classe base para os tipos de entregadores.
            │   ├── Funcionario.java        # Modelo para o entregador funcionário.
            │   ├── Moto.java               # Modelo para o veículo moto.
            │   └── VeiculoAbstrato.java    # Classe base para os tipos de veículos.
            ├── service/
            │   ├── Entrega.java            # Representa uma entrega individual com veículo, entregador e distância.
            │   └── ServicoEntrega.java     # Gerencia a lista de entregas e os cálculos de custo total.
            └── util/
                ├── AppConfig.java          # Armazena constantes e configurações da aplicação.
                └── ConsoleUI.java          # Controla a interface do usuário no console.
```

<br>

## **Tecnologias**

<br>

| Ferramenta | Descrição |
|-----------|----------------------------------------------------------------|
| **Java** | Linguagem de programação principal utilizada para toda a lógica do sistema. |

<br>

## **Como Executar**

<br>

Para ter uma cópia local deste projeto e executá-lo, siga os passos abaixo.

<details>
  <summary><strong>Pré-requisitos</strong></summary>
  
  - Você vai precisar do Java Development Kit (JDK) instalado na sua máquina.
  - Você vai precisar do Git instalado na sua máquina para clonar o repositório.
  - É bom ter um editor de texto como o VS Code ou uma IDE como IntelliJ ou Eclipse.

</details>

<details>
  <summary><strong>Rodando a Aplicação</strong></summary>

<br>

1 ) **Clone o repositório:**

```bash
git clone [https://github.com/OfAndreS/FastDelivery.git](https://github.com/OfAndreS/FastDelivery.git)
````

2 ) **Navegue até o diretório `src` do projeto:**

```bash
cd FastDelivery/FastDelivery-main/src
```

3 ) **Compile todos os arquivos Java a partir do diretório `src`:**

```bash
# Para sistemas baseados em Unix (Linux, macOS)
javac $(find . -name "*.java")

# Para Windows (PowerShell)
javac (Get-ChildItem -Recurse -Filter *.java).FullName
```

4 ) **Execute a classe principal a partir do diretório `src`:**

```bash
java com.fastdelivery.application.Main
```

</details>
