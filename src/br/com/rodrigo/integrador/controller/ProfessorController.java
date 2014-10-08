package br.com.rodrigo.integrador.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigo.integrador.dao.ComboDAO;
import br.com.rodrigo.integrador.dao.ProfessorDAO;
import br.com.rodrigo.integrador.modelo.Notas;
import br.com.rodrigo.integrador.modelo.Presenca;
import br.com.rodrigo.integrador.modelo.Professor;
import br.com.rodrigo.integrador.modelo.ProfessorOcupado;
import br.com.rodrigo.integrador.modelo.Turma;
import br.com.rodrigo.integrador.modelo.Usuario;

@Controller
public class ProfessorController {

	ComboDAO daoGeral = new ComboDAO();
	ProfessorDAO dao = new ProfessorDAO();
	
	@RequestMapping("novoProfessor")
	public String form(Model model) {
	    model.addAttribute("sexos", daoGeral.listaSexo());
	    model.addAttribute("estadosCivis", daoGeral.listaEstadoCivil());
	    model.addAttribute("estados", daoGeral.listaEstado());
	    model.addAttribute("especialidades", daoGeral.listaEspecialidade());
	    return "professor/adiciona-professor";
	}
	
	@RequestMapping("adicionaProfessor")
	public String adiciona(Professor professor, BindingResult result) {
	    dao.adiciona(professor);
	    return "redirect:listaProfessores";
	}

	@RequestMapping("removeProfessor")
	  public String remove(Professor professor) {
	    dao.remove(professor);
	    return "redirect:listaProfessores";
	}	
	
	@RequestMapping("listaProfessores")
	public String lista(Model model) {
	    List<Professor> professores = dao.lista(); 
	    model.addAttribute("professores", professores);
	    return "professor/lista-professor";
	}
	
	@RequestMapping("listaProfessoresOcupados")
	public String listaOcupadas(Model model) {
		List<ProfessorOcupado> professoresOcupados = dao.listaReserva();
		model.addAttribute("professoresOcupados", professoresOcupados);
		return "professor/lista-professorOcupado";
	}
	
	@RequestMapping("mostraProfessor")
	public String mostra(int id, Model model) {
	    model.addAttribute("professor", dao.buscaPorId(id));
	    model.addAttribute("sexos", daoGeral.listaSexo());
	    model.addAttribute("estadosCivis", daoGeral.listaEstadoCivil());
	    model.addAttribute("estados", daoGeral.listaEstado());
	    model.addAttribute("especialidades", daoGeral.listaEspecialidade());
	    return "professor/mostra-professor";
	}
	
	@RequestMapping("alteraProfessor")
	public String altera(Professor professor) {
	    dao.altera(professor);
	    return "redirect:listaProfessores";
	}
	
	@RequestMapping("visualizarPresenca")
	public String listaTurmasProfessor(Model model, HttpSession session) throws ParseException {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

	    List<Turma> turmas = dao.listaTurmasProfessor(usuario.getIdentificacao());
	    model.addAttribute("turmas", turmas);
	    
	    return "professor/mostrar-turmas";
	}
	
	@RequestMapping(value = "/chamadaTurma", method = RequestMethod.GET)
	public ModelAndView chamadaTurma(int id, Model model) {
		List<Presenca> presencas = dao.chamadaTurma(id); 
		
		Presenca presenca2 = new Presenca();
		presenca2.setListaPresencas(presencas);
		
	    /*model.addAttribute("alunosChamada", presencas);*/
		if (!presencas.isEmpty()) {
			model.addAttribute("turma", presencas.get(0));
		}
	    
	    return new ModelAndView("professor/chamada-turma" , "alunosChamada", presenca2);
	}
	
	@RequestMapping(value = "/confirmarChamada", method = RequestMethod.POST)
	public String confirmarChamada(@ModelAttribute("alunosChamada") Presenca presenca2) {
		
		List<Presenca> listaPresencas = presenca2.getListaPresencas();
		
		dao.finalizaChamada(listaPresencas);
		return "redirect:visualizarPresenca";
	}
	
	@RequestMapping(value = "/visualizarDocumentos", method = RequestMethod.GET)
	public ModelAndView chamadaTurma(Model model, HttpSession session) throws ParseException {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		List <Turma> turmas = dao.listaTurmasProfessor(usuario.getIdentificacao());
		
	    return new ModelAndView("professor/mostrar-turmas-documento", "turmas", turmas);
	}
	
	@RequestMapping(value = "/visualizarNotas", method = RequestMethod.GET)
	public ModelAndView visualizarNotas(Model model, HttpSession session) throws ParseException {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
	    List<Turma> turmas = dao.listaTodasTurmasProfessor(usuario.getIdentificacao());

	    return new ModelAndView("professor/mostrar-turmas-notas", "turmas", turmas);
	}
	
	@RequestMapping(value = "/visualizarNotasTurma", method = RequestMethod.GET)
	public ModelAndView postarNotas(int id, Model model) {
		
		List<Notas> notasLista = dao.listaNotasTurma(id); 
		
		Notas notas = new Notas();
		
		notas.setListaNotas(notasLista);
		
	    /*model.addAttribute("alunosChamada", presencas);*/
		
		if (!notasLista.isEmpty()) {
			model.addAttribute("turma", notasLista.get(0));
		}
	    
	    return new ModelAndView("professor/mostrar-notas-turma" , "alunosNotas", notasLista);
	}
	  
	@RequestMapping(value = "/confirmarNotas", method = RequestMethod.POST)
	public String confirmarNotas(@ModelAttribute("notasAlunos") Notas notas) {
				
		List<Notas> listaNotas = notas.getListaNotas();
		
		dao.postarNotas(listaNotas);
		return "redirect:visualizarNotas";
	}
	
	@RequestMapping(value = "/fecharTurma", method = RequestMethod.POST)
	public String fecharTurma(@ModelAttribute("notasAlunos") Notas notas) {
		
		List<Notas> listaNotas = notas.getListaNotas();
		
		dao.fecharTurma(listaNotas);
		return "redirect:visualizarNotas";
	}
	

}
