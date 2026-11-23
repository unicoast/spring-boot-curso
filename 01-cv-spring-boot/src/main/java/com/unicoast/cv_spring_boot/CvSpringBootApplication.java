package com.unicoast.cv_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication habilita la configuración automática y escanea componentes desde este paquete raíz.
@SpringBootApplication
public class CvSpringBootApplication {

	public static void main(String[] args) {
		// Arranca el contenedor de Spring y el servidor web embebido.
		SpringApplication.run(CvSpringBootApplication.class, args);
	}

}
