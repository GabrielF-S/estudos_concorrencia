# Java Concurrency & Threads

Repositório dedicado ao estudo prático de **concorrência e multithreading em Java**, com exemplos progressivos, experimentos de execução e exercícios para compreender como aplicações Java podem executar múltiplas tarefas de maneira eficiente e segura.

O objetivo é construir uma base sólida sobre concorrência, desde os fundamentos de `Thread` e `Runnable` até mecanismos de sincronização, gerenciamento de tarefas assíncronas e recursos modernos da plataforma Java.

## Objetivos de aprendizagem

- Compreender a diferença entre execução sequencial, concorrência e paralelismo.
- Criar e executar tarefas utilizando diferentes recursos da linguagem Java.
- Gerenciar múltiplas tarefas com `ExecutorService` e pools de threads.
- Recuperar resultados de tarefas assíncronas com `Callable` e `Future`.
- Entender os desafios de compartilhamento de estado entre threads.
- Identificar e prevenir condições de corrida (*race conditions*).
- Aplicar mecanismos de sincronização e estruturas de dados concorrentes.
- Comparar diferentes estratégias de execução por meio de experimentos práticos.

## Tecnologias utilizadas

- Java
- Maven
- JUnit 5 (para os testes, conforme forem implementados)
- IntelliJ IDEA

## Roadmap de estudos

### Etapa 1 — Fundamentos de Threads

**Status:** Em andamento / fundamentos iniciais estudados.

Conceitos abordados:

- Execução sequencial de tarefas.
- Criação e execução de threads.
- Interface `Runnable`.
- Introdução ao `ExecutorService`.
- Gerenciamento de tarefas por meio de um pool de threads.
- Comparação entre execução direta e execução concorrente.
- Estimativa do tempo de execução com base na quantidade de tarefas e threads disponíveis.

**Experimento prático:** executar cinco tarefas com duração de dois segundos cada, comparando o comportamento de um pool com três threads.

Resultado esperado para o cenário com tarefas independentes: aproximadamente quatro segundos, desconsiderando os custos de inicialização e escalonamento.

### Etapa 2 — Callable e Future

**Status:** Próxima etapa de estudo.

Conceitos a aprender:

- Diferenças entre `Runnable` e `Callable`.
- Como retornar valores de tarefas executadas em outras threads.
- Utilização de `Future` para recuperar resultados.
- Funcionamento do método `get()` e seu comportamento bloqueante.
- Tratamento de exceções durante a execução de tarefas.
- Diferença entre ordem de submissão e ordem de conclusão das tarefas.

**Experimento prático:** executar cinco tarefas com `Callable`, recuperar seus resultados e observar como a duração e a ordem de conclusão afetam a execução.

### Etapa 3 — Gerenciamento de tarefas com ExecutorService

**Status:** Planejada.

- Criação e configuração de pools de threads.
- Diferenças entre `execute()` e `submit()`.
- Encerramento controlado de executores.
- Utilização de `shutdown()` e `awaitTermination()`.
- Tratamento de tarefas pendentes e tempo limite de execução.
- Escolha da quantidade de threads conforme o tipo de trabalho.

### Etapa 4 — Sincronização e condições de corrida

**Status:** Planejada.

- Compartilhamento de recursos entre threads.
- Condições de corrida (*race conditions*).
- Problemas de visibilidade e consistência dos dados.
- Palavra-chave `synchronized`.
- Seções críticas e exclusão mútua.
- Introdução ao princípio *happens-before*.

**Experimento prático:** incrementar um contador compartilhado por múltiplas threads, comparar os resultados e implementar uma solução segura.

### Etapa 5 — Locks e classes atômicas

**Status:** Planejada.

- `ReentrantLock`.
- Diferenças entre `synchronized` e `Lock`.
- Uso de `tryLock()` e liberação segura de locks.
- Classes atômicas, como `AtomicInteger`.
- Operações atômicas e atualizações concorrentes.
- Critérios para escolher cada mecanismo de sincronização.

### Etapa 6 — Comunicação entre threads

**Status:** Planejada.

- Problemas de coordenação entre produtores e consumidores.
- `BlockingQueue`.
- Filas concorrentes e processamento de tarefas.
- Coordenação entre threads sem compartilhamento desnecessário de estado.
- Tratamento de interrupções.

**Experimento prático:** implementar um fluxo produtor-consumidor em que tarefas são adicionadas a uma fila e processadas por múltiplas threads.

### Etapa 7 — CompletableFuture e composição assíncrona

**Status:** Planejada.

- Diferenças entre `Future` e `CompletableFuture`.
- Execução de tarefas assíncronas.
- Encadeamento com `thenApply()` e `thenCompose()`.
- Combinação de tarefas com `thenCombine()`.
- Tratamento de erros e timeouts.
- Execução em executores personalizados.

**Experimento prático:** simular operações independentes, combinar seus resultados e tratar falhas sem bloquear desnecessariamente a execução.

### Etapa 8 — Estruturas de dados concorrentes

**Status:** Planejada.

- Coleções tradicionais versus coleções concorrentes.
- `ConcurrentHashMap`.
- Filas concorrentes.
- Iteração durante atualizações concorrentes.
- Segurança de operações compostas sobre coleções compartilhadas.

### Etapa 9 — Virtual Threads

**Status:** Planejada.

- Diferenças entre threads tradicionais e *virtual threads*.
- Introdução às Virtual Threads, disponíveis desde Java 21.
- Utilização de `Thread.ofVirtual()` e `Executors.newVirtualThreadPerTaskExecutor()`.
- Aplicações com muitas operações de entrada e saída (I/O).
- Limitações e cuidados com sincronização e bloqueios.
- Comparação prática com pools tradicionais.

### Etapa 10 — Projeto prático de concorrência

**Status:** Planejada.

Consolidar os conceitos em um projeto de processamento concorrente, aplicando:

- Execução de múltiplas tarefas independentes.
- Gerenciamento de executores.
- Recuperação de resultados e tratamento de erros.
- Sincronização e segurança dos dados compartilhados, quando necessárias.
- Monitoramento de tempo de execução.
- Testes e documentação das decisões técnicas.

O escopo do projeto será definido conforme a evolução dos estudos.

## Metodologia

Cada etapa será desenvolvida com foco em aprendizado progressivo:

1. **Conceito:** entender o problema que determinado recurso resolve.
2. **Implementação:** desenvolver exemplos pequenos em Java.
3. **Experimentação:** executar cenários com diferentes quantidades de tarefas e threads.
4. **Análise:** comparar resultados, tempos de execução e limitações.
5. **Consolidação:** registrar aprendizados e avançar para o próximo conceito.

## Estrutura do repositório

A organização será evolutiva. Os exemplos poderão permanecer no mesmo projeto Maven, separados por pacotes conforme os assuntos forem avançando.

```text
src/
├── main/
│   ├── java/
│   │   └── br/com/gabrielf/
│   │       ├── exercer1/
│   │       ├── callablefuture/
│   │       ├── synchronization/
│   │       ├── locks/
│   │       ├── producerconsumer/
│   │       ├── completablefuture/
│   │       └── virtualthreads/
│   └── resources/
└── test/
```

A estrutura acima é uma proposta para as próximas etapas; os pacotes serão criados conforme os exemplos forem implementados.

## Progresso

- [x] Criar o projeto Java com Maven.
- [x] Implementar os primeiros exemplos de execução de tarefas.
- [x] Explorar `Thread`, `Runnable` e `ExecutorService`.
- [x] Estimar o tempo de execução de tarefas em um pool de threads.
- [ ] Implementar tarefas com `Callable` e recuperar resultados com `Future`.
- [ ] Aprofundar o gerenciamento de executores.
- [ ] Estudar sincronização e condições de corrida.
- [ ] Implementar exemplos com locks e classes atômicas.
- [ ] Explorar comunicação entre threads.
- [ ] Estudar `CompletableFuture`.
- [ ] Conhecer estruturas de dados concorrentes.
- [ ] Experimentar Virtual Threads.
- [ ] Consolidar o aprendizado em um projeto prático.

---

**Propósito:** aprender concorrência em Java por meio da prática, da análise de comportamento e da evolução incremental dos exemplos, documentando o processo e os resultados ao longo do tempo.