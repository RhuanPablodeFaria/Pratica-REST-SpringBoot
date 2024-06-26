package com.learningalone.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UserCreateDTO {
	
	private String firstName;
	private String fullName;
	private String cpf;
	private String city;
	private String email;
	private String password;
}
