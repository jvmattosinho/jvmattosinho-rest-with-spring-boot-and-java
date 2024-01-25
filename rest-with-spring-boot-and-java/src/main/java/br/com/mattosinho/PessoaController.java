package br.com.mattosinho;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.mattosinho.model.Pessoa;
import br.com.mattosinho.services.PessoaServices;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaServices pessoaServices; 
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> ObterTodos() {
		return pessoaServices.ObterTodos();
	}
	
	@GetMapping(value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa ObterPorId(@PathVariable(value = "id") Long id) {
		return pessoaServices.ObterPorId(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa Cadastra(@RequestBody Pessoa pessoa) {
		return pessoaServices.Cadastra(pessoa);
	}
	
	@PutMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa Atualiza(@RequestBody Pessoa pessoa) {
		return pessoaServices.Atualiza(pessoa);
	}
	
	@DeleteMapping(value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> Excluir(@PathVariable(value = "id") Long id) {
		pessoaServices.Excluir(id);
		return ResponseEntity.noContent().build();
	}
}
