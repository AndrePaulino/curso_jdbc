package com.andrepaulino.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.andrepaulino.dao.ProdutoDAO;
import com.andrepaulino.factory.ConnectionFactory;
import com.andrepaulino.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("C�moda", "C�moda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}
