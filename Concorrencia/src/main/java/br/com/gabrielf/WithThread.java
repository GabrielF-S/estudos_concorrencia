package br.com.gabrielf;

public class WithThread {
    public static void main(String[] args) {


        Runnable tarefa1 = () -> processarPedido(101);

        Thread pedido101 = new Thread(tarefa1);
        Thread pedido102 = new Thread(() -> processarPedido(102));
        Thread pedido103 = new Thread(() -> processarPedido(103));

        pedido101.start();
        pedido102.start();
        pedido103.start();


    }

    public static void processarPedido( int pedidoId){

        try {
            System.out.printf("Iniciando peidido: %d na Thread %s%n", pedidoId, Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.printf("Pedido %d finalizado%n", pedidoId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Pedido %d interrompido", pedidoId);

        }
    }
}
