package com.andrepaulino.jdbc;

import java.sql.SQLException;

import com.andrepaulino.factory.ConnectionFactory;

public class TestaPoolConexoes {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        for (int i = 0; i < 20; i++) {
            connectionFactory.recuperarConexao();
            System.out.println("Conexão de número: " + i);
        }
    }
}
