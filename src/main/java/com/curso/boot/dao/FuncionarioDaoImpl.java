package com.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDAO<Funcionario, Long> implements FuncionarioDao {

}
