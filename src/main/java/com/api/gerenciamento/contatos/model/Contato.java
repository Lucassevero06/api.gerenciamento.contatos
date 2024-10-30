package com.api.gerenciamento.contatos.model;

import com.api.gerenciamento.contatos.dto.ContatoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "contatos")
@Entity(name = "Contato")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contato {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private String observacoes;

    private Boolean ativo;

    public Contato(ContatoDTO dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.observacoes = dados.observacoes();
    }

    public void atualizarInformacoes(ContatoDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.observacoes() != null) {
            this.observacoes = dados.observacoes();
        }
        if (dados.ativo() != this.ativo) {
            this.ativo = dados.ativo();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
