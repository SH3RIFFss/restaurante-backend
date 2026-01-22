package com.myretaurant.restaurant.Services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.myretaurant.restaurant.Dtos.ItensPedidosDto;
import com.myretaurant.restaurant.Dtos.PedidoDto;
import com.myretaurant.restaurant.Models.ItensPedidosModel;
import com.myretaurant.restaurant.Models.PedidosModel;
import com.myretaurant.restaurant.Models.ProdutosModel;
import com.myretaurant.restaurant.Repositories.FuncionarioRepository;
import com.myretaurant.restaurant.Repositories.PedidoRepository;
import com.myretaurant.restaurant.Repositories.ProdutoRepository;

import jakarta.transaction.Transactional;


@Service
public class PedidoService {

    private final PedidoRepository pedidoR;
    private final FuncionarioRepository funcionarioR;
    private final ProdutoRepository produtoR;
    public PedidoService(PedidoRepository pedidoRepository, FuncionarioRepository funcionarioRepository, ProdutoRepository produtoRepository){
        this.pedidoR=pedidoRepository;
        this.funcionarioR=funcionarioRepository;
        this.produtoR=produtoRepository;
    }
    @Transactional
    public PedidosModel pedir(PedidoDto pedidoDto){
        PedidosModel pedido = new PedidosModel();
        pedido.setFuncionario(funcionarioR.findById(pedidoDto.idFuncionario()).get());
        double total = 0;
        Set<ItensPedidosModel> itens = new HashSet<>();
        
        for (ItensPedidosDto itemDto : pedidoDto.itensPedidos()){
            ProdutosModel produto = produtoR.findById(itemDto.idProduto()).get();  
                // .orElseThrow(() -> new RuntimeException("produto nao encontrado !"));  //tratação de erro da linha de cima recomendado o seu uso.
            
            ItensPedidosModel itensPedidos = new ItensPedidosModel();
            itensPedidos.setPedidos(pedido);
            itensPedidos.setProdutos(produto);
            itensPedidos.setQuantidade(itemDto.quantidade());
            itensPedidos.setValorUnitario(produto.getValor());
            
            double subTotal = itensPedidos.getValorUnitario() * itensPedidos.getQuantidade();
            total = total + subTotal;
            
            itens.add(itensPedidos);
        }
        
        pedido.setItensPedidos(itens);
        pedido.setTotal(total);
        return pedidoR.save(pedido);
    }
}
