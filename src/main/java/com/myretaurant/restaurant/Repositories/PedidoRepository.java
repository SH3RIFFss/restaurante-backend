package com.myretaurant.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myretaurant.restaurant.Models.PedidosModel;

public interface PedidoRepository extends JpaRepository<PedidosModel,Integer>{

}
