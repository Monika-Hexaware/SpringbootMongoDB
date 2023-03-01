package com.springbootMongoDB.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class Employee {

	@Id
	private String id;
    private String name;

	public Employee(String id, 
        String name
    ){
    this.id = id;
	this.name = name;
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "[id = " + this.id +
                "name = " + this.name +
            "]";
    }

}
