//package com.learningalone.entyti;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor
//@Entity
//@Table(name = "wallets_users")
//public class Wallet {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//	
//	@Column(name = "saldo")
//    private Double saldo = 0.0;
//	
//	@OneToOne
//	@JoinColumn(name = "users_id", nullable = false)
//	private User user;
//}
