package com.example.tarefas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // Usa o perfil de teste
class TarefasApplicationTests {

    @Test
    void contextLoads() {
        // Teste vazio - só verifica se o contexto carrega
    }
}