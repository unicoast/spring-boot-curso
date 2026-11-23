package com.unicoast.cv_spring_boot.cv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data (Lombok) genera getters, setters, toString(), equals() y hashCode() al compilar.
@Data
// @AllArgsConstructor (Lombok) genera un constructor con todos los atributos.
@AllArgsConstructor
// @NoArgsConstructor (Lombok) genera un constructor vacío, necesario para Spring MVC y Jackson.
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private String profession;
}
