package cl.inacap.registroAsistenteApp.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.registroAsistentesModel.dao.AsistentesDAOLocal;
import cl.inacap.registroAsistentesModel.dto.Asistente;

/**
 * Servlet implementation class MostrarAsistentesController
 */
@WebServlet("/MostrarAsistentesController.do")
public class MostrarAsistentesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	
	private AsistentesDAOLocal asistentesDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarAsistentesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	List<Asistente> asistentes = asistentesDAO.getAll();
	
	    request.setAttribute("asistentes", asistentes);
	
		request.getRequestDispatcher("WEB-INF/vistas/MostrarAsistentes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		FILTRO
		String estado = request.getParameter("filtro-select").trim();
		List<Asistente> asistentes = asistentesDAO.filterByEstado(estado);
		request.setAttribute("asistentes", asistentes);
		doGet(request, response);
	}

}
