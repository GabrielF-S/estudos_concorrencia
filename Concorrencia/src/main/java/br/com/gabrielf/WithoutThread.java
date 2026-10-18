package br.com.gabrielf;

public class WithoutThread {
    public static void main(String[] args) throws InterruptedException {


        long init = System.currentTimeMillis();
        processarPedidos(101);
        processarPedidos(102);
        processarPedidos(103);
        long end = System.currentTimeMillis();
        System.out.println("Tempo total: " + (end - init) + " ms");

    }

    public static void  processarPedidos(int pedidoId) throws InterruptedException {

        System.out.println("Iniciando pedido: " + pedidoId );

        Thread.sleep(2000);

        System.out.println("Pedido "+ pedidoId  + " concluido");
    }
}