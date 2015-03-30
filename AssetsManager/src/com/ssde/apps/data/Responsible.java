package com.ssde.apps.data;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="responsables")
public class Responsible {

	@Id @GeneratedValue
	Long id;
	String name;
	String email;
	Set<Device> devices;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Device> getDevices() {
		return devices;
	}
	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}
}
