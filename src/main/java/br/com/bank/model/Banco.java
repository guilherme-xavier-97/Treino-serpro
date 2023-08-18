package br.com.bank.model;


import static org.mockito.ArgumentMatchers.contains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.mapping.Map;

public class Banco {

    private String nome;

    public Banco(String nome) {
        this.nome = nome;
    }

    private List<Conta> contasList = new ArrayList<>();

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
        return filtrarContas(c -> c.getSaldo() >= 10000);
    }

    
     private List<Conta> filtrarContas(Predicate<Conta> filtro) {
        return contasList.stream().filter(filtro).collect(Collectors.toList());
    }

    

    
}
