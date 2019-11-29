package com.hoidd.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.hoidd.service.driver.account.controller.DriverCustomer;

@Entity
//@Table(name="driver")
public class Technician implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Lob
	private String avatar;

	@Column(name="license_plates")
	private String licensePlates;

	@Column(name="location_id")
	private Integer locationId;

	@Column(length=255)
	private String name;

	@Column(length=20, unique=true)
	private String phone;

	@Column(name="type_device")
	private Integer typeDevice;

	@Column(name="type_user")
	private Integer typeUser;

	@Column(name="vehicle_name", length=255)
	private String vehicleName;

	private String device_token;
	
	private String token;
	
	@ManyToOne
	@JoinColumn(name="vehicle_id",referencedColumnName="id")
	@JsonIgnoreProperties("listUser")
	private Vehicle vehicle ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLicensePlates() {
		return licensePlates;
	}

	public void setLicensePlates(String licensePlates) {
		this.licensePlates = licensePlates;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getTypeDevice() {
		return typeDevice;
	}

	public void setTypeDevice(Integer typeDevice) {
		this.typeDevice = typeDevice;
	}

	public Integer getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(Integer typeUser) {
		this.typeUser = typeUser;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
//	public DriverCustomer todomain(Driver driver) {
//		 DriverCustomer driverCustomer = new DriverCustomer();
//		 
//		 
//		 driverCustomer.setId(driver.getId());
//		 driverCustomer.setName(driver.getName());
//		 driverCustomer.setAvatar(driver.getAvatar());
//		 driverCustomer.setLicensePlates(driver.getLicensePlates());
//		 driverCustomer.setLocationId(driver.getLocationId());
//		 driverCustomer.setPhone(driver.getPhone());
//		 driverCustomer.setTypeDevice(driver.getTypeDevice());
//		 driverCustomer.setTypeUser(driver.getTypeUser());
//		 driverCustomer.setVehicle(driver.getVehicle());
//		 driverCustomer.setVehicleName(driver.getVehicleName());
//		 return driverCustomer;
//		
//	}
	
	

	

}