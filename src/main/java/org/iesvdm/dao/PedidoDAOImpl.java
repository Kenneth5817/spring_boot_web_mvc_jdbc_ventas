package org.iesvdm.dao;

import org.iesvdm.modelo.Pedido;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PedidoDAOImpl implements PedidoDAO {

    private JdbcTemplate jdbcTemplate;

    public PedidoDAOImpl() {
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

    @Override
    public Map<Long, Integer> getNumeroPedidosGroupByIdCliente() {

        return jdbcTemplate.query("""
									select c.id, count(p.id) from cliente c 
    									left join pedido p on c.id = p.id_cliente
									group by c.id
									""",
                (rs) -> {

                    Map<Long, Integer> map = new HashMap<>();
                    while (rs.next()) {
                        map.put(rs.getLong(1), rs.getInt(2));
                    }

                    return map;
                }
        );

    }

}
