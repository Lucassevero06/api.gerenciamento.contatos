package com.api.gerenciamento.contatos.repository;

import com.api.gerenciamento.contatos.dto.ContatoDTO;
import com.api.gerenciamento.contatos.model.Contato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Page<Contato> findAllByAtivoTrue(Pageable paginacao);
}
