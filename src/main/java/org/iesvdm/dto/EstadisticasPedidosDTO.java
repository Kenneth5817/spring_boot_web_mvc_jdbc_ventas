package org.iesvdm.dto;

public class EstadisticasPedidosDTO {
    private int totalPedidos;
    private double mediaPedidos;

    // Getters y Setters
    public int getTotalPedidos() {
        return totalPedidos;
    }

    public void setTotalPedidos(int totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public double getMediaPedidos() {
        return mediaPedidos;
    }

    public void setMediaPedidos(double mediaPedidos) {
        this.mediaPedidos = mediaPedidos;
    }
}
