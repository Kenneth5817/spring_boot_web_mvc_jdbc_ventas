package org.iesvdm.controlador;
import java.util.List;
import lombok.AllArgsConstructor;
import org.iesvdm.exception.MiExcepcion;
import org.iesvdm.mapper.ClienteMapper;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	private ClienteMapper clienteMapper;
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	
	//@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Cliente> listaClientes =  clienteService.listAll();
		model.addAttribute("listaClientes", listaClientes);
				
		return "clientes";
		
	}


	@GetMapping("/clientes/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {

		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);

		return "detalle-cliente";

	}

	@GetMapping("/clientes/crear")
	public String crear(Model model) {

		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);

		return "crear-cliente";

	}

	

	@GetMapping("/fabricantes/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {

		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);

		return "editar-cliente";

	}


	@PostMapping("/clientes/editar/{id}")
	public RedirectView submitEditar(@Validated @ModelAttribute("clientes") Cliente cliente) {

		clienteService.replaceCliente(cliente);

		return new RedirectView("/clientes");
	}

	@PostMapping("/clientes/borrar/{id}")
	public RedirectView submitBorrar(@Validated @PathVariable Integer id) {

		clienteService.deleteCliente(id);

		return new RedirectView("/clientes");
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

	
	
