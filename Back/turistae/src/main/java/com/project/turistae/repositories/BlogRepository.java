package com.project.turistae.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.turistae.entities.Blog;

public interface BlogRepository  extends JpaRepository<Blog, Long>  {
	

}
