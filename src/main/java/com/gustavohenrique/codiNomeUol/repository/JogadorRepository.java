package com.gustavohenrique.codiNomeUol.repository;

import com.gustavohenrique.codiNomeUol.model.Jogador;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class JogadorRepository {

    private final JdbcClient jdbcClient;

    public JogadorRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public Jogador salvar(Jogador jogador){
        jdbcClient.sql("""
                INSERT INTO JOGADORES ( nome, email, telefone, codinome, grupo)
                VALUES (:nome, :email, :telefone, :codinome, :grupo)
                """)
                .param("nome", jogador.nome())
                .param("email", jogador.email())
                .param("telefone", jogador.telefone())
                .param("codinome", jogador.codinome())
                .param("grupo", jogador.grupo())
                .update();
        return jogador;
    }
}
