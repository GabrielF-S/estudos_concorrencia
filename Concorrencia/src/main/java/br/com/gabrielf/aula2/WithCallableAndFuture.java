package br.com.gabrielf.aula2;

import java.util.concurrent.*;

public class WithCallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (ExecutorService executorService  =Executors.newFixedThreadPool(3)){
            Callable<String> tarefaPedido101 = () -> {
                System.out.println("Processando pedido 101 na thread" + Thread.currentThread().getName());

                Thread.sleep(2000);
                return "Pedido 101 processado com sucesso!";
            };
            Future<String> future = executorService.submit(tarefaPedido101);

            System.out.println("Tarefa enviada ao Executor");

            String resultado = future.get();
            System.out.println("Resultado: " + resultado);
        }

    }
}
