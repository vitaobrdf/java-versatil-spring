package br.com.marco.springapi2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.marco.springapi2.domain.Aluno;
import br.com.marco.springapi2.services.AlunoService;

@SpringBootTest
class Springapi2ApplicationTests {

	@Autowired
	AlunoService alunoService;

	@Test
	void contextLoads() {
Aluno a = alunoService.buscarPorId(1);
Assertions.assertEquals("Victor", a.getNome());
}
	
	@Test
	void testarSeObjeto2EMarcos () {
		Aluno a = alunoService.buscarPorId(3);
		Assertions.assertEquals(3, a.getId());
	}
	
}
