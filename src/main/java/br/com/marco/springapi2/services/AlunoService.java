package br.com.marco.springapi2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marco.springapi2.domain.Aluno;
import br.com.marco.springapi2.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repo;
	
	public List<Aluno> buscarTodosPorNome(String nome) {
		return this.repo.findAllByNome(nome);
	}
	
	public List<Aluno> buscarTodos(){
		return this.repo.findAll();
	}
	
	public Aluno buscarPorId(Integer id) {
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException("Objeto não encontrado."));
	}
	
	public void apagarPorId(Integer id) {
		this.repo.deleteById(id);
	}
	
	public Aluno atualizar(Aluno a) {
		return this.repo.save(a);
	}
	
	public Aluno cadastrar(Aluno a) {
		a.setId(null);
		return this.repo.save(a);
	}
	
}
