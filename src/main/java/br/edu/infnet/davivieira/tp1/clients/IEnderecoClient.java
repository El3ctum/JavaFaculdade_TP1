package br.edu.infnet.davivieira.tp1.clients;

import br.edu.infnet.davivieira.tp1.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IEnderecoClient {

    @GetMapping(value = "/{cep}/json/")
    Endereco obterPorCep(@PathVariable String cep);
}