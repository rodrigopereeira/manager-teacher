package br.com.rodrigo.integrador.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodrigo.integrador.dao.ComboDAO;
import br.com.rodrigo.integrador.dao.SecretariaDAO;
import br.com.rodrigo.integrador.modelo.Secretaria;

@Controller
public class SecretariaController {

	ComboDAO daoGeral = new ComboDAO();
	SecretariaDAO dao = new SecretariaDAO();
	
	@RequestMapping("novaSecretaria")
	public String form(Model model) {
	    model.addAttribute("sexos", daoGeral.listaSexo());
	    model.addAttribute("estadosCivis", daoGeral.listaEstadoCivil());
	    model.addAttribute("estados", daoGeral.listaEstado());
	    return "secretaria/adiciona-secretaria";
	}
	
	@RequestMapping("adicionaSecretaria")
	public String adiciona(Secretaria secretaria, BindingResult result) {
	    dao.adiciona(secretaria);
	    return "redirect:listaSecretarias";
	}

	@RequestMapping("removeSecretaria")
	  public String remove(Secretaria secretaria) {
	    dao.remove(secretaria);
	    return "redirect:listaSecretarias";
	}	
	
	@RequestMapping("listaSecretarias")
	public String lista(Model model) {
	    List<Secretaria> secretarias = dao.lista(); 
	    model.addAttribute("secretarias", secretarias);
	    return "secretaria/lista-secretaria";
	}
	
	@RequestMapping("mostraSecretaria")
	public String mostra(int id, Model model) {
	    model.addAttribute("secretaria", dao.buscaPorId(id));
	    model.addAttribute("sexos", daoGeral.listaSexo());
	    model.addAttribute("estadosCivis", daoGeral.listaEstadoCivil());
	    model.addAttribute("estados", daoGeral.listaEstado());
	    return "secretaria/mostra-secretaria";
	}
	
	@RequestMapping("alteraSecretaria")
	public String altera(Secretaria secretaria) {
	    dao.altera(secretaria);
	    return "redirect:listaSecretarias";
	}
	  
}
