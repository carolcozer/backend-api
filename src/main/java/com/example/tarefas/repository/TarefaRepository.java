package com.example.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tarefas.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}