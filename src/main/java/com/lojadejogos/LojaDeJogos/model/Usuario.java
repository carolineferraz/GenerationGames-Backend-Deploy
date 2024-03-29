package com.lojadejogos.LojaDeJogos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O atributo nome é obrigatório.")
	private String nome;
	
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O atributo usuario não pode ser nulo.")
	@Email(message = "O atributo usuario deve ser um e-mail válido.")
	private String usuario;
	
	@NotBlank
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
	private String senha;
	
	private String tipo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produtos;

	public Usuario(long id,  String nome, String usuario, String senha, String tipo) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Usuario() {}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getTipo() {
		return tipo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}	
}
