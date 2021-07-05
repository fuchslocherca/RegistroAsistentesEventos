package cl.inacap.registroAsistentesModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.registroAsistentesModel.dto.Asistente;

/**
 * Session Bean implementation class AsistentesDAO
 */
@Stateless
@LocalBean
public class AsistentesDAO implements AsistentesDAOLocal {
	
 private static List<Asistente> asistentes = new ArrayList<>();

	@Override
	public void save(Asistente asistente) {
		asistentes.add(asistente);
	}

	@Override
	public List<Asistente> getAll() {
		// TODO Auto-generated method stub
		return asistentes;
	}

	@Override
	public void delete(Asistente asistente) {
		asistentes.remove(asistente);
		
	}

	@Override
	public List<Asistente> filterByEstado(String estado) {
	return asistentes.stream().filter(a->a.getEstado().contains(estado)).collect(Collectors.toList());
	}

}
