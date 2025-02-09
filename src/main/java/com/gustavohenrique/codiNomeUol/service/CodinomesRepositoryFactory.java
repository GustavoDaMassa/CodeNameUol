package com.gustavohenrique.codiNomeUol.service;

import com.gustavohenrique.codiNomeUol.model.GrupoCodinome;
import com.gustavohenrique.codiNomeUol.repository.CodinomeRepository;
import com.gustavohenrique.codiNomeUol.repository.LigaDaJusticaRepository;
import com.gustavohenrique.codiNomeUol.repository.VingadoresRepository;
import org.springframework.stereotype.Component;

@Component
public class CodinomesRepositoryFactory {

    private final LigaDaJusticaRepository ligaDaJusticaRepository;
    private final VingadoresRepository vingadoresRespository;

    public CodinomesRepositoryFactory(LigaDaJusticaRepository ligaDaJusticaRepository, VingadoresRepository vingadoresRespository) {
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
        this.vingadoresRespository = vingadoresRespository;
    }

    public CodinomeRepository create(GrupoCodinome grupoCodinome){
        return switch (grupoCodinome){
            case LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
            case VINGADORES -> vingadoresRespository;
        };
    }
}
