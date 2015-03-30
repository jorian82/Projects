package com.ssde.apps.data;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Rol {

	@Id @GeneratedValue
	Long id;
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@ManyToMany
	@JoinTable(
			name="rol_usuario",
			joinColumns=@JoinColumn(name="usuario_id"),
			inverseJoinColumns=@JoinColumn(name="rol_id")
	)
	Set<User> users;
	public void setUsers(Set<User> users) {this.users = users;}
	public Set<User> getUsers() {return users;}
	
}
