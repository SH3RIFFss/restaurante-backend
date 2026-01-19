package com.myretaurant.restaurant.Services;

import org.springframework.stereotype.Service;

import com.myretaurant.restaurant.Dtos.ProdutoDto;
import com.myretaurant.restaurant.Models.ProdutosModel;
import com.myretaurant.restaurant.Repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoR;
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoR=produtoRepository;
    }
    @Transactional
    public ProdutosModel salvarProduto(ProdutoDto produtoDto){
        ProdutosModel produto=new ProdutosModel();
        produto.setNome(produtoDto.nome());
        produto.setTipo(produtoDto.tipo());
        produto.setValor(produtoDto.valor());
        return produtoR.save(produto);
    }
}
