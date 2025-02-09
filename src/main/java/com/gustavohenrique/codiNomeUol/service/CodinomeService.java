package com.gustavohenrique.codiNomeUol.service;

import com.gustavohenrique.codiNomeUol.model.GrupoCodinome;
import com.gustavohenrique.codiNomeUol.repository.CodinomeRepository;
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
        if(codinomesDisponiveis.isEmpty()) throw new Exception("Não há codinomes disponíveis para o grupo" + grupoCodinome.getNome());

        return sortearCodinome(codinomesDisponiveis);
    }

    public List<String> listarCodinosmesDisponiveis(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) throws Exception{
        var codinomes = buscarCodinomes(grupoCodinome);

        var codinomesDisponiveis = codinomes.stream().filter(codinome -> !codinomesEmUso.contains(codinomes)).toList();

        return codinomesDisponiveis;
    }

    public List<String> buscarCodinomes(GrupoCodinome grupoCodinome) throws Exception{
        var codinomeRepository = codinomesRepositoryFactory.create(grupoCodinome);
        return codinomeRepository.buscarCodinomes();
    }

    private String sortearCodinome(List<String> codinomesDisponiveis){
        return codinomesDisponiveis.get((int) (Math.random() * codinomesDisponiveis.size()));
    }
}
