package cl.inacap.registroAsistentesModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.registroAsistentesModel.dto.Asistente;

@Local
public interface AsistentesDAOLocal {
	
	void save(Asistente asistente);
	List<Asistente> getAll();
	void delete(Asistente asistente);
	List<Asistente> filterByEstado(String estado);

}
