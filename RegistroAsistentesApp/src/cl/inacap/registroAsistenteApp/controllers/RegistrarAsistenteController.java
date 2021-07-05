package cl.inacap.registroAsistenteApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class RegistrarAsistenteController
 */
@WebServlet("/RegistrarAsistenteController.do")
public class RegistrarAsistenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private AsistentesDAOLocal asistentesDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarAsistenteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/vistas/RegistrarAsistente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> errores = new ArrayList<>();
//		VALIDACIÓN RUT CHILENO
		String rut = request.getParameter("rut-txt").trim();
		if (rut.isEmpty()) {
			errores.add("Debe ingresar un rut");
		} else {
			List<Asistente> p = asistentesDAO.getAll();
			int n, m, v = 2, s = 0, rutAux;
			String d1;

			try {
				rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
				n = rut.length() - 1;

				while (n >= 1) {
					m = Integer.parseInt(rut.substring(n - 1, n)) * v;
					s = s + m;
					++v;
					if (v > 7) {
						v = 2;
					}
					--n;
				}
				d1 = Integer.toString(11 - (s % 11));
				switch (d1) {
				case "10":
					d1 = "k";
					break;
				case "11":
					d1 = "0";
					break;

				}
				if (rutAux != 0) {
					boolean contiene = false;

					if (rut.substring(rut.length() - 1).equals(d1)) {
						contiene = true;
					}
					if (!contiene) {
						errores.add("Digito verificador inválido");
					}
				}

				for (Asistente i : p) {
					if (i.getRut().equalsIgnoreCase(rut)) {
						errores.add("Ya hay un cliente con ese rut");
					}
				}

			} catch (Exception ex) {
				errores.add("Rut inválido");
			}
		}
//		VALIDACIÓN NOMBRE VACÍO
		String nombre = request.getParameter("nombre-txt").trim();
		if (nombre.isEmpty()) {
			errores.add("Debe ingresar un nombre");
		}
//		VALIDACIÓN APELLIDO VACÍO
		String apellido = request.getParameter("apellido-txt").trim();
		if (apellido.isEmpty()) {
			errores.add("Debe ingresar un apellido");
		}

//		VALIDACIÓN + 6 LETRAS
		String empresa = request.getParameter("empresa-txt").trim();
		String[] letras = empresa.split("");
		if (empresa.isEmpty()) {
			errores.add("Debe elegir una opcion valida");
		} else {

			if (letras.length < 6) {
				errores.add("El nombre de la empresa debe tener al menos 6 caracteres, intente nuevamente");
			}
		}

		String estado = request.getParameter("estado-select").trim();
		if (estado.isEmpty()) {
			errores.add("Debe elegir una opcion valida");
		}

		String region = request.getParameter("region-select").trim();
		if (region.isEmpty()) {
			errores.add("Debe elegir una opcion valida");
		}

		if (errores.isEmpty()) {
			Asistente asistente = new Asistente();
			asistente.setRut(rut);
			asistente.setNombre(nombre);
			asistente.setApellido(apellido);
			asistente.setEdad(0);
			asistente.setEmpresa(empresa);
			asistente.setEstado(estado);
			asistente.setRegion(region);

			request.setAttribute("mensaje", "Asistente registrado exitosamente");
		} else {
			request.setAttribute("errores", errores);
		}
		doGet(request, response);
	}

}
