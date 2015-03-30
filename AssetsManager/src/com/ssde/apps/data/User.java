package com.ssde.apps.data;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class User {

	@Id @GeneratedValue
	Long id;
	public Long getId() {return this.id;}
	public void setId(Long id) {this.id = id;}
	
	String fullname;
	public String getFullName() {return this.fullname;}
	public void setFullName(String fullname) {this.fullname = fullname;}
	
	String username;
	public String getUserName() {return this.username;}
	public void setUserName(String username) {this.username = username;}
	
	String password;
	public String getPassword() {return this.password;}
	public void setPassword(String password) {this.password = password;}
	
	String email;
	public String getEmail() {return this.email;}
	public void setEmail(String email) {this.email = email;}
	
	@ManyToMany
	@JoinTable(
			name="rol_usuario",
			joinColumns=@JoinColumn(name="rol_id"),
			inverseJoinColumns=@JoinColumn(name="usuario_id")
	)
	Set<Rol> roles;
	public void setRoles(Set<Rol> roles) {this.roles = roles;}
	public Set<Rol> getRoles() {return roles;}
	
}
