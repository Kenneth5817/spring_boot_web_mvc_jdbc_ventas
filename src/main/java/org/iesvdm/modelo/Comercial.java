package org.iesvdm.modelo;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Comercial {

	private int id;

	//El campo esobligatorio, como mucho 30 caracteres
	@NotNull(message = "El nombre es obligatorio")
	@Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
	private String nombre;

	//Campo obligatorio, como mucho debe de tener 30 caracteres
	@NotNull(message = "El primer apellido es obligatorio")
	@Size(max = 30, message = "El primer apellido no puede tener más de 30 caracteres")
	private String apellido1;

	//Campo debe de tener como mucho 30 caracteres, peeeeero, puede estar vacio
	@Size(max = 30, message = "El segundo apellido no puede tener más de 30 caracteres")
	private String apellido2;

	//Usamos BigDecimal en vez de float/double para la comisión
	//Validación: hay que rellenar, rango de 0.276 a 0.946
	@NotNull(message = "La comisión es obligatoria")
	@DecimalMin(value = "0.276", inclusive = true, message = "La comisión debe ser al menos 0.276")
	@DecimalMax(value = "0.946", inclusive = true, message = "La comisión no puede ser mayor que 0.946")
	private BigDecimal comision;
	public Comercial() {

	}

}
