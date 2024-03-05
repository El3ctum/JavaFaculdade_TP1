package br.edu.infnet.davivieira.tp1;

import br.edu.infnet.davivieira.tp1.model.domain.Endereco;
import br.edu.infnet.davivieira.tp1.model.service.EnderecoService;
import br.edu.infnet.davivieira.tp1.model.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EnderecoLoader implements ApplicationRunner {

    @Autowired
    private LocalidadeService localidadeService;
    @Autowired
    private EnderecoService enderecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Endereco enderecoInfnet = localidadeService.obterPorCep("22241900");

        enderecoService.incluir(enderecoInfnet);

        enderecoService.excluir("22241900");

        Endereco e1 = new Endereco();
        e1.setCep("12345678");
        e1.setLogradouro("logradouro");
        e1.setBairro("bairro");

        enderecoService.incluir(e1);

        System.out.println(" - " + enderecoService.obter("12345678"));

        enderecoService.incluir(enderecoInfnet);

        System.out.println(" - " + enderecoService.obterLista());
    }

}
