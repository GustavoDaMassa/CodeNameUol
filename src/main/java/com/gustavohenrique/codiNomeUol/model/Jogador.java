package com.gustavohenrique.codiNomeUol.model;


public record Jogador(
        String nome,
        String email,
        String telefone,
        String codinome,
        GrupoCodinome grupo
) {
}
