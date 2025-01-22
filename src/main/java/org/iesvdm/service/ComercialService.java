package org.iesvdm.service;

import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;

import java.util.List;
import java.util.Optional;

public class ComercialService {
    private ComercialDAO comercialDAO;
    private PedidoDAO pedidoDAO;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired
    public ComercialService(ComercialDAO comercialDAO, PedidoDAO pedidoDAO) {
        this.comercialDAO = comercialDAO;
        this.pedidoDAO = pedidoDAO;
    }

    public List<Comercial> listAll() {

        return comercialDAO.getAll();

    }
    public Comercial one(Integer id) {
        Optional<Comercial> optFab = comercialDAO.find(id);
        if (optFab.isPresent())
            return optFab.get();
        else
            return null;
    }

    public void newComercial(Comercial comercial) {

        comercialDAO.create(comercial);

    }

    public void replaceComercial(Comercial comercial) {

        comercialDAO.update(comercial);

    }

    public void deleteComercial(int id) {
        comercialDAO.delete(id);

    }

    // Obtener el comercial y sus pedidos
    public Comercial obtenerComercialConPedidos(int idComercial) {
        Comercial comercial = comercialDAO.obtenerComercialPorId(idComercial);
        if (comercial != null) {
            List<Pedido> pedidos = PedidoDAO.obtenerPedidosPorComercial(idComercial);
            comercialDAO.update((Comercial) pedidos); // Asumiendo que la clase Comercial tiene una lista de pedidos
        }
        return comercial;
    }
}

