package xyz.sandersonsa.springbootrestapi.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import xyz.sandersonsa.springbootrestapi.model.Pessoal;
import xyz.sandersonsa.springbootrestapi.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
@Slf4j
public class PessoaController {

    @Autowired
    private PessoaService service;
    
    @GetMapping
    @Operation(summary = "Listar Pessoas", description = "Listar Pessoas")
    public ResponseEntity<List<Pessoal>> findAll(@RequestHeader Map<String, String> headers) {
        
        headers.forEach((key, value) -> {
            log.info(String.format("Header:: '%s' = %s", key, value));
        });
        
        List<Pessoal> lista = service.listarTodos();

        if(Objects.nonNull(lista) && !lista.isEmpty()) {
            return ResponseEntity.ok().body(lista);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoal> findById(@PathVariable(value = "id") long id) {
       Pessoal pessoa = service.buscarPorId(id);
       if(Objects.nonNull(pessoa)){
           return ResponseEntity.ok().body(pessoa);
       }else{
           return ResponseEntity.notFound().build();
       }
    }

    @PostMapping
    public ResponseEntity<Pessoal> save(@RequestBody Pessoal pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(pessoa));
    }

    @PutMapping
    public ResponseEntity<Pessoal> update(@RequestBody Pessoal pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(service.editar(pessoa));
    }


}
