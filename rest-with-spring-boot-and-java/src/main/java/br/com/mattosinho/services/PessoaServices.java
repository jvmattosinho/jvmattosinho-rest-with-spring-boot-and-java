package br.com.mattosinho.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.mattosinho.exceptions.ResourceNotFoundException;
import br.com.mattosinho.model.Pessoa;
import br.com.mattosinho.repositories.PessoaRepository;

@Service
public class PessoaServices {
	
	@Autowired
	PessoaRepository repository;
	
	public List<Pessoa> ObterTodos() {
		return repository.findAll();
	}
	
	public Pessoa ObterPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontrado com esse id!"));
	}
	
	public Pessoa Cadastra(Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	public Pessoa Atualiza(Pessoa pessoa) {
		Pessoa entity = repository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não encontrado com esse id!"));
		
		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setSexo(pessoa.getSexo());
		
		return repository.save(entity);
	}
	
	public void Excluir(Long id) {
		Pessoa entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontrado com esse id!"));
		
		repository.delete(entity);
	}
}
