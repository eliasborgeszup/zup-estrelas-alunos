package br.com.zup.estrelas.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	AlunoRepository repository;
	
	@PostMapping
	public Aluno insereAluno(@RequestBody Aluno aluno) {
		return this.repository.save(aluno);
	}
	
	@DeleteMapping(path = "/delete/{matricula}")
	public String removeAluno(@PathVariable Long matricula) {
		this.repository.deleteById(matricula);
		
		return "Removido com sucesso";
	}
	
	@GetMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAluno(@PathVariable Long matricula) {
		return this.repository.findById(matricula).get();
	}
	
	@GetMapping(path = "/cpf/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAlunoCpf(@PathVariable String cpf) {
		return this.repository.findByCpf(cpf);
	}
	
	@GetMapping(path = "/nome/{nome}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAlunoNome(@PathVariable String nome) {
		return this.repository.findByNome(nome);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Aluno> buscaAlunos(){
		return (List<Aluno>) this.repository.findAll();
	}
	
}
