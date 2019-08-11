package com.obruno.cliente.controller;

import com.obruno.cliente.model.Cliente;
import com.obruno.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Cliente> listarPorId(@PathVariable Long id) {
        return clienteRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> alterar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
    }

    @DeleteMapping
    public void remover(@RequestBody @Valid Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public void removerPorId(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);
    }

}
