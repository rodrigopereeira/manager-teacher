package br.com.rodrigo.integrador.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodrigo.integrador.dao.UsuarioDAO;
import br.com.rodrigo.integrador.modelo.Usuario;

@Controller
public class LoginController{
    
  @RequestMapping("login")
  	public String login() {
    return "formulario-login";
  }
  
  @RequestMapping("efetuaLogin")
  public String efetuaLogin(Usuario usuario, HttpSession session) {
    if(new UsuarioDAO().existeUsuario(usuario)) {
      session.setAttribute("usuarioLogado", usuario);
      
      session.setAttribute("grupoUsuario", usuario.getCodGrupoUsuario());
      return "redirect:inicio";
    }
    return "redirect:login";
  }
  
  @RequestMapping("logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:login";
  }
  
  @RequestMapping("recuperarSenha")
  public String recuperarSenha(HttpSession session) {
    return "recuperarSenha";
  }

}	
