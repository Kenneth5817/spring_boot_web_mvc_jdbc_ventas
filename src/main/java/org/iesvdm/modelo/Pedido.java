package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@Builder
public class Pedido {

    private int id;
    private double total;
    private Date fecha;

    public double getTotal() {
        return total;
    }

    private int id_cliente;
    private int id_comercial;

    public Pedido() {

    }

}
