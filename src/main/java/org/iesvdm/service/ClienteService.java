package org.iesvdm.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.dao.ClienteDAOImpl;
import org.iesvdm.dto.ClienteDTO;
import org.iesvdm.mapper.ClienteMapper;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Pedido;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	private final ClienteDAOImpl clienteDAOImpl;
	private ClienteDAO clienteDAO;
	private ClienteMapper clienteMapper;
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ClienteService(ClienteDAO clienteDAO, ClienteDAOImpl clienteDAOImpl) {
		this.clienteDAO = clienteDAO;
		this.clienteDAOImpl = clienteDAOImpl;
	}
	
	public List<Cliente> listAll() {
		List<Cliente>listCliente=clienteDAO.getAll();
		Map<Integer,Integer> mapNumBYPedIdCli=clienteDAOImpl.getNumeroPedidosPorIDCliente();
		List<ClienteDTO> ListClienteDTO= (List<ClienteDTO>) listCliente.stream()
				.map(cliente -> clienteMapper.clienteaClienteDTO
						(cliente, mapNumBYPedIdCli.get(cliente.getId())));
		return clienteDAO.getAll();
	}

	public Cliente one(Integer id) {
		Optional<Cliente> optFab = clienteDAO.find(id);
		if (optFab.isPresent())
			return optFab.get();
		else
			return null;
	}

	public void newCliente(Cliente cliente) {

		this.clienteDAO.create(cliente);

	}

	public void replaceCliente(Cliente cliente) {

		clienteDAO.update(cliente);

	}

	public void deleteCliente(int id) {

		clienteDAO.delete(id);

	}

	public List<Cliente> obtenerClientesPorTotalPedidos() {
		// Obtenemos todos los clientes de la base de datos
		List<Cliente> clientes = clienteDAO.getAll();

		// Ordenamos los clientes por el total de sus pedidos, de mayor a menor
		return clientes.stream()
				.sorted(Comparator.comparingDouble(this::calcularTotalPedidosCliente).reversed())
				.collect(Collectors.toList());
	}

	public double calcularTotalPedidosCliente(Cliente cliente) {
		// Calculamos el total de los pedidos de un cliente
		return cliente.getPedidos().stream().mapToDouble(Pedido::getTotal).sum();
	}
}
