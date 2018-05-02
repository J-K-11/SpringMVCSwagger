package com.tech.springMvcSwagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Employee")
public class Employee {
	@ApiModelProperty(dataType="Integer", value="Id of employee")
	private int id;
	@ApiModelProperty(dataType="String", value="Name of employee")
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {
		super();
	}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
