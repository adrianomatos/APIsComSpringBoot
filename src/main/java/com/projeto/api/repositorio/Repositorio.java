package com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import com.projeto.api.modelo.Pessoa;

// @Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {

    List<Pessoa> findAll();

    // findById e retorna Pessoa
    Pessoa findByCodigo(int codigo);
    //Quando uma busca puder retornar vários valores
    // List<Pessoa> findByNome(String nome);

    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

    List<Pessoa> findByNomeContaining(String termo);
    
    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);

    @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
    int somaIdades();

    @Query(value="SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true)
    List<Pessoa> idadeMaiorIgual(int idade);

    // Contador códigos
    int countByCodigo(int codigo);

}
