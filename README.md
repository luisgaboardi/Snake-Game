# Snake da Luís

## Descrição

Este pequeno projeto tem como ojetivo a implementação do famoso jogo Snake (também conhecido como "jogo da cobrinha"), um jogo que ficou conhecido por diversas versões cuja versão inicial começou com o jogo Blockade de 1976, sendo feitas várias imitações em vídeo-games e computadores. No fim dos anos 90 foi popularizado em celulares da Nokia que vinham com o jogo já incluso.

O jogador controla uma longa e fina criatura que se arrasta pela tela, coletando comida (ou algum outro item), não podendo colidir com seu próprio corpo ou as "paredes" que cercam a área de jogo. Cada vez que a serpente come um pedaço de comida, seu rabo cresce, aumentando a dificuldade do jogo. O usuário controla a direção da cabeça da serpente (para cima, para baixo, esquerda e direita) e seu corpo segue.


# Ambiente Desenvolvido

Ubuntu 16.04 LTS

openjdk version "1.8.0_222"
OpenJDK Runtime Environment (build 1.8.0_222-8u222-b10-1ubuntu1~16.04.1-b10)
OpenJDK Server VM (build 25.222-b10, mixed mode)

# Execução

`java -jar bin/Snake.jar`

# Como jogar

## Antes de iniciar

- No canto superior esquerdo da tela, tem um botão que permite escolher o tipo da cobra que você deseja usar    
- No centro inferior da tela, tem um spinner que define a velocidade do jogo. Quando mais rápido, maior pontuação por fruta.

## Iniciar jogo

- Após escolher sua cobra e a velocidade, clique no botão "JOGAR" no canto inferior esquerdo

## Tipos de Snakes

Estão implementados 3 tipos de Snakes:
* **Comum:** A Snake classica, sem habilidades especiais.
* **Kitty:** Essa Snake tem as habilidades de atravessar as barreiras do jogo, mas não pode atravessar as bordas e nem a si mesma.
* **Star:** Recebe o dobro de pontos ao comer as frutas.

## Tipos de Frutas

As frutas são elementos que aparecem aleatoriamente e são os objetivos das Snakes. As frutas devem desaparecer em um tempo especifico e não devem aparecer mais de duas frutas por vez. Foram implementados 4 tipos de frutas:

* **Simple Fruit:** Fruta comum, dá um ponto e aumenta o tamanho da cobra.
* **Bomb Fruit:** Essa fruta deve levar a morte da Snake.
* **Big Fruit:** Dá o dobro de pontos da Simple Fruit e aumenta o tamanho da cobra da mesma forma que a Simple Fruit.
* **Decrease Fruit:** Diminui o tamanho da cobra para o tamanho inicial, sem fornecer nem retirar pontos.
