package ufps.edu.co.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.edu.co.entity.HorarioAsesoria;
import ufps.edu.co.service.HorarioAsesoriaService;

@RestController
@RequestMapping("/Horario")
public class HorarioAsesoriaServlet {
	@Autowired
	private HorarioAsesoriaService  horarioAsesoriaService;
	
	@GetMapping
	public ResponseEntity<List<HorarioAsesoria>> listarHorarios(){
		List<HorarioAsesoria> horarios =  horarioAsesoriaService.obtenerHorarios();
		if(horarios.isEmpty()){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(horarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HorarioAsesoria> listarHorarioId(@PathVariable("id") int id){
		HorarioAsesoria horario = horarioAsesoriaService.obtenerHorarioId(id);
		if(horario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(horario);
	}
	
	@PostMapping
	public ResponseEntity<HorarioAsesoria> insertarHorario(@RequestBody HorarioAsesoria horarioAsesoria){
		HorarioAsesoria newHorario= horarioAsesoriaService.guardarHorario(horarioAsesoria);
		return ResponseEntity.ok(newHorario);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<HorarioAsesoria>> listarhorarioUsuarioId(@PathVariable("id") int id){
		List<HorarioAsesoria> horarios = horarioAsesoriaService.obtenerUsuarioId(id);
		if(horarios.isEmpty()){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(horarios);
	}
	
}