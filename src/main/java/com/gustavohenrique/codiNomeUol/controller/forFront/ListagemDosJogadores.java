package com.gustavohenrique.codiNomeUol.controller.forFront;

import com.gustavohenrique.codiNomeUol.model.Jogador;
import com.gustavohenrique.codiNomeUol.service.JogadorService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("listagem-jogadores")
public class ListagemDosJogadores {

    private final JogadorService jogadorService;

    public ListagemDosJogadores (JogadorService jogadorService){
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public String listarJogadores(Model model){
        model.addAttribute("jogadores", jogadorService.listarJogador());
        return "listagem-jogadores";
    }
}
