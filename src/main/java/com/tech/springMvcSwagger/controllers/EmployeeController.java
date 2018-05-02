package com.tech.springMvcSwagger.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.springMvcSwagger.entity.Employee;


@Controller("/")
@SuppressWarnings("all")
@Api(tags = "Employee", description="Everything About Employee")
public class EmployeeController {
	
	private Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
	
	@ApiOperation(value = "Add a new employee")
	@RequestMapping(value="/v1/addEmployee", method=RequestMethod.POST, produces = "application/json")
	public ResponseEntity addEmployee(@ApiParam(value="employee object that needs to be added", name="employee", required=true)@RequestBody Employee employee){
		employeeMap.put(employee.getId(), employee);
		return new ResponseEntity("{\"messages\":\"employee added successfully with id: "+ employee.getId()+"\"}", HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get Employee By Id",response = Employee.class )
	@RequestMapping(value="/v1/getById", method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity getById(@ApiParam(value="employee id of the employee", name= "id", required=true)@RequestParam("id") Integer id){
		return new ResponseEntity(employeeMap.get(id),HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get Employee List")
	@RequestMapping(value="/v1/employeeList", method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity employeeListOld(){
		List<Employee> list = new ArrayList<Employee>(employeeMap.size());
		Iterator it = employeeMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        list.add((Employee) pair.getValue());
	    }
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Employee List New API")
	@RequestMapping(value="/v2/employeeList", method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity employeeList(){
		List<Employee> list = new ArrayList<Employee>(employeeMap.size());
		Iterator it = employeeMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        list.add((Employee) pair.getValue());
	    }
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	
}
