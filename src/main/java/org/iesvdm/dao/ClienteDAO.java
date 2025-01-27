package org.iesvdm.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;

public interface ClienteDAO {

	void create(Cliente cliente);

	List<Cliente> getAll();
	Map<Integer, Integer> getNumeroPedidosPorIDCliente;
	Optional<Cliente>  find(int id);
	
	void update(Cliente cliente);
	
	void delete(long id);
	List<Cliente> obtenerClientesPorTotalPedidos();
	double calcularTotalPedidosCliente(Cliente cliente);
}
