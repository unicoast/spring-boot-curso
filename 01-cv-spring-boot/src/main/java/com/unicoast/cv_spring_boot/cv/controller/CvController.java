package com.unicoast.cv_spring_boot.cv.controller;

import com.unicoast.cv_spring_boot.cv.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller indica que los métodos devuelven el nombre de una vista HTML (Thymeleaf), no JSON.
@Controller
// @RequestMapping define el prefijo de ruta común para los endpoints de este controlador.
@RequestMapping("/cv")
public class CvController {

    // @GetMapping asocia peticiones HTTP GET a una o varias rutas (/cv/index, /cv y /cv/).
    // Model pasa atributos del controlador a la vista para usarlos en Thymeleaf con ${...}.
    @GetMapping({"/index", "", "/"})
    public String index(Model model){
        Person person = new Person("Nicolás", "GitHub", "Developer");
        model.addAttribute("name", "Nicolás");
        model.addAttribute("person", person);
        return "index";
    }
}
