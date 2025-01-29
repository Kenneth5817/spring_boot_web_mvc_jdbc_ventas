package org.iesvdm.modelo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//La anotación @Data de lombok proporcionará el código de:
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@Builder
public class Cliente {
	
	private long id;
	// Validación: obligatorio, longitud máxima de 30 caracteres
	@NotNull(message = "El nombre es obligatorio")
	@Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
	private String nombre;

	// Validación: obligatorio, longitud máxima de 30 caracteres
	@NotNull(message = "El primer apellido es obligatorio")
	@Size(max = 30, message = "El primer apellido no puede tener más de 30 caracteres")
	private String apellido1;

	@Size(max = 30, message = "El segundo apellido no puede tener más de 30 caracteres")
	private String apellido2;

	//Validación: obligatorio, longitud máxima de 50 caracteres
	@NotNull(message = "La ciudad es obligatoria")
	@Size(max = 50, message = "La ciudad no puede tener más de 50 caracteres")
	private String ciudad;

	//Validación: obligatorio, rango de valores de 100 a 1000
	@NotNull(message = "La categoría es obligatoria")
	@Min(value = 100, message = "La categoría debe ser al menos 100")
	@Max(value = 1000, message = "La categoría no puede ser mayor que 1000")
	private int categoria;

	//Validación: obligatorio, formato de correo electrónico
	@NotNull(message = "El correo electrónico es obligatorio")
	@Email(message = "El correo electrónico no tiene un formato válido")
	private String email;

	private List<Pedido>pedidos;
	public Cliente() {

	}

	public Cliente(int id, String nombre, String apellido1, String apellido2, String ciudad, int categoría) {
	}
}
