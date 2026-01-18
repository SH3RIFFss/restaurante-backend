package com.myretaurant.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myretaurant.restaurant.Models.ItensPedidosModel;

public interface ItenPedidoRepository extends JpaRepository<ItensPedidosModel, Integer> {

}
