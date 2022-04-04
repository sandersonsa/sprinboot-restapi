package xyz.sandersonsa.springbootrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.sandersonsa.springbootrestapi.model.Pessoal;
import xyz.sandersonsa.springbootrestapi.repository.PessoaRepository;

@Service
public class PessoaService implements IPessoalService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public List<Pessoal> listarTodos() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }
    
}
