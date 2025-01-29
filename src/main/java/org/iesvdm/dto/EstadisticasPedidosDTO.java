package org.iesvdm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesvdm.modelo.Cliente;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

