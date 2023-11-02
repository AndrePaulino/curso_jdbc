package com.andrepaulino.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {

	public DataSource dataSource;
	private Dotenv dotenv = Dotenv.load();

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(dotenv.get("DATABASE_URL"));
		comboPooledDataSource.setUser(dotenv.get("DATABASE_USER"));
		comboPooledDataSource.setPassword(dotenv.get("DATABASE_PASSWORD"));

		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
