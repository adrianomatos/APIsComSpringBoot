package com.projeto.api.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.api.modelo.Cliente;
import com.projeto.api.modelo.Pessoa;
import com.projeto.api.repositorio.Repositorio;
import com.projeto.api.servico.Servico;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj) {
        return servico.cadastrar(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selecionar() {
        return servico.selecionar();
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo) {
        return servico.selecionarPeloCodigo(codigo);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj) {
        return servico.editar(obj);
    }

    @DeleteMapping("api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo) {
        return servico.remover(codigo);
    }

    @GetMapping("/api/contador")
    public long contador() {
        return acao.count();
    }

    @GetMapping("api/ordenarNomes")
    public List<Pessoa> ordenarNomes() {
        return acao.findByOrderByNome();
    }

    // Usar @PathVariable
    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2() {
        return acao.findByNomeOrderByIdadeDesc("Adriano");
    }

    // Usar @PathVariable
    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem() {
        return acao.findByNomeContaining("Ad");
    }

    // Usar @PathVariable
    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom() {
        return acao.findByNomeStartsWith("A");
    }

    // Usar @PathVariable
    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom() {
        return acao.findByNomeEndsWith("A");
    }

    @GetMapping("/api/somaIdades")
    public int somaIdades() {
        return acao.somaIdades();
    }

    // @GetMapping("/api/idadeMaiorIgual")
    // public List<Pessoa> idadeMaiorIgual() {
    // return acao.idadeMaiorIgual(40);
    // }

    @GetMapping("/api/idadeMaiorIgual/{idade}")
    public List<Pessoa> idadeMaiorIgual(@PathVariable int idade) {
        return acao.idadeMaiorIgual(idade);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Annotations para validar dados com JPA
    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente obj) {

    }

    // @GetMapping("")
    // public String mensagem() {
    // return "<h1>Hello World</h1>";
    // }

    // @GetMapping("/boasvindas")
    // public String boasvindas() {
    // return "Seja bem vindo!";
    // }

    // @GetMapping("/boasvindas/{nome}")
    // public String boasvindas(@PathVariable String nome) {
    // return "Seja bem vindo(a) " + nome;
    // }

    // @PostMapping("/pessoa")
    // public Pessoa pessoa(@RequestBody Pessoa p) {
    // return p;
    // }

}
