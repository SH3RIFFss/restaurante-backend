package com.myretaurant.restaurant.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ITENS_PEDIDOS")
public class ItensPedidosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //muitos itens pedidos para um pedido
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private ProdutosModel produtos; 
    //muitos itens pedidos para um produto
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private PedidosModel pedidos;

    @Column(nullable = false)
    private double valorUnitario;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private int tipo;

    
    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public PedidosModel getPedidos() {
        return pedidos;
    }
    public void setPedidos(PedidosModel pedidos) {
        this.pedidos = pedidos;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ProdutosModel getProdutos() {
        return produtos;
    }
    public void setProdutos(ProdutosModel produtos) {
        this.produtos = produtos;
    }
    

}
