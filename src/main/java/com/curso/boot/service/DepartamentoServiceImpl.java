package com.curso.boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.DemoMvcApplication;
import com.curso.boot.dao.DepartamentoDao;
import com.curso.boot.domain.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	private static final Logger LOGGER= LoggerFactory.getLogger(DemoMvcApplication.class);
	
	@Autowired
	private DepartamentoDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Departamento departamento) {
		dao.save(departamento);		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Departamento departamento) {
		dao.update(departamento);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Departamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Departamento> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		LOGGER.info("método departamentoTemCargos");
		if (buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	

}
