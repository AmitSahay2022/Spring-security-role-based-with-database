package com.sahay.entity;
/*
 * you will have to manually create role in database 
 * ex: id:1      
 *     role:ROLE_ADMIN
 *     
 *     id:2
 *     role:ROLE_USER
 */
/*
 *   then you will have to map user and role in users_roles table
 *   Ex: 1 1    where 1 is user id and 1 is role id 
 *       2 2    where 2 is user id and 2 is role id 
 *      means we are assigning first user admin role
 *      and second user user role
 * */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}