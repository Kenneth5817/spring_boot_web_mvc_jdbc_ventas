package org.iesvdm.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComercialDTO {
    private long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private BigDecimal comisión;

}
