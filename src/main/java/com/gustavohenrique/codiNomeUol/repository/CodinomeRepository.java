package com.gustavohenrique.codiNomeUol.repository;

import com.gustavohenrique.codiNomeUol.model.CodinomeDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodinomeRepository {
    public CodinomeDTO buscarCodinomes() throws Exception;
}
