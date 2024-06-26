package com.learningalone.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UserRespondeDTO {

	private Long id;
	private String fullName;
	private String cpf;
	private String role;
	private Boolean activeUser;
}
