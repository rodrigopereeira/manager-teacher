package br.com.rodrigo.integrador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigo.integrador.dao.AlunoDAO;
import br.com.rodrigo.integrador.dao.CursoDAO;
import br.com.rodrigo.integrador.dao.FilesDAO;
import br.com.rodrigo.integrador.dao.ProfessorDAO;
import br.com.rodrigo.integrador.dao.SalaDAO;
import br.com.rodrigo.integrador.dao.TurmaDAO;
import br.com.rodrigo.integrador.modelo.Files;
import br.com.rodrigo.integrador.modelo.Matricula;
import br.com.rodrigo.integrador.modelo.Turma;

@Controller
public class TurmaController {
	
	TurmaDAO dao = new TurmaDAO();
	AlunoDAO daoAluno = new AlunoDAO();
	CursoDAO daoCurso = new CursoDAO();
	SalaDAO daoSala = new SalaDAO();
	ProfessorDAO daoProfessor = new ProfessorDAO();
	
	String problema = new String();

	@RequestMapping("novaTurma")
	public String novaTurma(Model model) {
		model.addAttribute("cursos", daoCurso.lista());
		model.addAttribute("professores", daoProfessor.lista());
		model.addAttribute("salas", daoSala.lista());
		return "turma/adiciona-turma";
	}
	
	@RequestMapping("adicionaTurma")
	public String adiciona(@Valid Turma turma, Model model) throws ParseException {
		int capacidade = dao.verificaSalaCapacidade(turma);
		if (capacidade < turma.getVagas()) {
			model.addAttribute("erroCapacidade", "A sala não suporta a quantidade de alunos!");
		} 			
		if (dao.verificaProfessorDisponivel(turma) == true ) {
			model.addAttribute("erroProfessor", "O professor não esta disponivel nesta data!");
		} 
		if (dao.verificaSalaDisponivel(turma)  == true ) {
			model.addAttribute("erroSala", "A sala não esta disponivel nesta data!");
			model.addAttribute("turmaForm", turma);
		} else {
			dao.adiciona(turma);
			return "redirect:listaTurmas";
		}
			
		// se der errado os metodos ele direciona pra nova turma
		return novaTurma(model);
	}

	@RequestMapping("removeTurma")
	public String remove(Turma turma) {
		dao.remove(turma);
		return "redirect:listaTurmas";
	}

	@RequestMapping("listaTurmas")
	public String lista(Model model) {
		List<Turma> turmas = dao.lista();
		model.addAttribute("turmas", turmas);
		return "turma/lista-turma";
	}

	@RequestMapping("mostraTurma")
	public String mostra(int id, Model model) {
		model.addAttribute("turma", dao.buscaPorId(id));
		model.addAttribute("cursos", daoCurso.lista());
		model.addAttribute("professores", daoProfessor.lista());
		model.addAttribute("salas", daoSala.lista());
		return "turma/mostra-turma";
	}

	@RequestMapping("alteraTurma")
	public String altera(Turma turma) {
		dao.altera(turma);
		return "redirect:listaTurmas";
	}
	
	@RequestMapping("novaMatricula")
	public String form(Model model) {
		model.addAttribute("turmasDisponiveis", dao.listaCursoDisponivel());
		model.addAttribute("alunos", daoAluno.lista());

		return "turma/matricula-aluno";
	}
	
	@RequestMapping("matriculaAluno")
	public String matricula(Matricula matricula, BindingResult result, Model model) {
		
		dao.matricula(matricula);
		
		Turma novaTurma = new Turma();
		novaTurma.setCodigoTurma(matricula.getCodigoTurma());
		//mostra a turma com o codigo da turma q esta na matricula
		return selecionarTurma(novaTurma, model);
	}
	
	@RequestMapping("mostrarTurma")
	public String mostrarTurma(Model model) {
		List<Turma> turmas = dao.lista();
		model.addAttribute("turmas", turmas);
		return "turma/mostrar-turmas";
	}
	
	@RequestMapping("selecionarTurma")
	public String selecionarTurma(Turma turma, Model model) {
		List<Turma> turmas = dao.listaAlunos(turma);
		model.addAttribute("turmasAlunos", turmas);
		if (turmas.isEmpty()) {
			model.addAttribute("nomeTurma", "Não existem alunos");
		} else {
			model.addAttribute("nomeTurma", turmas.get(0).getNome());
			model.addAttribute("turmasAlunos", turmas);
		}
		return "turma/listar-alunos";
	}
	
	@RequestMapping(value = "/visualizarDocumentosTurma", method = RequestMethod.GET)
	public ModelAndView visualizarDocumentosTurma(Model model, int id) throws IOException {
		
		FilesDAO daoF = new FilesDAO();
		List<Files> files = daoF.listAll(id);

		model.addAttribute("codigoTurma", id);
	    return new ModelAndView("turma/lista-documentos-turma", "files", files);
	}
		
}
