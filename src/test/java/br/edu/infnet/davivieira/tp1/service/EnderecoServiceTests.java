package br.edu.infnet.davivieira.tp1.service;

import br.edu.infnet.davivieira.tp1.model.domain.Endereco;
import br.edu.infnet.davivieira.tp1.model.service.EnderecoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EnderecoServiceTests {

    @Autowired
    private EnderecoService enderecoService;

    private Endereco endereco;

    private final String CEP = "20010020";

    @BeforeEach
    void setUp() {
        endereco = new Endereco(CEP);
    }

    @Test
    void inclusao() {

        enderecoService.incluir(endereco);

        assertEquals(endereco, enderecoService.obter(CEP));
    }

    @Test
    void exclusao() {
        inclusao();

        enderecoService.excluir(CEP);

        assertEquals(null, enderecoService.obter(CEP));
    }

    @Test
    void recuperacaoTotal() {
        inclusao();

        assertTrue(enderecoService.obterLista().contains(endereco));
    }
}