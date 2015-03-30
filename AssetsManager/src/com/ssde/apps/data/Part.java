package com.ssde.apps.data;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="partes")
public class Part {

	@Id @GeneratedValue
	Long id;
	String brand;
	String serial;
	String kind;
	Date replaced;
	Device device;
	
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
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Date getReplaced() {
		return replaced;
	}
	public void setReplaced(Date replaced) {
		this.replaced = replaced;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	public Device getDevice() {
		return this.device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
}
