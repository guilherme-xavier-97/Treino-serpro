package br.com.bank.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Banco {

    private String nome;

    public Banco(String nome) {
        this.nome = nome;
    }

    private List<Conta> contasList = new ArrayList<>();
    private final int VALOR_CONTAS_ALTA_RENDA = 10000;

    public void adicionarConta(Conta conta) {
        contasList.add(conta);
    }

    public Optional<Conta> pesquisarContaDoCliente(String cpf) {

        return contasList.stream().filter(c -> c.getCpf().equals(cpf)).findFirst();
        /*
        Conta c = null;
        
         for (int i = 0; i < contasList.size(); i++) {
            if (contasList.get(i).getCpf().equals(cpf)) {
                c = contasList.get(i);
            }
        }
     
        return c;
         */              
    }



    public List<Conta> listarContasAltaRenda() {
        return filtrarContas(c -> c.getSaldo() >= VALOR_CONTAS_ALTA_RENDA);
    }

    
     private List<Conta> filtrarContas(Predicate<Conta> filtro) {
        return contasList.stream().filter(filtro).collect(Collectors.toList());
    }

    

    
}
