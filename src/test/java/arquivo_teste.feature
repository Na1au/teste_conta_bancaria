#Author: Ana Laura

Feature: Cliente faz saque de dinheiro como um cliente
  Eu gostaria de sacar dinheiro em caixa eletrônico, para que eu não tenha que esperar numa fila de banco

  Scenario: Cliente especial com saldo negativo
    Given  um cliente especial com saldo atual de -200 reais
    When for solicitado um saque no valor de 100 reais
    Then deve efetuar o saque e atualizar o saldo da conta para -300 reais

  Scenario: Cliente comum com saldo negativo
    Given  um cliente comum com saldo atual de -300 reais
    When solicitar um saque no valor de 200 reais
    Then não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente
