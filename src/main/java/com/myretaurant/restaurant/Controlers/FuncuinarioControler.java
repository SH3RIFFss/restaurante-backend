package com.myretaurant.restaurant.Controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretaurant.restaurant.Dtos.FuncionarioDto;
import com.myretaurant.restaurant.Models.FuncionarioModel;
import com.myretaurant.restaurant.Services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncuinarioControler {
    private final FuncionarioService funcionarioS;
    public FuncuinarioControler(FuncionarioService funcionarioService){
        this.funcionarioS=funcionarioService;
    }
    @GetMapping("/consulta")
    public ResponseEntity<List<FuncionarioModel>> çistarFuncionarios(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioS.listarFuncionarios());
    }
    @PostMapping("/cadastro")
    public ResponseEntity<FuncionarioModel>salvarFuncuinario(@RequestBody FuncionarioDto funcionarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioS.salvarFuncionario(funcionarioDto));
    }
}
