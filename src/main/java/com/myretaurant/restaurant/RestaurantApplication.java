package com.myretaurant.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myretaurant.restaurant.Hello.Hello;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);

		Hello nome=new Hello();
		nome.hello("felipe");
	}
}
