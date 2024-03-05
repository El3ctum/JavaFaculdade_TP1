package br.edu.infnet.davivieira.tp1.model.service;

import br.edu.infnet.davivieira.tp1.model.domain.Empresa;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmpresaService {
    private static Map<String, Empresa> empresas = new HashMap<String, Empresa>();

    public void incluir(Empresa empresa) {
        empresas.put(empresa.getRazaoSocial(), empresa);
    }

    public void excluir(String razaoSocial) {
        empresas.remove(razaoSocial);
    }

    public Collection<Empresa> obterLista() {
        return empresas.values();
    }

    public Empresa obter(String razaoSocial) {
        return empresas.get(razaoSocial);
    }
}