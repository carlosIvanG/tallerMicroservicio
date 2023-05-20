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
import ufps.edu.co.entity.Usuario;
import ufps.edu.co.modelo.HorarioAsesoria;
import ufps.edu.co.service.UsuarioService;


@RestController
@RequestMapping("/Usuario")
public class UsuarioServlet {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> usuarios =  usuarioService.obtenerUsuarios();
		if(usuarios.isEmpty()){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarUsuarioId(@PathVariable("id") int id){
		Usuario usuario = usuarioService.obtenerUsuarioId(id);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario){
		Usuario newUsuario= usuarioService.guardarUsuario(usuario);
		return ResponseEntity.ok(newUsuario);
	}
	
	@GetMapping("/horarios/{usuarioId}")
	public ResponseEntity<List<HorarioAsesoria>> listarHorariosId(@PathVariable("usuarioId") int id){
		Usuario usuario = usuarioService.obtenerUsuarioId(id);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		List<HorarioAsesoria> horarios = usuarioService.getHorarios(id);
		return ResponseEntity.ok(horarios);
	}
	
}