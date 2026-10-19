package br.com.gabrielf.aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WithCallableAndFutureExtended {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (ExecutorService service = Executors.newFixedThreadPool(3)) {
            List<Future<String>> resultados = new ArrayList<>();
            for (int i = 101; i <= 105; i++) {
                int pedidoId = i;

                Callable<String> tarefa = () -> {
                    if (pedidoId == 101){
                        Thread.sleep(4000);
                    }else {
                        Thread.sleep(2000);
                    }

                    return "Pedido: " + pedidoId + " processado";
                };

                Future<String> future = service.submit(tarefa);
                resultados.add(future);
            }
            System.out.println("Todos os pedidos foram enviados.");
            for (Future<String> resultado : resultados) {
                System.out.println(resultado.get());
            }
        }
    }
}
