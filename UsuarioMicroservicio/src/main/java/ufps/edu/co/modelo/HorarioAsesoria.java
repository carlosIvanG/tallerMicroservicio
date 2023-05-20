package ufps.edu.co.modelo;

import java.io.Serializable;
import lombok.Data;

@Data
public class HorarioAsesoria implements Serializable {
	private String fecha;
	private String hora;
	
	public HorarioAsesoria() {
		super();
	}
}