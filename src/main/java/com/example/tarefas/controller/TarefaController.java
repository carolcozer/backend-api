package com.example.tarefas.controller;

import com.example.tarefas.model.Tarefa;
import com.example.tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {
    
    @Autowired
    private TarefaService tarefaService;
    
    // GET - Listar todas as tarefas
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodas() {
        List<Tarefa> tarefas = tarefaService.listarTodas();
        return ResponseEntity.ok(tarefas);
    }
    
    // GET - Buscar tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaService.buscarPorId(id);
        return tarefa.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    // POST - Criar nova tarefa
    @PostMapping
    public ResponseEntity<Tarefa> criar(@Valid @RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.salvar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }
    
    // PUT - Atualizar tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, 
                                           @Valid @RequestBody Tarefa tarefa) {
        try {
            Tarefa tarefaAtualizada = tarefaService.atualizar(id, tarefa);
            return ResponseEntity.ok(tarefaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE - Remover tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            tarefaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}