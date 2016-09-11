package controller;

import Model.IRepositorioCliente;
import Model.RepositorioCliente;

public class Fachada {
	private static Fachada instancia = null;
	private IRepositorioCliente repositorioCliente;
	
	private Fachada(){
		this.repositorioCliente = new RepositorioCliente();
	}
	
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	public void salvarCliente(Cliente cliente) throws Exception{
		this.repositorioCliente.salvarCliente(cliente);
	}
	
	public Cliente consultarCliente(int cliente_id) throws Exception{
		return this.repositorioCliente.consultarCliente(cliente_id);
	}
	
	public void alterarCliente(Cliente cliente) throws Exception{
		this.repositorioCliente.alterarCliente(cliente);
	}
}
