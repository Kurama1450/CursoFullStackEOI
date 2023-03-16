package com.nestorcosta.anotaciones1.entidades;
// Generated 16 mar 2023 9:55:40 by Hibernate Tools 4.3.6.Final

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Libros generated by hbm2java
 */
@Entity
@Table(name = "libros")
public class Libros implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codautor")
	private Autores autores;
	@Column(name = "titulo", length = 60)
	private String titulo;

	public Libros() {
	}

	public Libros(int id) {
		this.id = id;
	}

	public Libros(int id, Autores autores, String titulo) {
		this.id = id;
		this.autores = autores;
		this.titulo = titulo;
	}

	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Autores getAutores() {
		return this.autores;
	}

	public void setAutores(Autores autores) {
		this.autores = autores;
	}

	
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
