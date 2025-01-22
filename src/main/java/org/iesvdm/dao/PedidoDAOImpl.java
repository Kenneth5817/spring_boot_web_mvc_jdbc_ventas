package org.iesvdm.dao;

import org.iesvdm.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoDAOImpl implements PedidoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PedidoDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método para obtener los pedidos de un comercial
    @Override
    public List<Pedido> obtenerPedidosPorComercial(int idComercial) {
        String query = "SELECT * FROM pedidos WHERE id_comercial = ?";

        return jdbcTemplate.query(query, new Object[]{idComercial}, (rs, rowNum) -> {
            Pedido pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setTotal(rs.getDouble("total"));
            pedido.setFecha(rs.getDate("fecha"));
            pedido.setId_cliente(rs.getInt("id_cliente"));
            pedido.setId_comercial(rs.getInt("id_comercial"));
            return pedido;
        });
    }
}
