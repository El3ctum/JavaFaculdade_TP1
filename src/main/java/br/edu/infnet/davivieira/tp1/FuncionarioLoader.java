package br.edu.infnet.davivieira.tp1;

import br.edu.infnet.davivieira.tp1.model.domain.Endereco;
import br.edu.infnet.davivieira.tp1.model.domain.Funcionario;
import br.edu.infnet.davivieira.tp1.model.service.FuncionarioService;
import br.edu.infnet.davivieira.tp1.model.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioLoader implements ApplicationRunner {

    @Autowired
    private LocalidadeService localidadeService;
    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Endereco enderecoFuncionario = localidadeService.obterPorCep("20041-005");

        funcionarioService.incluir(new Funcionario());

        funcionarioService.excluir(123);

        funcionarioService.incluir(new Funcionario(enderecoFuncionario));

        System.out.println(" - " + funcionarioService.obter(123));

        Funcionario funcionario = new Funcionario();
        funcionario.setCadastro(234);
        funcionario.setNome("Professor Elberth Moraes");
        funcionario.setSalario(777);
        funcionario.setEspecialista(false);
        funcionario.setEndereco(new Endereco("20010020", "Prof Rua São José", "Prof 4º andar", "Prof Centro", "Prof Rio de Janeiro", "UF"));

        funcionarioService.incluir(funcionario);

        System.out.println(" - " + funcionarioService.obterLista());
    }
}
