package br.com.zup.estrelas.alunos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.zup.estrelas.alunos.entity.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	Optional<Aluno> findByCpf(String cpf);
	Optional<Aluno> findByNome(String nome);
}