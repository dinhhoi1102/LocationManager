package com.hoidd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
//@Table(name="users")
@Data
public class User implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true , name="phone")
	private String phone;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private int role;
	
	@Column(name="email")
	private String email;
	
//	private String device_token;
	
	private String token;
	

}
