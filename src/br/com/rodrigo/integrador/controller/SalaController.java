package br.com.rodrigo.integrador.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodrigo.integrador.dao.SalaDAO;
import br.com.rodrigo.integrador.modelo.Sala;
import br.com.rodrigo.integrador.modelo.SalaOcupada;

@Controller
public class SalaController {
	
	SalaDAO dao = new SalaDAO();

	@RequestMapping("novaSala")
	public String form(Model model) {
		return "sala/adiciona-sala";
	}

	@RequestMapping("adicionaSala")
	public String adiciona(Sala sala, BindingResult result) {
		dao.adiciona(sala);
		return "redirect:listaSalas";
	}

	@RequestMapping("removeSala")
	public String remove(Sala sala) {
		dao.remove(sala);
		return "redirect:listaSalas";
	}

	@RequestMapping("listaSalas")
	public String lista(Model model) {
		List<Sala> salas = dao.lista();
		model.addAttribute("salas", salas);
		return "sala/lista-sala";
	}
	
	@RequestMapping("listaSalasOcupadas")
	public String listaOcupadas(Model model) {
		List<SalaOcupada> salasOcupadas = dao.listaReserva();
		model.addAttribute("salasOcupadas", salasOcupadas);
		return "sala/lista-salaOcupada";
	}

	@RequestMapping("mostraSala")
	public String mostra(int id, Model model) {
		model.addAttribute("sala", dao.buscaPorId(id));
		return "sala/mostra-sala";
	}

	@RequestMapping("alteraSala")
	public String altera(Sala sala) {
		dao.altera(sala);
		return "redirect:listaSalas";
	}
	
}
