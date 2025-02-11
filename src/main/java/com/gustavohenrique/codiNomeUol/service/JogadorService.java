package com.gustavohenrique.codiNomeUol.service;

import com.gustavohenrique.codiNomeUol.model.GrupoCodinome;
import com.gustavohenrique.codiNomeUol.model.Jogador;
import com.gustavohenrique.codiNomeUol.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private  final  CodinomeService codinomeService;

    public JogadorService(JogadorRepository jogadorRepository, CodinomeService codinomeService) {
        this.jogadorRepository = jogadorRepository;
        this.codinomeService = codinomeService;
    }

    public Jogador cadastrarJogador(Jogador jogador) throws Exception{
        var codinomesEmUso = listarCodinomesEmUso(jogador.grupo());
        var novoCodinome = codinomeService.gerarCodinome(jogador.grupo(),codinomesEmUso);

        var novoJogador = new Jogador(jogador.nome(),jogador.email(),jogador.telefone(),novoCodinome,jogador.grupo());

        return jogadorRepository.salvarJogador(novoJogador);
    }

    public List<String> listarCodinomesEmUso(GrupoCodinome grupoCodinome) {
        return jogadorRepository.listarJogadoresPeloGrupo(grupoCodinome);
    }

    public List<Jogador> listarJogador(){
        return jogadorRepository.mostrarJogadores();
    }
}
