package com.gustavohenrique.codiNomeUol.service;

import com.gustavohenrique.codiNomeUol.exception.GrupoCodinomeIndisponivelException;
import com.gustavohenrique.codiNomeUol.model.GrupoCodinome;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodinomeService {

    private final CodinomesRepositoryFactory codinomesRepositoryFactory;

    public CodinomeService(CodinomesRepositoryFactory codinomesRepositoryFactory) {
        this.codinomesRepositoryFactory = codinomesRepositoryFactory;
    }

    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) throws Exception{
        var codinomesDisponiveis = listarCodinosmesDisponiveis(grupoCodinome,codinomesEmUso);
        if(codinomesDisponiveis.isEmpty()) throw new GrupoCodinomeIndisponivelException();

        return sortearCodinome(codinomesDisponiveis);
    }

    public List<String> listarCodinosmesDisponiveis(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) throws Exception{
        var codinomes = buscarCodinomes(grupoCodinome);

        return codinomes.stream().filter(codinome -> !codinomesEmUso.contains(codinomes)).toList();
    }

    public List<String> buscarCodinomes(GrupoCodinome grupoCodinome) throws Exception{
        var codinomeRepository = codinomesRepositoryFactory.create(grupoCodinome);
        return codinomeRepository.buscarCodinomes().getCodinomes();
    }

    private String sortearCodinome(List<String> codinomesDisponiveis){
        return codinomesDisponiveis.get((int) (Math.random() * codinomesDisponiveis.size()));
    }
}
