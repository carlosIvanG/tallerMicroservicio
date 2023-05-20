package ufps.edu.co.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ufps.edu.co.entity.Usuario;
import ufps.edu.co.modelo.HorarioAsesoria;
import ufps.edu.co.dao.UsuarioDao;

@Service
public class UsuarioService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UsuarioDao usuarioDao;

	public List<HorarioAsesoria> getHorarios(int usuarioId){
		 List<HorarioAsesoria> horarios = restTemplate.getForObject("http://localhost:8082/Horario/usuario/" + usuarioId, List.class);
		 return horarios;
	}
	
	public List<Usuario> obtenerUsuarios(){
		return usuarioDao.findAll();
	}
	
	public Usuario obtenerUsuarioId(int id){
		return usuarioDao.findById(id).orElse(null);
	}
	
	public Usuario guardarUsuario(Usuario usuario){
		Usuario newUsuario= usuarioDao.save(usuario);
		return newUsuario; 
	}

}
