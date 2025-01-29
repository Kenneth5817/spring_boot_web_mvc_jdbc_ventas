package org.iesvdm.controlador;

import org.iesvdm.exception.MiExcepcion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class VentasControllerAdvice {

    // Manejador para MiExcepcion
    @ExceptionHandler(MiExcepcion.class)
    public String handlerMiExcepcion(Model model, MiExcepcion miExcepcion){
        model.addAttribute("traza", miExcepcion.getMessage());
        return "error-mi-excepcion";  // Nombre de la vista para error personalizado
    }

    // Manejador para RuntimeException
    @ExceptionHandler(RuntimeException.class)
    public String handleAllUncaughtException(Model model, RuntimeException exception){
        model.addAttribute("traza", exception.getMessage());
        return "error";  // Vista genérica para otros errores
    }
}
