# Projeto de Geração de Grafo Aleatório e Varredura em Profundidade

Este projeto utiliza a biblioteca GraphStream em Java para gerar um grafo aleatório e realizar uma varredura em profundidade (DFS). A aplicação inclui uma visualização gráfica interativa que representa o percurso nos nós do grafo durante a execução da DFS.

## Estrutura do Projeto

- **Main.java:** Arquivo principal responsável por inicializar o grafo, executar a DFS a partir de um nó aleatório e exibir a visualização gráfica em tempo real.

- **DFS.java:** Classe que implementa o algoritmo de varredura em profundidade (DFS) e exibe informações sobre o caminho percorrido.

## Execução do Projeto

1. Certifique-se de ter o Java e a biblioteca GraphStream instalados no seu ambiente de desenvolvimento.

2. Execute o arquivo `Main.java`. Isso iniciará a geração de um grafo aleatório, a execução da DFS a partir de um nó escolhido aleatoriamente e a exibição gráfica interativa.

## Configurações e Customizações

- O número de nós e arestas do grafo é configurável no método `generateRandomGraph` em `Main.java`. Ajuste os parâmetros `numNodes` e `numEdges` conforme necessário.

## Observações

- A ocorrência de arestas rejeitadas durante a geração do grafo pode ocorrer devido à tentativa de adicionar arestas duplicadas. A implementação trata essa situação para garantir a integridade do grafo.

- O código inclui um loop infinito para permitir a rotação contínua da visualização. Caso deseje encerrar a aplicação, feche a janela da visualização gráfica.


