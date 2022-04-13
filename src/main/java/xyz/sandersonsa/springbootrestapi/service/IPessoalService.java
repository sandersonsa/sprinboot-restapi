package xyz.sandersonsa.springbootrestapi.service;

import java.util.List;

import xyz.sandersonsa.springbootrestapi.model.Pessoal;

public interface IPessoalService {
    
    List<Pessoal> listarTodos();
    Pessoal buscarPorId(Long id);
    Pessoal salvar(Pessoal pessoa);
    Pessoal editar(Pessoal pessoa);
    
}
