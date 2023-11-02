package com.andrepaulino.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.andrepaulino.factory.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			System.out.println("Fechando conexão!!");
		}
	}

}
