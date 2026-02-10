package com.laros.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Flujo:

Controller
   ↓
Application Service
   ↓
Domain (Entidad + reglas)
   ↓
Repository (interfaz)
   ↓
Adapter JPA
   ↓
PostgreSQL
 */
@SpringBootApplication
public class OrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

}
