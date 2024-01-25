package br.com.mattosinho;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.mattosinho.Helper.Utils;
import br.com.mattosinho.exceptions.ResourceNotFoundException;

@RestController
public class CalculadoraController {
	
	@RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double Soma(
			@PathVariable(value = "numeroUm")String numeroUm,
			@PathVariable(value = "numeroDois")String numeroDois) throws Exception {
		
		if (!Utils.eNumerico(numeroUm) || !Utils.eNumerico(numeroDois)) {
			throw new ResourceNotFoundException("Iserir um valor numerico!");
		}
		
		return Double.parseDouble(numeroUm) + Double.parseDouble(numeroDois);
	}
}
