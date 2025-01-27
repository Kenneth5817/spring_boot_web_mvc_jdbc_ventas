package org.iesvdm.mapper;
import org.iesvdm.dto.ClienteDTO;
import org.iesvdm.modelo.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    public ClienteDTO clienteaClienteDTO(Cliente cliente, Integer numeroTotalPedidos);

    public Cliente clienteDTOACliente(ClienteDTO clienteDTO);
}
