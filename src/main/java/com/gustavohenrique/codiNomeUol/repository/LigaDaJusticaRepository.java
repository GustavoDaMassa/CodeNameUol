package com.gustavohenrique.codiNomeUol.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gustavohenrique.codiNomeUol.model.GrupoCodinome;
import com.gustavohenrique.codiNomeUol.model.LigaDaJusticaDTO;
import com.gustavohenrique.codiNomeUol.model.VingadoresDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class LigaDaJusticaRepository implements CodinomeRepository{

    @Override
    public List<String> buscarCodinomes() throws Exception {
        var codinomes = RestClient.builder().baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri()).build().get().retrieve().body(String.class);

        var xmlMapper = new XmlMapper();

        var ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);

        return ligaDaJustica.getCodinomes();
    }

}
