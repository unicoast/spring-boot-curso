package com.unicoast.cv_spring_boot.cv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data, @AllArgsConstructor y @NoArgsConstructor (Lombok) generan getters, setters y constructores.
// El constructor vacío permite que Spring instancie Skill al enlazar formularios con @ModelAttribute.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private String name;
    private String level;
}
