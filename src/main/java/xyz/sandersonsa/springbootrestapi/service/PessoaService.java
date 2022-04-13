package xyz.sandersonsa.springbootrestapi.service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Pessoal buscarPorId(Long id) {
        // TODO Auto-generated method stub
        Optional<Pessoal> pessoa = repository.findById(id);
        return pessoa.isPresent() ? pessoa.get() : null;
    }

    @Override
    public Pessoal salvar(Pessoal pessoa) {
        // TODO Auto-generated method stub
        return repository.save(pessoa);
    }

    @Override
    public Pessoal editar(Pessoal pessoa) {
        // TODO Auto-generated method stub
        return repository.save(pessoa);
    }
    
}
