package com.myretaurant.restaurant.Models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_PEDIDOS")
public class PedidosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //relacionado com a tabela funcionario
    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private FuncionarioModel funcionario;
    
    @Column (nullable = false)//Adicionar logica de pegar a data e hora do sistema antes de persistir
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") //aprenta a formatação da resposta não para entrada
    private LocalDateTime dataHora;
    
    @Column(nullable = false)
    private double total;
    
    //relacionado com a tabela itens-pedidos
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "pedidos",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItensPedidosModel> itensPedidos=new HashSet<>();
    //tratamento de data e hora 
    @PrePersist
    public void dataAgora(){
        this.dataHora=LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS); //para perssistir apenas até os segundos
    }
    public void adicionar(ItensPedidosModel itensPedidosModel){
        itensPedidos.add(itensPedidosModel);
        itensPedidosModel.setPedidos(this);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public FuncionarioModel getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }
    public Set<ItensPedidosModel> getItensPedidos() {
        return itensPedidos;
    }
    public void setItensPedidos(Set<ItensPedidosModel> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
    
}
