# README do Projeto MoonExplorer3

# Componentes: Davi Gomes Pinto Coelho, Ian Quadrio Raposo Branco Nunes, João Vitor Alves de Souza
# Data: 25/10/2023
# Disciplina: Programação Modular

## Visão Geral

O projeto MoonExplorer é um jogo de exploração lunar por equipes de robôs em busca de Hélio-3. Este repositório contém os seguintes módulos:

1. `MoonExplorer3.java`: O arquivo principal que inicia a simulação do jogo.
2. `Celula.java`: Responsável pelas informações individuais de cada célula.
3. `Mapa.java`: Implementação do mapa como uma matriz de células.
4. `Robo.java`: A classe que representa os robôs.
5. `Equipes.java`: Módulo que gerencia equipes como uma matriz de robos.
6. `Tempo.java`: Contador de tempo da simulação.
7. `entrada.json`: Arquivo de configuração para inicialização dos módulos.

# Dependencias:

Depende da biblioteca gson para leitura do arquivo .json.
Disponível em: https://github.com/google/gson.


## Como Executar

Certifique-se de que você possui o Java instalado no seu sistema. Para executar o projeto:

1. Clone este repositório em sua máquina local.
2. Abra um terminal na pasta raiz do projeto.
3. Compile o código Java usando o comando: `javac MoonExplorer3.java`.
4. Execute o programa com o comando: `java MoonExplorer3`.

## Configuração

O arquivo `entrada.json` contém as configurações do jogo, como o número de equipes, o tamanho do mapa lunar e informações de cada célula.

## Módulos

### MoonExplorer3.java

Este é módulo principal. Ele lê as configurações do arquivo `entrada.json` e inicia o jogo.
Recebe os comandos a partir do terminal e determina o vencedor com maior quantidade de H3 ao fim dos 5 minutos estabelecidos para a duração do jogo.

### Celula.java

Este módulo possui os atributos fundamentais para o funcionamento do jogo. É responsável por administrar os valores registrados em cada célula, antes e depois das ações do robo.

### Mapa.java

Este módulo implementa o mapa de células. Ele permite a navegação entre as diferentes posições de células em uma distribuição quadrada determinada pelo LIMITE_DO_MAPA, definida
no arquivo de entrada.

### Equipes.java

Gerencia equipes de robôs como um array, determina o vencedor com base na quantidade de Hélio-3 coletada e insere robôs nas equipes.

### Robo.java

A classe que representa os robôs. Ela contém métodos de comandos de movimentação (verificando os limites do mapa ou a existência de robos na célula destino), sondagem e sensoriamento.

Os movimentos possíveis são:
0 -> Posição atual.
1 -> Concentração de H3 na célula atual.
2 -> Rugosidade da célula atual.             
3 -> Tempo de jogo atual.
4 -> Andar para frente.
5 -> Girar para direita.
6 -> Girar para esquerda.            
7 -> Sondar e extrair o H3.

### Tempo.java

Módulo responsável pela administração do tempo de jogo e ações de cada robo.


