package com.kadir.zeytuniPOS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.kadir.zeytuniPOS.mapper", // Mapper'lar
		"com.kadir.zeytuniPOS.core", // Servisler
		"com.kadir.zeytuniPOS.api", // Controller'lar
		"com.kadir.zeytuniPOS.data" // Entity/repository
})
public class ZeytuniPosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeytuniPosApplication.class, args);
	}

}
