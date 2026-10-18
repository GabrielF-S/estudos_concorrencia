package br.com.gabrielf.excer1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long initThread = System.nanoTime();

        Runnable tarefa1  = () -> processarPedido(101);
        Runnable tarefa2  = () -> processarPedido(102);
        Runnable tarefa3  = () -> processarPedido(103);
        Runnable tarefa4  = () -> processarPedido(104);
        Runnable tarefa5  = () -> processarPedido(105);

        Thread pedido101 = new Thread(tarefa1);
        Thread pedido102 = new Thread(tarefa2);
        Thread pedido103 = new Thread(tarefa3);
        Thread pedido104 = new Thread(tarefa4);
        Thread pedido105 = new Thread(tarefa5);



        pedido101.start();
        pedido102.start();
        pedido103.start();
        pedido104.start();
        pedido105.start();

        pedido101.join();
        pedido102.join();
        pedido103.join();
        pedido104.join();
        pedido105.join();

        long endThread = System.nanoTime();


        System.out.println("Processo Thread finalizado, tempo total: " + (endThread - initThread)/1_000_000 + " ms");

        long initExecutors = System.nanoTime();
        try(ExecutorService executorService = Executors.newFixedThreadPool(2)){
            for (int i = 101; i <=105 ; i++) {
                int pedidoId = i;
                executorService.submit(() -> processarPedido(pedidoId));

            }

        }
        System.out.println("Todos os pedidos terminaram.");
        long endExecutors = System.nanoTime();
        System.out.println("Ptocesso ExecutorService finalizado, tempo total: " + (endExecutors - initExecutors)/1_000_000 + " ms");


    }

    private static void processarPedido(int pedidoId) {

        try {
            System.out.println("Pedido " + pedidoId + " iniciado na thread: " + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("Pedido " + pedidoId + " finalizado");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
