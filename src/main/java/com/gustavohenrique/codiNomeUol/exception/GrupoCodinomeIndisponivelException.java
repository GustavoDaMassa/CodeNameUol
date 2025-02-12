package com.gustavohenrique.codiNomeUol.exception;

public class GrupoCodinomeIndisponivelException  extends  IllegalArgumentException{

    public GrupoCodinomeIndisponivelException() {
        super("Não há mais codinomes disponíveis para esse grupo.");
    }
}
