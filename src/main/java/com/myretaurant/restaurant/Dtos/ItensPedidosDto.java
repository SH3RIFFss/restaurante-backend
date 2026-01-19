package com.myretaurant.restaurant.Dtos;

public record ItensPedidosDto(int idPedido, int idProduto, int quantidade, double valorUnitario, String tipo) {

}
