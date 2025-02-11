package com.gustavohenrique.codiNomeUol.repository;

import com.gustavohenrique.codiNomeUol.model.GrupoCodinome;
import com.gustavohenrique.codiNomeUol.model.Jogador;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<String> listarJogadoresPelogGrupo(GrupoCodinome grupoCodinome){
        return jdbcClient.sql("""
                SELECT distinct(codinome) FROM JOGADORES WHERE grupo = :grupoCodinme
                """).param("grupoCodinome",grupoCodinome.name()).query(String.class).list();
    }
}
