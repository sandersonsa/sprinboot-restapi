package xyz.sandersonsa.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.sandersonsa.springbootrestapi.model.Pessoal;

public interface PessoaRepository extends JpaRepository<Pessoal, Long> {
    
}
