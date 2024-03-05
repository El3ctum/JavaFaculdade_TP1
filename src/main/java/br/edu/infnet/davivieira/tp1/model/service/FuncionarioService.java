package br.edu.infnet.davivieira.tp1.model.service;

import br.edu.infnet.davivieira.tp1.model.domain.Funcionario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FuncionarioService {

    private static Map<Integer, Funcionario> funcionarios = new HashMap<Integer, Funcionario>();

    public void incluir(Funcionario professor) {
        funcionarios.put(professor.getCadastro(), professor);
    }

    public void excluir(int registro) {
        funcionarios.remove(registro);
    }

    public Collection<Funcionario> obterLista(){
        return funcionarios.values();
    }

    public Funcionario obter(int registro){
        return funcionarios.get(registro);
    }
}
