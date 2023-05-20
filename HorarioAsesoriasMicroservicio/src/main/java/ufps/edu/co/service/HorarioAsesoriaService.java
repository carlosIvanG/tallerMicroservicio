package ufps.edu.co.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufps.edu.co.dao.HorarioAsesoriaDao;
import ufps.edu.co.entity.HorarioAsesoria;


@Service
public class HorarioAsesoriaService {
	@Autowired
	private HorarioAsesoriaDao horarioasesoriaDao;
	
	public List<HorarioAsesoria> obtenerHorarios(){
		return horarioasesoriaDao.findAll();
	}
	
	public HorarioAsesoria obtenerHorarioId(int id){
		return horarioasesoriaDao.findById(id).orElse(null);
	}
	
	public HorarioAsesoria guardarHorario(HorarioAsesoria horario){
		HorarioAsesoria newHorario= horarioasesoriaDao.save(horario);
		return newHorario; 
	}
	//buscar todos los horarios de un usuario en particular//
	public List<HorarioAsesoria> obtenerUsuarioId (int usuarioId){
		return horarioasesoriaDao.listarUsuarioId(usuarioId);
	}
}