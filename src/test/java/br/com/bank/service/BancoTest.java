package br.com.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import br.com.bank.model.Banco;
import br.com.bank.model.Conta;


public class BancoTest {

    private String cpf;
    private double saldo;
    private Banco banco;

    @BeforeEach
    public void setUp() {
        cpf = "10";
        saldo = 1000;
        banco = new Banco("BB");

    }
    
    //Esse método cria X contas aleatórias, sendo que só as 4 primeiras são de baixa renda
    public void criarContasAleatorias ( int totalContas) {
        
        for(int i = 1; i <= totalContas; i++) {
            banco.adicionarConta(new Conta(String.format("%d", i), saldo));
            saldo = saldo * 2;
        }

    }
        
    @Test
    public void testar_o_metodo_pesquisarContaDoCliente() {
       //long inicio = System.currentTimeMillis();
       criarContasAleatorias(10);

       Optional<Conta> conta = banco.pesquisarContaDoCliente(cpf);
     
        assertEquals(cpf, conta.get().getCpf());     

       //long fim = System.currentTimeMillis();
       //System.out.println(fim-inicio);
    }  


    @Test
    public void testar_o_metodo_listarContasAltaRenda() {
        criarContasAleatorias(10);

        assertEquals(6, banco.listarContasAltaRenda().size());       

    }
    

}
