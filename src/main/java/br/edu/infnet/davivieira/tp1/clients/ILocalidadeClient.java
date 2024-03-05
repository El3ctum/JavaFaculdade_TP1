package br.edu.infnet.davivieira.tp1.clients;

import br.edu.infnet.davivieira.tp1.model.domain.Distrito;
import br.edu.infnet.davivieira.tp1.model.domain.Estado;
import br.edu.infnet.davivieira.tp1.model.domain.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "localidadeClient")
public interface ILocalidadeClient {

    @GetMapping(value = "/estados?orderBy=nome")
    Collection<Estado> obterEstados();

    @GetMapping(value = "/estados/{uf}/municipios")
    Collection<Municipio> obterMunicipioPorUF(@PathVariable Integer uf);

    @GetMapping(value = "/municipios/{municipio}/distritos")
    Collection<Distrito> obterDistritoPorMunicipio(@PathVariable Integer municipio);
}
