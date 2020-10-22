package br.com.zup.estrelas.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	AlunoService alunoservice;
	
	@PostMapping
	public Aluno insereAluno(@RequestBody Aluno aluno) {
		return this.alunoservice.insereAluno(aluno);
	}

	@DeleteMapping(path = "/{matricula}")
	public boolean removeAluno(@PathVariable Long matricula) {
		return this.alunoservice.removeAluno(matricula);
	}

	@GetMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno buscaAlunoMatricula(@PathVariable Long matricula) {
		return this.alunoservice.buscaAlunoMatricula(matricula);
	}

	@GetMapping(path = "/cpf/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno buscaAlunoCpf(@PathVariable String cpf) {
		return this.alunoservice.buscaAlunoCpf(cpf);
	}

	@GetMapping(path = "/nome/{nome}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno buscaAlunoNome(@PathVariable String nome) {
		return this.alunoservice.buscaAlunoNome(nome);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Aluno> buscaAlunos() {
		return this.alunoservice.buscaAlunos();
	}
	
	@PutMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno alteraAluno(@PathVariable Long matricula, @RequestBody Aluno aluno) {
		return this.alunoservice.alteraAluno(matricula, aluno);
	}

}
