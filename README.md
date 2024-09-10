## SemideusApp - Sistema de Gestão de Missões do Acampamento Meio-Sangue

SemideusApp é uma aplicação simples desenvolvida como parte de uma avaliação acadêmica na universidade. Inspirado no universo de Percy Jackson, este projeto simula a vida de um semideus, oferecendo funcionalidades como gestão de missões, compra de itens em uma loja, e acompanhamento do progresso no acampamento.

Objetivo do Projeto
O objetivo do projeto é simular a experiência de semideuses no Acampamento Meio-Sangue, onde eles podem realizar missões, comprar itens e gerenciar seu perfil. Este projeto foi desenvolvido com Java e utiliza Swing para a interface gráfica, com persistência de dados em arquivos de texto.

Este projeto foi criado para fins de aprendizado e desenvolvimento acadêmico, e não está aberto para correções ou contribuições externas.

## Funcionalidades Principais
Login de Semideuses: Autenticação simples de semideuses por meio de nome de usuário e senha.
Gestão de Missões: Os semideuses podem visualizar missões, selecionar companheiros (outros semideuses e sátiros) e iniciar missões.
Sistema de Loja: O semideus pode comprar itens utilizando dracmas, que são ganhos ao completar missões.
Perfil do Semideus: O perfil exibe as férias no acampamento e atos realizados pelo semideus.

## Tecnologias Utilizadas
Java: Linguagem principal utilizada para o desenvolvimento do projeto.
Java Swing: Biblioteca usada para a interface gráfica do usuário.
Arquivos de Texto: Persistência dos dados (como semideuses, missões, itens e sátiros) em arquivos de texto simples.

## Estrutura do Projeto
  Pacotes
model: Contém as classes de domínio, como Semideus, Missao, Item, e Satiro.
dao: Contém os DAOs (Data Access Objects) responsáveis por gerenciar o acesso e a persistência dos dados em arquivos de texto.
controller: Implementa a lógica do negócio, conectando a interface gráfica (views) com os dados (DAOs).
view: Contém as telas da aplicação (Java Swing), como a tela de login, tela de missões e tela de loja.
main: Ponto de entrada da aplicação.
  Estrutura de Arquivos
semideuses.txt: Armazena os semideuses e seus dados.
missoes.txt: Armazena as missões disponíveis.
itens.txt: Armazena os itens disponíveis na loja.
satiros.txt: Armazena os sátiros disponíveis para acompanhar os semideuses.

## Futuras Melhorias
Migração da persistência de dados de arquivos de texto para um banco de dados.
Melhorias na interface gráfica para tornar a experiência mais interativa e intuitiva.
Adicionar um sistema de batalha nas missões, permitindo interações mais complexas entre semideuses e inimigos.
Expansão do perfil do semideus com mais informações e estatísticas.

## Licença
Este projeto foi desenvolvido para fins acadêmicos e não está aberto para contribuições externas. O código é propriedade do autor e será futuramente melhorado como parte de estudos e desenvolvimento pessoal.
