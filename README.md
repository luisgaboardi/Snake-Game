# Snake do Liverson Paulo Furtado Severo

Esse projeto funciona como um jogo Snake, porém com algumas modificações como novas cobras e frutas, com seus próprios atributos e particularidades.

tem as seguintes funcionalidades:

- Implementado as snakes **comum**,**kitty** e **star**
- Implementado a fruta simples, fruta bomb, fruta decrease, fruta big
- Implementado o mapa onde as snakes andam e a fruta nasce
- Implementado um botao que inicia ou pausa o jogo
- Implementado um menu de escolha das cobras


# Como Jogar

* **Opcoes**  Ha um menu de opcoes onde ha a possibilidade de escolher a cobra com a qual deseja jogar.
* **Comandos** E preciso apertar o botão de Start para poder começar o jogo, assim que começar o jogo as setas direcionais vão ser o que vai guiar a cobra.
* **Game Over** Quando ocorrer o Game Over, o jogo so funcionara novamente quando a janela for fechada e reaberta.

# EP2 - OO 2019.2 (UnB - Gama)

Turmas Renato e Carla
Data de entrega: 05/11/2019

## Descrição

Para este EP o objetivo será implementar o famoso jogo Snake (também conhecido como "jogo da cobrinha") é um jogo que ficou conhecido por diversas versões cuja versão inicial começou com o jogo Blockade de 1976, sendo feitas várias imitações em vídeo-games e computadores. No fim dos anos 90 foi popularizado em celulares da Nokia que vinham com o jogo já incluso.

O jogador controla uma longa e fina criatura que se arrasta pela tela, coletando comida (ou algum outro item), não podendo colidir com seu próprio corpo ou as "paredes" que cercam a área de jogo. Cada vez que a serpente come um pedaço de comida, seu rabo cresce, aumentando a dificuldade do jogo. O usuário controla a direção da cabeça da serpente (para cima, para baixo, esquerda e direita) e seu corpo segue.

Para este EP o jogo deve conter barreiras em seu cenário, além das especificações abaixo.

## Tipos de Snakes

Deve ser implementado ao menos 3 tipos de Snakes:
* **Comum:** A Snake classica, sem habilidades especiais, representa pela classica cor branca.
* **Kitty:** Essa Snake tem as habilidades de atravessar as barreiras do jogo, mas não pode atravessar as bordas nem a si mesma, representada pela cor rosa.
* **Star:** Recebe o dobro de pontos ao comer as frutas, representada pela cor amarela.

## Frutas

As frutas são elementos que aparecem aleatoriamente e são os objetivos das Snakes. As frutas devem desaparecer em um tempo especifico e não devem aparecer mais de duas frutas por vez. Devem ser implementados ao menos 4 tipos de frutas:

* **Simple Fruit:** Fruta comum, dá 1 ponto e aumenta o tamanho da cobra, representada pela cor verde.
* **Bomb Fruit:** Essa fruta deve levar a morte da Snake, representada pela cor vermelha.
* **Big Fruit:** Dá o dobro de pontos da Simple Fruit e aumenta o tamanho da cobra da mesma forma que a Simple Fruit, representada pela cor laranja.
* **Decrease Fruit:** Diminui o tamanho da cobra para o tamanho inicial, sem fornecer nem retirar pontos, representada pela cor azul.

## Pontos

Os pontos são calculados de acordo com as frutas coletadas.
