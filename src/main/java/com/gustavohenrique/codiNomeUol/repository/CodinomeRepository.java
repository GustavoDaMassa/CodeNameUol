package com.gustavohenrique.codiNomeUol.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodinomeRepository {
    public List<String> buscarCodinomes() throws Exception;
}
