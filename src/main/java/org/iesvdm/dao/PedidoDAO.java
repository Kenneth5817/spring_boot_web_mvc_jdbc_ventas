package org.iesvdm.dao;

import org.iesvdm.modelo.Pedido;

import java.util.List;
import java.util.Map;

public interface PedidoDAO {
    //Método para obtener los pedidos de un comercial
    List<Pedido> obtenerPedidosPorComercial(int idComercial);

    Map<Long, Integer> getNumeroPedidosGroupByIdCliente();
}
