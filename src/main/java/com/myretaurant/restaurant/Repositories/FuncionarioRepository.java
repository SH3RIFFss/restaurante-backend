package com.myretaurant.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myretaurant.restaurant.Models.FuncionarioModel;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer>{

}
