package org.iesvdm.controlador;


import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.service.ClienteService;
import org.iesvdm.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ComercialController {

    private ComercialService comercialService;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired
    public ComercialController(ComercialService comercialService) {
        this.comercialService = comercialService;
    }

    //@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    //equivalente a la siguiente anotación
    @GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Comercial> listaComerciales =  comercialService.listAll();
        model.addAttribute("listaClientes", listaComerciales);

        return "clientes";

    }

    @GetMapping("/comercial/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {

        Comercial comercial = comercialService.one(id);
        model.addAttribute("producto", comercial);

        return "detalle-producto";

    }

    @GetMapping("/comercial/crear")
    public String crear(Model model) {

        Comercial comercial = new Comercial();
        model.addAttribute("comercial", comercial);

        return "crear-comercial";

    }

    @PostMapping("/comercial/crear")
    public RedirectView submitCrear(@ModelAttribute("comercial") Comercial comercial) {

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
    public RedirectView submitEditar(@ModelAttribute("producto") Comercial comercial) {

        comercialService.replaceComercial(comercial);

        return new RedirectView("/comercial");
    }

    @PostMapping("/comercial/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        comercialService.deleteComercial(id);

        return new RedirectView("/comercial");
    }

}
