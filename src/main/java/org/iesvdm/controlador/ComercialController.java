package org.iesvdm.controlador;
import lombok.AllArgsConstructor;
import org.iesvdm.exception.MiExcepcion;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.service.ComercialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
@AllArgsConstructor
public class ComercialController {
    public static ComercialService comercialService;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired

    //@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    //equivalente a la siguiente anotación
    @GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Comercial> listaComerciales =  comercialService.listAll();
        model.addAttribute("listaClientes", listaComerciales);

        return "clientes";

    }

    //Metodo modificado para poder mostrar en detalle mejor las cosas
    @GetMapping("/comercial/{id}")
    public String detalle(@PathVariable("id") int id, Model model) {
        Comercial comercial = comercialService.obtenerComercialConPedidos(id);
        model.addAttribute("comercial", comercial);
        return "detalle-comercial";
    }

    @GetMapping("/comercial/crear")
    public String crear(Model model) {

        Comercial comercial = new Comercial();
        model.addAttribute("comercial", comercial);

        return "crear-comercial";

    }

    @PostMapping("/comercial/crear")
    public RedirectView submitCrear(@Validated  @ModelAttribute("comercial") Comercial comercial) {

        comercialService.newComercial(comercial);

        return new RedirectView("/comercial") ;

    }

    @GetMapping("/comercial/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Comercial comercial = comercialService.one(id);
        model.addAttribute("producto", comercial);

        return "editar-comercial";

    }


    @PostMapping("/comercial/editar/{id}")
    public RedirectView submitEditar(@Validated @ModelAttribute("producto") Comercial comercial) {
        comercialService.replaceComercial(comercial);
        return new RedirectView("/comercial");
    }

    @PostMapping("/comercial/borrar/{id}")
    public RedirectView submitBorrar(@Validated @PathVariable Integer id) {

        comercialService.deleteComercial(id);

        return new RedirectView("/comercial");
    }
    @GetMapping("/probar-error")
    public String pruebaError() throws MiExcepcion {
        throw new MiExcepcion();
    }

    @GetMapping("/probar-error-generico")
    public String pruebaErrorGenerico() {
        throw new RuntimeException("Error inesperado");
    }
}
