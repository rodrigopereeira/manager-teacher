package br.com.rodrigo.integrador.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import br.com.rodrigo.integrador.dao.FilesDAO;
import br.com.rodrigo.integrador.modelo.Files;


@Controller
public class FileController extends MultiActionController {
	

    FilesDAO dao = new FilesDAO();

    /**
     * upload
     */
	@RequestMapping("uploaded")
    public ModelAndView upload(HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");

        Files file = new Files();
        file.setCodigoTurma(ServletRequestUtils.getIntParameter(request, "codigoTurma"));
        file.setFilename(multipartFile.getOriginalFilename());
        file.setNotes(ServletRequestUtils.getStringParameter(request, "notes"));
        file.setType(multipartFile.getContentType());
        file.setFile(multipartFile.getBytes());
        dao.save(file);

        return new ModelAndView("redirect:inicio");
    }
	
	@RequestMapping("download")
	public ModelAndView download(int id, HttpServletResponse response) throws Exception {
		
	        Files file = dao.find(id);
	 
	        response.setContentType(file.getType());
	        response.setContentLength(file.getFile().length);
	        response.setHeader("Content-Disposition","attachment; filename=\"" + file.getFilename() +"\"");
	 
	        FileCopyUtils.copy(file.getFile(), response.getOutputStream());
	 
	        return null;
	 }
	
	@RequestMapping("deletaArquivo")
	public ModelAndView delete(int id, HttpServletResponse response) throws Exception {
		
	        dao.delete(id);
	        return new ModelAndView("redirect:inicio");
	 }

}
