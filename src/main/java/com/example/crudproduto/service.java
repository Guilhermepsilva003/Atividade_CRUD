package com.example.crudproduto;


import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class service {

    private final Map<Long, com.example.crudproduto.model> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<model> findAll() {
        return new ArrayList<>(store.values());
    }

    public model findById(Long id) {
        model p = store.get(id);
        if (p == null) throw new exception("Produto não encontrado com id: " + id);
        return p;
    }

    public model create(model produto) {
        Long id = idGenerator.getAndIncrement();
        produto.setId(id);
        store.put(id, produto);
        return produto;
    }

    public model update(Long id, model produto) {
        model existing = store.get(id);
        if (existing == null) throw new exception("Produto não encontrado com id: " + id);
        // Atualiza campos
        existing.setNome(produto.getNome());
        existing.setDescricao(produto.getDescricao());
        existing.setPreco(produto.getPreco());
        store.put(id, existing);
        return existing;
    }

    public void delete(Long id) {
        model removed = store.remove(id);
        if (removed == null) throw new exception("Produto não encontrado com id: " + id);
    }

    // método utilitário para popular dados iniciais (opcional)
    public void initSampleData() {
        create(new model(null, "Brigadeiro", "Brigadeiro gourmet", 3.5));
        create(new model(null, "Bolo de Cenoura", "Bolo médio", 25.0));
    }
}
