package com.ssde.apps.data;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="equipos")
public class Device {

	@Id @GeneratedValue
	Long id;
	String inventory;
	String brand;
	String model;
	String service_tag;
	String express_code;
	Responsible responsible;
	Set<Part> parts;
	Set<Repair> repairs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getService_tag() {
		return service_tag;
	}
	public void setService_tag(String service_tag) {
		this.service_tag = service_tag;
	}
	public String getExpress_code() {
		return express_code;
	}
	public void setExpress_code(String express_code) {
		this.express_code = express_code;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	public Responsible getResponsible() {
		return responsible;
	}
	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Part> getParts() {
		return this.parts;
	}
	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Repair> getRepairs() {
		return this.repairs;
	}
	public void setRepairs(Set<Repair> repairs) {
		this.repairs = repairs;
	}
	
}
