package xyz.sandersonsa.springbootrestapi.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.sandersonsa.springbootrestapi.model.Pessoal;
import xyz.sandersonsa.springbootrestapi.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;
    
    @GetMapping("/")
    public ResponseEntity<List<Pessoal>> findAll() {
        List<Pessoal> lista = service.listarTodos();

        if(Objects.nonNull(lista) && !lista.isEmpty()) {
            return ResponseEntity.ok().body(lista);
        } else {
            return ResponseEntity.notFound().build();
        }
}

}
