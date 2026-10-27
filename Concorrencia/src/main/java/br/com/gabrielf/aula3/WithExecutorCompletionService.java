package br.com.gabrielf.aula3;

import java.util.concurrent.*;

public class WithExecutorCompletionService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

            for(int i = 101 ; i<=105; i++){
                int pedidoId = i;

                Callable<String> tarefa = () -> {
                    int tempo = pedidoId == 101?4000: 2000;
                    System.out.println("Iniciado pedido " + pedidoId + " na thread " + Thread.currentThread().getName());
                    Thread.sleep(tempo);

                    return "Pedido " + pedidoId + " processado em " + tempo + " ms";
                };

                completionService.submit(tarefa);
            }
            for (int i = 0; i < 5; i++){
                Future<String> future = completionService.take();
                System.out.println(future.get());
            }
        }


    }
}
