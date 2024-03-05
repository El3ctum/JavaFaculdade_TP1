package br.edu.infnet.davivieira.tp1;

import br.edu.infnet.davivieira.tp1.model.domain.Distrito;
import br.edu.infnet.davivieira.tp1.model.domain.Estado;
import br.edu.infnet.davivieira.tp1.model.domain.Municipio;
import br.edu.infnet.davivieira.tp1.model.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class LocalidadeLoader implements ApplicationRunner {

    @Autowired
    private LocalidadeService localidadeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Collection<Estado> estados = localidadeService.obterEstados();

        for(Estado estado : estados) {
            System.out.println("- ESTADO: " + estado.getNome());

            Collection<Municipio> municipios = localidadeService.obterMunicipioPorUF(33);//estado.getId());

            for(Municipio municipio : municipios) {
                System.out.println("-- MUNICÍPIO: " + municipio.getNome());

                Collection<Distrito> distritos = localidadeService.obterDistritoPorMunicipio(municipio.getId());

                for(Distrito distrito : distritos) {
                    System.out.println("... DISTRITO: " + distrito.getNome());
                }
            }
        }

    }
}
