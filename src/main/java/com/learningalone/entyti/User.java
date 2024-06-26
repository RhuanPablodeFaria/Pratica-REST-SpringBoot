package com.learningalone.entyti;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "firstName", nullable = false, length = 30)
	private String firstName;
	@Column(name = "fullName", nullable = false, length = 150, unique = true)
	private String fullName;
	@Column(name = "email", nullable = false, length = 150, unique = true)
	private String email;
	@Column(name = "cpf", nullable = false, length = 11, unique = true)
	private Integer CPF;
	@Column(name = "city", nullable = false, length = 150)
	private String city;
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false, length = 15)
	private Role role = Role.TYPE_USUARIO;
	@Column(name = "password", nullable = false, length = 250)
	private String password;
	@Column(name = "active_user", nullable = false, length = 6)
	private Boolean activeUser = true;
	
	public enum Role{
		TYPE_ADMINISTRADOR, TYPE_USUARIO
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", firstName=" + firstName + ", fullName=" + fullName + ", email=" + email
				+ ", CPF=" + CPF + ", city=" + city + ", type=" + role + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
