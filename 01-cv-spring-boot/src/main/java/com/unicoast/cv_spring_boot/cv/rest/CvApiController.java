package com.unicoast.cv_spring_boot.cv.rest;

import com.unicoast.cv_spring_boot.cv.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController combina @Controller y @ResponseBody: serializa el objeto devuelto a JSON automáticamente.
@RestController
// Nota: @RequestMapping("/") junto a @GetMapping("/cv") coincide con GET /cv de CvController (conviene usar "/api").
@RequestMapping("/")
public class CvApiController {

    // @GetMapping atiende peticiones HTTP GET; Jackson convierte el objeto Person a JSON.
    @GetMapping("/cv")
    public Person gePerson(){
        Person person = new Person("Nicolás", "GitHub", "Desarrollador Full Stack");
        return person;
    }
}
