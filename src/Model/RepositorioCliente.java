package Model;

import controller.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RepositorioCliente implements IRepositorioCliente{
	public void salvarCliente(Cliente cliente) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = Conexao.getConexao();
		conn.setAutoCommit(false);
		String SQL = "INSERT INTO CLIENTE(NOME, ENDERECO, CIDADE, UF) VALUES (?,?,?,?)";
		try{
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getEndereco());
			pstmt.setString(3, cliente.getCidade());
			pstmt.setString(4, cliente.getUf());
			
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public Cliente consultarCliente(int cliente_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = Conexao.getConexao();
		conn.setAutoCommit(false);
		Cliente cliente = null;
		String SQL = "SELECT * FROM CLIENTE WHERE CLIENTE_ID = ?";
		
		try{
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, cliente_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setUf(rs.getString("uf"));
			}
			
			pstmt.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return cliente;
	}
	
	public void alterarCliente(Cliente cliente) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = Conexao.getConexao();
		conn.setAutoCommit(false);
		String SQL = "UPDATE CLIENTE SET NOME=?, ENDERECO=?, CIDADE=?, UF=? WHERE CLIENTE_ID=?";
		
		try{
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getEndereco());
			pstmt.setString(3, cliente.getCidade());
			pstmt.setString(4, cliente.getUf());
			pstmt.setInt(5, cliente.getId());
			
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void excluirCliente(int cliente_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = Conexao.getConexao();
		conn.setAutoCommit(false);
		String SQL = "DELETE FROM CLIENTE WHERE CLIENTE_ID=?";
		
		try{
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, cliente_id);
			
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
