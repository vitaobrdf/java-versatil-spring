package br.com.marco.springapi2.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marco.springapi2.domain.Aluno;

/*
 * PARA INJETAR UM REPOSITORIO DO SPRING BOOT, A INTERFACE DEVE EXTENDER A CLASSE 
 * DE ATRIBUIÇÃO DO FRAMEWORK
 */

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	Page<Aluno> findAllByNomeContaining(String nome, Pageable pageable);
}
