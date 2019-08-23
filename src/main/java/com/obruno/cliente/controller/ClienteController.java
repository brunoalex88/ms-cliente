package com.obruno.cliente.controller;

import com.obruno.cliente.exception.ClienteNotFoundException;
import com.obruno.cliente.model.Cliente;
import com.obruno.cliente.repository.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@Log4j2
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
    public ResponseEntity<Long> remover(@RequestBody @Valid Cliente clienteRemover) {
        Cliente cliente = clienteRepository.findById(clienteRemover.getId()).orElse(null);

        if (cliente == null) {
            throw new ClienteNotFoundException(clienteRemover.getId());
        }

        clienteRepository.delete(cliente);
        return new ResponseEntity<>(cliente.getId(), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> removerPorId(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente == null) {
            throw new ClienteNotFoundException(id);
        }

        clienteRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}
