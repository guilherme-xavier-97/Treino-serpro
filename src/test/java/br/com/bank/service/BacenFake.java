package br.com.bank.service;


import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;

import java.util.HashMap;
import java.util.Map;

public class BacenFake extends Bacen {

    private Map<Long, Banco> bancos = new HashMap<>();

    @Override
    public long cadastrarBanco(Banco banco) {

        long id = bancos.size() + 1;
        bancos.put(id, banco);
        return id;
    }
    

}
