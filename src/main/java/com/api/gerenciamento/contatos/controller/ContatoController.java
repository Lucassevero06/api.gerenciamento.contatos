package com.api.gerenciamento.contatos.controller;

import com.api.gerenciamento.contatos.dto.ContatoDTO;
import com.api.gerenciamento.contatos.model.Contato;
import com.api.gerenciamento.contatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    public Page<ContatoDTO> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ContatoDTO::new);
    }

    @PostMapping
    @Transactional
    public void criar(@RequestBody ContatoDTO dados) {
        repository.save(new Contato(dados));
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody ContatoDTO dados, @PathVariable Long id) {
        var contato = repository.getReferenceById(id);
        contato.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var contato = repository.getReferenceById(id);
        contato.excluir();
    }

}
