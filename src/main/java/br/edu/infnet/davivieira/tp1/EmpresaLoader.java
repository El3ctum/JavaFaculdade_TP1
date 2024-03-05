package br.edu.infnet.davivieira.tp1;

import br.edu.infnet.davivieira.tp1.model.domain.Empresa;
import br.edu.infnet.davivieira.tp1.model.domain.Endereco;
import br.edu.infnet.davivieira.tp1.model.service.EmpresaService;
import br.edu.infnet.davivieira.tp1.model.service.LocalidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpresaLoader implements ApplicationRunner {

    @Autowired
    private LocalidadeService localidadeService;
    @Autowired
    private EmpresaService empresaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Endereco enderecoInfnet = localidadeService.obterPorCep("22241900");

        empresaService.incluir(new Empresa("Infnet", "infnet@infnet", enderecoInfnet));

        empresaService.excluir("Infnet");

        empresaService.incluir(new Empresa("Instituto Infnet", "instituto@infnet", enderecoInfnet));

        System.out.println(" - " + empresaService.obter("Instituto Infnet"));

        empresaService.incluir(new Empresa("Computação do Infnet", "computacao@infnet", enderecoInfnet));

        System.out.println(" - " + empresaService.obterLista());
    }
}
