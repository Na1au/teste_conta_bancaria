package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Classe simples que realiza operacoes de conta bancaria
 * @ author Ana Laura
 * @ version 1.0 (28/11/2023)
 */
public class Conta {
    private ContaBancaria conta;
    private Boolean podeSacar;
    private String result;
    private int saqueSolicitado;
    private int saldoFinal;
    /**
     * @param saldo saldo atual do cliente
     */
    @Given("um cliente especial com saldo atual de {int} reais")
    public void um_cliente_especial_com_saldo_atual_de_reais(Integer saldo) {
        conta = new ContaBancaria("especial");
        conta.setSaldo(saldo);
        System.out.println("Saldo atual do cliente especial: " + saldo);
    }

    /**
     * @param int1 valor do saque solicitado
     */
    @When("for solicitado um saque no valor de {int} reais")
    public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
        saqueSolicitado = int1;
        conta.setPodeSacar(true);
        System.out.println("Você solicitou um saque no valor de: " + int1);
    }

    /**
     *
     * @param int1 valor do saldo atualizado apos o saque
     */
    @Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
        podeSacar = conta.sacar(saqueSolicitado);
        saldoFinal = conta.consultaSaldo();
        System.out.println("Saque efetuado, seu saldo atual é: " + saldoFinal);
    }

    /**
     *
     * @param int1 saldo atual do cliente
     */
    @Given("um cliente comum com saldo atual de {int} reais")
    public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
        conta = new ContaBancaria("comum");
        conta.setSaldo(int1);
        System.out.println("Saldo atual do cliente comum:" + int1);
    }

    /**
     *
     * @param int1 valor do saque solicitado pelo cliente
     */
    @When("solicitar um saque no valor de {int} reais")
    public void solicitar_um_saque_no_valor_de_reais(Integer int1) {
        podeSacar = conta.sacar(int1);
        if(!podeSacar) {
           result = "Erro! Saldo insuficiente.";
        } else {
            result = "Saque efetuado com sucesso!";
        }
        System.out.println("Você solicitou um saque no valor de: " + int1);
    }

    /**
     * Retorna uma mensagem de erro para o usuario caso o saldo seja insuficiente para o saque solicitado
     */
    @Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
    public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
        System.out.println(result);
    }
}