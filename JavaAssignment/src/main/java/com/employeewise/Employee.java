package com.employeewise;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Employee {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private String rev;
    private String employeeName;
    private String phoneNumber;
    private String email;
    private String reportsTo;   
    private String profileImageUrl;  
}