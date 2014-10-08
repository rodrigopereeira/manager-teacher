package br.com.rodrigo.integrador.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigo.integrador.dao.AlunoDAO;
import br.com.rodrigo.integrador.dao.ComboDAO;
import br.com.rodrigo.integrador.dao.FilesDAO;
import br.com.rodrigo.integrador.modelo.Aluno;
import br.com.rodrigo.integrador.modelo.Files;
import br.com.rodrigo.integrador.modelo.Matricula;
import br.com.rodrigo.integrador.modelo.Notas;
import br.com.rodrigo.integrador.modelo.Presenca;
import br.com.rodrigo.integrador.modelo.Turma;
import br.com.rodrigo.integrador.modelo.Usuario;

@Controller
public class AlunoController {

	ComboDAO daoGeral = new ComboDAO();
	AlunoDAO dao = new AlunoDAO();

	@RequestMapping("novoAluno")
	public String form(Model model) {
		model.addAttribute("sexos", daoGeral.listaSexo());
		model.addAttribute("estadosCivis", daoGeral.listaEstadoCivil());
		model.addAttribute("estados", daoGeral.listaEstado());
		return "aluno/adiciona-aluno";
	}

	@RequestMapping("adicionaAluno")
	public String adiciona(Aluno aluno, BindingResult result) {
		dao.adiciona(aluno);
		return "redirect:listaAlunos";
	}

	@RequestMapping("removeAluno")
	public String remove(Aluno aluno) {
		dao.remove(aluno);
		return "redirect:listaAlunos";
	}

	@RequestMapping("listaAlunos")
	public String lista(Model model) {
		List<Aluno> alunos = dao.lista();
		model.addAttribute("alunos", alunos);
		return "aluno/lista-aluno";
	}

	@RequestMapping("mostraAluno")
	public String mostra(int id, Model model) {
		model.addAttribute("aluno", dao.buscaPorId(id));
		model.addAttribute("sexos", daoGeral.listaSexo());
		model.addAttribute("estadosCivis", daoGeral.listaEstadoCivil());
		model.addAttribute("estados", daoGeral.listaEstado());
		return "aluno/mostra-aluno";
	}

	@RequestMapping("alteraAluno")
	public String altera(Aluno aluno) {
		dao.altera(aluno);
		return "redirect:listaAlunos";
	}
	
	@RequestMapping("mostrarTurmasAluno")
	public String selecionarTurma(Aluno aluno, Model model) {
		model.addAttribute("codigoAluno", aluno.getCodigoAluno());
		List<Matricula> matriculas = dao.listaTurmas(aluno);
		model.addAttribute("alunoTurma", matriculas);
		if (matriculas.isEmpty()) {
			model.addAttribute("nomeAluno", "O aluno não esta em nenhuma turma");
		} else {
			model.addAttribute("nomeAluno", matriculas.get(0).getNomeAluno());
			model.addAttribute("alunoTurma", matriculas);
		}
		return "aluno/turmas-aluno";
	}
	
	@RequestMapping(value = "/notas", method = RequestMethod.GET)
	public ModelAndView postarNotas(Model model, HttpSession session) {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		List<Notas> notasLista = dao.listaNotasAluno(usuario.getIdentificacao()); 
		
	    return new ModelAndView("aluno/mostrar-notas" , "alunosNotas", notasLista);
	}
	
	@RequestMapping(value = "/presencas", method = RequestMethod.GET)
	public ModelAndView visualizarPresenca(Model model, HttpSession session) {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		List<Turma> turmasLista = dao.listaTurmasAluno(usuario.getIdentificacao()); 

	    return new ModelAndView("aluno/mostrar-turmas-aluno" , "turmas", turmasLista);
	}
	
	@RequestMapping(value = "/presencasTurma", method = RequestMethod.GET)
	public ModelAndView visualizarPresencasTurma(Model model, HttpSession session, Turma turma) {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		List<Presenca> presencasLista = dao.listaPresencasTurma(usuario.getIdentificacao(), turma.getCodigoTurma()); 

	    return new ModelAndView("aluno/mostrar-presencas" , "presencas", presencasLista);
	}
	
	@RequestMapping(value = "/documentos", method = RequestMethod.GET)
	public ModelAndView visualizarDocumentos(Model model, HttpSession session) {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		List<Turma> turmasLista = dao.listaTurmasAluno(usuario.getIdentificacao()); 

	    return new ModelAndView("aluno/mostrar-turmas-aluno-doc" , "turmas", turmasLista);
	}
	
	@RequestMapping(value = "/documentosTurma", method = RequestMethod.GET)
	public ModelAndView visualizarDocumentosTurma( Turma turma) {
		FilesDAO daoF = new FilesDAO();
		
		List<Files> files = daoF.listAll(turma.getCodigoTurma());
		
		return new ModelAndView("aluno/lista-documentos-turma", "files", files);
	}

}
