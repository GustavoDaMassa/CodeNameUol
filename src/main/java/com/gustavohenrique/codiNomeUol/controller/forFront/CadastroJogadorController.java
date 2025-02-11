package com.gustavohenrique.codiNomeUol.controller.forFront;

import com.gustavohenrique.codiNomeUol.model.GrupoCodinome;
import com.gustavohenrique.codiNomeUol.model.Jogador;
import com.gustavohenrique.codiNomeUol.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return getViewAndModel(model, new Jogador(null,null,null,null,null));
    }

    @PostMapping
    public String cadastrarJogador(@ModelAttribute @Valid Jogador jogador, BindingResult result, Model model) throws Exception {
        if(result.hasErrors())return getViewAndModel(model,jogador);
        var novoJogador = jogadorService.cadastrarJogador(jogador);
            return "redirect:cadastro-jogador";
    }

    private String getViewAndModel(Model model, Jogador jogador) {
        model.addAttribute("jogador", jogador);
        model.addAttribute("grupo", GrupoCodinome.values());
        return "cadastro-jogador";
    }
}
