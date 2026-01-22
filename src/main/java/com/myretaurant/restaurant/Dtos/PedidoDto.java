package com.myretaurant.restaurant.Dtos;

import java.util.Set;

public record PedidoDto(int idFuncionario, Set<ItensPedidosDto> itensPedidos) {

}
