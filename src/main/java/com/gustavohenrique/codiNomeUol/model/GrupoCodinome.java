package com.gustavohenrique.codiNomeUol.model;

public enum GrupoCodinome {
    VINGADORES("Vingadores" , ""),
    LIGA_DA_JUSTICA("Liga da Justiça", "");

    private final String nome;
    private  final String uri;

     GrupoCodinome(String nome, String uri){
        this.nome = nome;
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getNome() {
        return nome;
    }
}
