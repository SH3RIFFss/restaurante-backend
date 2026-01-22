package com.myretaurant.restaurant.Controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretaurant.restaurant.Dtos.PedidoDto;
import com.myretaurant.restaurant.Models.PedidosModel;
import com.myretaurant.restaurant.Services.PedidoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cadastrar/pedido")
public class PedidoControler {
    private final PedidoService pedidoS;
    public PedidoControler(PedidoService pedidoService){
        this.pedidoS=pedidoService;
    }
    @PostMapping
    public ResponseEntity<PedidosModel> pedir(@RequestBody PedidoDto pedidoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoS.pedir(pedidoDto));
    }
    
}
