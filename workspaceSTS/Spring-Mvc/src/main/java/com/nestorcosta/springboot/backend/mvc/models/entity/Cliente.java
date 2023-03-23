package com.nestorcosta.springboot.backend.mvc.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id //Dice que es la clave primaria de la Tabla
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Le de numeros consecutivos , un auto-numerico
	private Long id;
	
	@NotEmpty(message="El nombre no puede estar vacio")
	@Size(min=4,max=12, message="El nombre debe contener entre 4 y 12 letras")
	private String nombre;
	private String apellido;
	@NotEmpty(message="El email no puede estar vacio")
	@Email(message="La direccion de correo no está bien formada")
	private String email;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private LocalDate createAt;
	
	public Cliente() {
		
	}

	public Cliente(Long id, String nombre, String apellido, String email, LocalDate createAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.createAt = createAt;
	}

	public Cliente(String nombre, String apellido, String email, LocalDate createAt) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.createAt = createAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}
	
	
}
