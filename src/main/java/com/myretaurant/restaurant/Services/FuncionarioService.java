package com.myretaurant.restaurant.Services;

import org.springframework.stereotype.Service;

import com.myretaurant.restaurant.Dtos.FuncionarioDto;
import com.myretaurant.restaurant.Models.FuncionarioModel;
import com.myretaurant.restaurant.Repositories.FuncionarioRepository;

import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcuinarioR;
    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcuinarioR=funcionarioRepository;
    }
    @Transactional
    public FuncionarioModel salvarFuncionario(FuncionarioDto funcionarioDto){
        FuncionarioModel funcionario=new FuncionarioModel();
        funcionario.setNome(funcionarioDto.nome());
        funcionario.setLogin(funcionarioDto.login());
        return funcuinarioR.save(funcionario);
    }
}
