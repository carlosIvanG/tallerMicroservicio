package ufps.edu.co.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufps.edu.co.entity.Usuario;


@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer>{

}
