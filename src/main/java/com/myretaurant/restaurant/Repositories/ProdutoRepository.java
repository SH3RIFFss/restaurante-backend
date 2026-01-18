package com.myretaurant.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myretaurant.restaurant.Models.ProdutosModel;

public interface ProdutoRepository extends JpaRepository<ProdutosModel,Integer>{

}
