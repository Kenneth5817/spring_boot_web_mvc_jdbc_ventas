package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dto.EstadisticasPedidosDTO;
import org.iesvdm.modelo.Comercial;

public interface ComercialDAO {

     void create(Comercial cliente);

	 List<Comercial> getAll();

	 Optional<Comercial>  find(int id);
	
	 void update(Comercial cliente);
	
	 void delete(long id);

	Comercial obtenerComercialPorId(int idComercial);
	public EstadisticasPedidosDTO obtenerEstadisticasComercial(int idComercial);
}
