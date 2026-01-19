package com.myretaurant.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myretaurant.restaurant.Models.FuncionarioModel;
//faz a lincagem da chave primaria para fora da tabela
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer>{

}
