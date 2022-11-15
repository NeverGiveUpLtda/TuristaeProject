package com.project.turistae.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.turistae.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//	@Query("SELECT obj FROM Usuario obj WHERE LOWER(obj.email) LIKE LOWER(CONCAT('%',:email,'%'))")
//	Page<Usuario> searchEmail(String email, Pageable pageable);
//
//	Page<Usuario> findByEmailContainingIgnoreCase(String email, Pageable pageable);
	

}
