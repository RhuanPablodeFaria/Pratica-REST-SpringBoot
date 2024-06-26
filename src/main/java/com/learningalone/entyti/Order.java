//package com.learningalone.entyti;
//
//
//import org.hibernate.annotations.ManyToAny;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
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
//@Table(name = "order")
//public class Order {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id")
//	private Long id;
//	
//	@ManyToAny
//    @JoinColumn(name = "id_produto", nullable = false)
//	private Product product;
//
//	@ManyToOne
//    @JoinColumn(name = "id_user", nullable = false)
//	private User user;
//}
