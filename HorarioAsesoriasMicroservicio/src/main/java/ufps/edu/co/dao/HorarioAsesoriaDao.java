package ufps.edu.co.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufps.edu.co.entity.HorarioAsesoria;

@Repository
public interface HorarioAsesoriaDao extends JpaRepository<HorarioAsesoria, Integer>{
	
	List<HorarioAsesoria> listarUsuarioId(int usuarioId);
}
