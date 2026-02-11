package com.myretaurant.restaurant.Controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretaurant.restaurant.Dtos.ProdutoDto;
import com.myretaurant.restaurant.Models.ProdutosModel;
import com.myretaurant.restaurant.Services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoControler {
    private final ProdutoService produtoS;
    public ProdutoControler(ProdutoService produtoService){
        this.produtoS=produtoService;
    }
    @GetMapping("/consulta")
    public ResponseEntity<List<ProdutosModel>> listarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoS.listarProdutos());
    }
    @PostMapping("/cadastro")
    public ResponseEntity<ProdutosModel> salvarProduto(@RequestBody ProdutoDto produtoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoS.salvarProduto(produtoDto));
    }
}
