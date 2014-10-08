package br.com.rodrigo.integrador.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodrigo.integrador.dao.ComboDAO;
import br.com.rodrigo.integrador.dao.MenuDAO;
import br.com.rodrigo.integrador.modelo.Estado;
import br.com.rodrigo.integrador.modelo.EstadoCivil;
import br.com.rodrigo.integrador.modelo.Menu;
import br.com.rodrigo.integrador.modelo.Sexo;

@Controller
public class GeralController {

	public GeralController () {
		
	}
	
	@RequestMapping("inicios")
	public String form() {
		return "menu";
	}
	
	@RequestMapping("inicio")
	public String listaMenu(HttpSession session, HttpServletRequest request) {
		MenuDAO dao = new MenuDAO();
		int codigoGrupo;
		codigoGrupo = (int) request.getSession().getAttribute("grupoUsuario");

		List<Menu> menu = dao.lista(codigoGrupo);
		session.setAttribute("menu0", menu);
		session.setAttribute("menu1", menu);
		session.setAttribute("menu2", menu);
		return "menu";
	}
	

	@RequestMapping("listaSexos")
	public void listaSexo(Model model) {
		ComboDAO dao = new ComboDAO();
		List<Sexo> sexos = dao.listaSexo();
		model.addAttribute("sexos", sexos);
	}

	@RequestMapping("listaEstadoCivil")
	public void listaEstadoCivil(Model model) {
		ComboDAO dao = new ComboDAO();
		List<EstadoCivil> estadosCivis = dao.listaEstadoCivil();
		model.addAttribute("estadosCivis", estadosCivis);
	}

	@RequestMapping("listaEstados")
	public void listaEstado(Model model) {
		ComboDAO dao = new ComboDAO();
		List<Estado> estados = dao.listaEstado();
		model.addAttribute("estados", estados);
	}

}
