package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_CLIENTE")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDOS")
	private String apellidos;
	@Column(name="LOGIN_USUARIO")
	private String loginUsuario;
	@Column(name="LOGIN_CLAVE")
	private String loginClave;
	
	public Cliente() {
		
	}
	
	public Cliente(String nombre, String apellidos, String loginUsuario, String loginClave) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.loginUsuario = loginUsuario;
		this.loginClave = loginClave;
	}

	public Cliente(int id, String nombre, String apellidos, String loginUsuario, String loginClave) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.loginUsuario = loginUsuario;
		this.loginClave = loginClave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getLoginClave() {
		return loginClave;
	}

	public void setLoginClave(String loginClave) {
		this.loginClave = loginClave;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", loginUsuario="
				+ loginUsuario + ", loginClave=" + loginClave + "]";
	}
	
	

}
