package br.com.bank.service;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SistemaBancarioTest {

//    @InjectMocks
//    private SistemaBancario sistemaBancario;
//    @Mock
//    private Bacen bacen;

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