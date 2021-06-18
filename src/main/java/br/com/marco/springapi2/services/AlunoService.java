package br.com.marco.springapi2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.marco.springapi2.domain.Aluno;
import br.com.marco.springapi2.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	Logger LOG = LoggerFactory.getLogger(AlunoService.class);

	@Autowired
	AlunoRepository repo;
	
	public Page<Aluno> buscarTodosPorNome(String nome, PageRequest pageRequest) {
		return this.repo.findAllByNomeContaining(nome, pageRequest);
	}
	
	public Page<Aluno> buscarTodos(PageRequest pageRequest){
		return this.repo.findAll(pageRequest);
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
		Aluno alunoCadastrado = this.repo.save(a);
		LOG.info("Aluno cadastrado com sucesso: " + alunoCadastrado);
		return alunoCadastrado;
		
	}
	
}
