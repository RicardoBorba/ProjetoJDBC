package Model;

import controller.Cliente;

public interface IRepositorioCliente {
	void salvarCliente(Cliente cliente) throws Exception;
	
	Cliente consultarCliente(int cliente_id) throws Exception;
	
	void alterarCliente(Cliente cliente) throws Exception;
	
	void excluirCliente(int cliente_id) throws Exception;
}
