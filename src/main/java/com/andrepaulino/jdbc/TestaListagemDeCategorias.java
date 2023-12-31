package com.andrepaulino.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.andrepaulino.dao.CategoriaDAO;
import com.andrepaulino.factory.ConnectionFactory;
import com.andrepaulino.modelo.Categoria;
import com.andrepaulino.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProduto();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}
}
