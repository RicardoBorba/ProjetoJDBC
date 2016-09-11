package controller;

public class Cliente {
	private int id;
	private String nome;
	private String endereco;
	private String cidade;
	private String uf;
	
	//Set e get de id
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	
	//set e get de nome
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	//set e get de endereco
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	public String getEndereco(){
		return this.endereco;
	}
	
	//set e get de cidade
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	public String getCidade(){
		return this.cidade;
	}
	
	//set e get de uf
	public void setUf(String uf){
		this.uf = uf;
	}
	public String getUf(){
		return this.uf;
	}
}
