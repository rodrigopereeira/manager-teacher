package br.com.rodrigo.integrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodrigo.integrador.dao.ComboDAO;
import br.com.rodrigo.integrador.dao.CursoDAO;
import br.com.rodrigo.integrador.modelo.Curso;

@Controller
public class CursoController {

	ComboDAO daoGeral = new ComboDAO();
	CursoDAO dao = new CursoDAO();
	
	@RequestMapping("novoCurso")
	public String form(Model model) {
		model.addAttribute("especialidades", daoGeral.listaEspecialidade());
		return "curso/adiciona-curso";
	}

	@RequestMapping("adicionaCurso")
	public String adiciona(@Valid Curso curso, BindingResult result) {
		
		if(result.hasFieldErrors("nome")) {
		      return "forward:novoCurso";
		} 
		
		dao.adiciona(curso);
		return "redirect:listaCursos";
	}

	@RequestMapping("removeCurso")
	public String remove(Curso curso) {
		dao.remove(curso);
		return "redirect:listaCursos";
	}

	@RequestMapping("listaCursos")
	public String lista(Model model) {
		List<Curso> cursos = dao.lista();
		model.addAttribute("cursos", cursos);
		return "curso/lista-curso";
	}

	@RequestMapping("mostraCurso")
	public String mostra(int id, Model model) {
		model.addAttribute("curso", dao.buscaPorId(id));
		model.addAttribute("especialidades", daoGeral.listaEspecialidade());
		return "curso/mostra-curso";
	}

	@RequestMapping("alteraCurso")
	public String altera(Curso curso) {
		dao.altera(curso);
		return "redirect:listaCursos";
	}
	
}
