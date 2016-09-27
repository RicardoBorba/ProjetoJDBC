package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static String STR_CONEXAO = "jdbc:postgresql://localhost:5432/testando1";
	private static String USUARIO = "postgres";
	private static String SENHA = "123456";
	
	public static Connection getConexao() throws Exception{
		Connection conn = null;
		DriverManager.registerDriver(new org.postgresql.Driver());
		conn = DriverManager.getConnection(STR_CONEXAO, USUARIO, SENHA);
		
		return conn;
	}
}