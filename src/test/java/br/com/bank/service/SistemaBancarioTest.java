package br.com.bank.service;

import br.com.bank.model.Banco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class SistemaBancarioTest {

private SistemaBancario sistemaBancario;

@BeforeEach
public void setUp() {

    sistemaBancario = new SistemaBancario(new BacenStub());
    sistemaBancario = new SistemaBancario(new BacenFake());
}

@Test
public void testar_se_banco_foi_registrado_com_stub() {
    Banco bancoDoBrasil = new Banco("Banco do Brasil");

    long numeroDoRegistro = sistemaBancario.registrarBanco(bancoDoBrasil);
    assertEquals(1, numeroDoRegistro);

    }

@Test
public void testar_se_banco_foi_registrado_com_fake() {
    Banco bancoDoBrasil = new Banco("Banco do Brasil");
    Banco nubank = new Banco("Nubank");

    long registro = sistemaBancario.registrarBanco(bancoDoBrasil);
    registro = sistemaBancario.registrarBanco(nubank);

    assertEquals(2, registro);
    

    }
        
}