package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Pedido {

    private int id;
    private double total;
    private Date fecha;
    private int id_cliente;
    private int id_comercial;

    public Pedido() {

    }

}
