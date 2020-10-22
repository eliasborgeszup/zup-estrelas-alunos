package br.com.zup.estrelas.alunos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository repository;
	
	public Aluno insereAluno(Aluno aluno) {	
		LocalDate date = LocalDate.of(1990, 30, 12);
		
		if(repository.existsById(aluno.getMatricula())) {
			if(aluno.getDataNascimento().isBefore(date) && aluno.getValorMensalidade() > 1000) {
				return null;
			}
			return null;
		}
		
		return this.repository.save(aluno);
	}
	
	public boolean removeAluno(Long matricula) {
		if (this.repository.existsById(matricula)) {
			this.repository.deleteById(matricula);
			return true;
		}

		return false;
	}
	
	public Aluno buscaAlunoMatricula(Long matricula) {
		Optional<Aluno> aluno = this.repository.findById(matricula);
		
		if(aluno.isPresent()) {
			return aluno.get();
		}
		
		return null;
	}
	
	public Aluno buscaAlunoCpf(String cpf) {
		Optional<Aluno> aluno = this.repository.findByCpf(cpf);
		
		if(aluno.isPresent()) {
			return aluno.get();
		}
		
		return null;
	}

	public Aluno buscaAlunoNome(String nome) {
		Optional<Aluno> aluno = this.repository.findByCpf(nome);
		
		if(aluno.isPresent()) {
			return aluno.get();
		}
		
		return null;
	}
	
	public List<Aluno> buscaAlunos(){
		/*
		 * List<Aluno> alunos = (List<Aluno>) this.repository.findAll();
		 * 
		 * if(alunos.isEmpty()) { return alunos; } return null;
		 */
		return (List<Aluno>) this.repository.findAll();
	}
	
	public Aluno alteraAluno(Long matricula, Aluno aluno) {
		if(this.repository.existsById(matricula) && matricula.equals(aluno.getMatricula())) {
			return this.repository.save(aluno);
		}
		return null;
	}
}
