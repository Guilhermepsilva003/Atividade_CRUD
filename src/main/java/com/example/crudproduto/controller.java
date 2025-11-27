package com.example.crudproduto;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class controller {

    private final service service;

    public controller(service service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        service.initSampleData();
    }

    @GetMapping
    public List<model> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public model getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<model> create(@Valid @RequestBody model produto) {
        model created = service.create(produto);
        return ResponseEntity.created(URI.create("/api/produtos/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public model update(@PathVariable Long id, @Valid @RequestBody model produto) {
        return service.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
