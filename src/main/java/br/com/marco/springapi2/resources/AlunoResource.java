package br.com.marco.springapi2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.marco.springapi2.domain.*;
import br.com.marco.springapi2.services.AlunoService;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

	@Autowired
	AlunoService alunoService;

	@RequestMapping(method = RequestMethod.GET, path = "")
	public ResponseEntity<Page<Aluno>> buscar(@RequestParam(defaultValue = "0", name = "page") Integer npage,
			@RequestParam(defaultValue = "10", name = "maxRows") Integer quantidade) {
		PageRequest pg = PageRequest.of(npage, quantidade);
		return ResponseEntity.ok(alunoService.buscarTodos(pg));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(alunoService.buscarPorId(id));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/filtrado")
	public ResponseEntity<Page<Aluno>> buscarFiltradoPorNome(
			@RequestParam(defaultValue = "", name = "buscar") String busca,
			@RequestParam(defaultValue="0", name="page") Integer npage,
			@RequestParam(defaultValue="10", name="maxRows") Integer quantidade)
	{
		PageRequest pg = PageRequest.of(npage, quantidade);
		return ResponseEntity.ok(alunoService.buscarTodosPorNome(busca, pg));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<Void> apagarPorId(@PathVariable("id") Integer id) {
		alunoService.apagarPorId(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> cadastrar(@RequestBody Aluno a) {
		Aluno created = alunoService.cadastrar(a);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Aluno a, @PathVariable("id") Integer id) {
		a.setId(id);
		alunoService.atualizar(a);
		return ResponseEntity.noContent().build();
	}

}
