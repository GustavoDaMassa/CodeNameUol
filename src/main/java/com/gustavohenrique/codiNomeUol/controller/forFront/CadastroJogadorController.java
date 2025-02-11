package com.gustavohenrique.codiNomeUol.controller.forFront;

import com.gustavohenrique.codiNomeUol.model.GrupoCodinome;
import com.gustavohenrique.codiNomeUol.model.Jogador;
import com.gustavohenrique.codiNomeUol.service.JogadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cadastro-jogador")
public class CadastroJogadorController {

    private final JogadorService jogadorService;

    public CadastroJogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public String paginaCadastroJogador(Model model){
        model.addAttribute("jogador", new Jogador(null,null,null,null,null));
        model.addAttribute("grupo", GrupoCodinome.values());
        return "cadastro-jogador";
    }

    @PostMapping
    public String cadastrarJogador(@ModelAttribute Jogador jogador){
        try {
            var novoJogador = jogadorService.cadastrarJogador(jogador);
            return "redirect:cadastro-jogador";
        } catch (Exception e) {
            return "redirect:cadastro-jogador";
        }
    }
}
