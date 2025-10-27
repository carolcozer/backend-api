package com.example.tarefas.service;

import com.example.tarefas.model.Tarefa;
import com.example.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;
    
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }
    
    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }
    
    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }
    
    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setNome(tarefaAtualizada.getNome());
                    tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
                    tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
                    return tarefaRepository.save(tarefa);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
    }
    
    public void deletar(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada com id: " + id);
        }
    }
    
    public boolean existePorId(Long id) {
        return tarefaRepository.existsById(id);
    }
}