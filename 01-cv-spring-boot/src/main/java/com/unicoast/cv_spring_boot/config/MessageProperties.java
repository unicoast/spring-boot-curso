package com.unicoast.cv_spring_boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// @Configuration marca la clase como fuente de configuración para el contenedor de Spring.
@Configuration
// @PropertySources agrupa @PropertySource para cargar archivos .properties personalizados del classpath.
// Nota: @PropertySource usa ISO-8859-1 por defecto; agregar encoding = "UTF-8" evita errores con tildes y ñ.
@PropertySources({
        @PropertySource("classpath:message.properties")
})
public class MessageProperties {
}
