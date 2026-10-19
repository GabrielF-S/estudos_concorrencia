package br.com.gabrielf.aula1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithExecutorService {
    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            for (int i = 101; i <=105 ; i++) {
                int pedidoId = i;
                service.submit(()->{
                    processarPedido(pedidoId);
                });

            }


        }
        System.out.println("Todos os pedidos terminaram.");
        long end = System.currentTimeMillis();
        System.out.println("Tempo total: " + (end - init) + " ms");
    }

    private static void processarPedido(int pedidoId) {

        try {
            System.out.println("Iniciando pedido " + pedidoId + " na Thread" + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("Pedido " + pedidoId + " concluido");
        } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
        }
    }
}
