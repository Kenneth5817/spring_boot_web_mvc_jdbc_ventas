package org.iesvdm.dao;

import org.iesvdm.modelo.Pedido;

import java.util.List;

public interface PedidoDAO {
    // Método para obtener los pedidos de un comercial
    static List<Pedido> obtenerPedidosPorComercial(int idComercial);
}
