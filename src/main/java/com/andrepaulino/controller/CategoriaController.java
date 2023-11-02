package com.andrepaulino.controller;

import java.sql.Connection;
import java.util.List;

import com.andrepaulino.dao.CategoriaDAO;
import com.andrepaulino.factory.ConnectionFactory;
import com.andrepaulino.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;

	public CategoriaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.categoriaDAO = new CategoriaDAO(connection);
	}

	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
