package br.com.bank.service;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;
import br.com.bank.model.BancoNaoCadastradoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class SistemaBancarioTestMocks {

@InjectMocks
private SistemaBancario sistemaBancarioMock;
@Mock
private Bacen bacen;


@Test
public void deve_registrar_banco_se_possuir_autorizacao_do_bacen() {
    Banco banco = new Banco("bb");
    Mockito.doReturn(1L)
    .when(bacen)
    .cadastrarBanco(banco);

    long numeroRegistro = sistemaBancarioMock.registrarBanco(banco);
    assertEquals(1L, numeroRegistro);
}

@Test
public void nao_deve_registrar_banco_se_houver_problema_de_comunicacao_com_bacen() {

    Banco banco = new Banco("bb");

    Mockito.doThrow(BancoNaoCadastradoException.class)
    .when(bacen)
    .cadastrarBanco(banco);

    assertThrows(BancoNaoCadastradoException.class,
     () -> sistemaBancarioMock.registrarBanco(banco));
}
    
}
