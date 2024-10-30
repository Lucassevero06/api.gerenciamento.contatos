package com.api.gerenciamento.contatos.dto;

import com.api.gerenciamento.contatos.model.Contato;

import java.util.List;

public record ContatoDTO(
        Long id,
        String nome,
        String telefone,
        String email,
        String observacoes,
        Boolean ativo
) {
    public ContatoDTO(Contato contato) {
        this(contato.getId(), contato.getNome(), contato.getTelefone(), contato.getEmail(), contato.getObservacoes(), contato.getAtivo());
    }
}
