package com.nestorcosta.springboot.backend.eventos.models.entity;

// Generated 23 mar 2023 10:08:39 by Hibernate Tools 4.3.6.Final
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Evento generated by hbm2java
 */
@Entity
@Table(name = "evento")
public class Evento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private LocalDate fecha;
	@JsonIgnore
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private String imagen;

	public Evento() {
	}

	public Evento(int id, String nombre, String descripcion, BigDecimal precio, LocalDate fecha) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fecha = fecha;
	}

	public Evento(int id, String nombre, String descripcion, BigDecimal precio, LocalDate fecha, Set<Usuario> usuarios) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fecha = fecha;
		this.usuarios = usuarios;
	}
	

	public Evento(int id, String nombre, String descripcion, BigDecimal precio, LocalDate fecha, Set<Usuario> usuarios,
			String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fecha = fecha;
		this.usuarios = usuarios;
		this.imagen = imagen;
	}
	

	public Evento(int id, String nombre, String descripcion, BigDecimal precio, LocalDate fecha, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fecha = fecha;
		this.imagen = imagen;
	}
	
	public Evento(Evento e) {
		super();
		this.id = e.id;
		this.nombre = e.nombre;
		this.descripcion = e.descripcion;
		this.precio = e.precio;
		this.fecha = e.fecha;
		this.imagen = e.imagen;
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 150)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", nullable = false, length = 2000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "precio", nullable = false, precision = 8)
	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 13)
	public LocalDate getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_asiste_evento", joinColumns = {
			@JoinColumn(name = "evento", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "usuario", nullable = false, updatable = false) })
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return id == other.id;
	}

}
