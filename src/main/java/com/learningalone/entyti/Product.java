//package com.learningalone.entyti;
//
//import java.util.Objects;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Table(name = "products")
//public class Product {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id")
//	private Long id;
//	
//	@Column(name = "name", nullable = false, unique = true)
//	private String name;
//	
//	@Column(name = "product_type", nullable = false, length = 150)
//	private String productType;
//
//	@Column(name = "value", nullable = false)
//	private Double value;
//	
//	@OneToMany
//    @JoinColumn(name = "id_produto", nullable = false)
//	private Order order;
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		return Objects.equals(id, other.id);
//	}
//	
//	
//}
