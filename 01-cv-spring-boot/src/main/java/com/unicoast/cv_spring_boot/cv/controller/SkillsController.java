package com.unicoast.cv_spring_boot.cv.controller;

import com.unicoast.cv_spring_boot.cv.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

// @Controller gestiona vistas Thymeleaf bajo el prefijo de ruta /skills.
@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final List<Skill> skills = new ArrayList<>();

//    @GetMapping
//    public String showSkills(Model model){
//        model.addAttribute("skills", skills);
//        return "skills";
//    }

    // @RequestParam lee parámetros de consulta (?filter=...); defaultValue evita nulos y hace opcional el parámetro.
    @GetMapping
    public String showSkills(@RequestParam(defaultValue = "", required = false) String filter, Model model){
        List<Skill> skillsFilter = skills.stream()
                .filter(skill -> skill.getName().toLowerCase().contains(filter.toLowerCase()))
                .toList();

        model.addAttribute("skills", skillsFilter);
        model.addAttribute("filter", filter);

        return "skills";
    }

    // @PathVariable captura el valor dinámico {index} de la URL; "redirect:" envía una redirección HTTP.
    @GetMapping("/id/{index}")
    public String showSkillDetail(@PathVariable int index, Model model){
        if (index >= 0 && index < skills.size()){
            Skill skill = skills.get(index);
            model.addAttribute("skill", skill);
            return "skill-detail";
        }

        return "redirect:/skills";
    }

    // Permite capturar múltiples variables dinámicas (@PathVariable) dentro de una misma ruta.
    @GetMapping("/filter/{name}/{level}")
    public String showFilteredSkill(@PathVariable String name, @PathVariable String level, Model model){
        List<Skill> skillsFilter = skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(name) && skill.getLevel().equalsIgnoreCase(level))
                .toList();

        model.addAttribute("skills", skillsFilter);
        model.addAttribute("filterMessage", "Filtro: " + name + " - " + level);

        return "skills";
    }

//    @GetMapping("/name/{name}")
//    public String showFilteredSkill(@PathVariable String name, Model model){
//        List<Skill> skillsFiltered = skills.stream()
//                .filter(skill -> skill.getName().equalsIgnoreCase(name))
//                .toList();
//
//        if(skillsFiltered.isEmpty()){
//            model.addAttribute("filterMessage", "No se encontraron resultados para: " + name);
//            return "forward:/skills";
//        }
//        model.addAttribute("skills", skillsFiltered);
//        model.addAttribute("filterMessage", "Filtro: " + name);
//        return "skills";
//    }

    // RedirectAttributes.addFlashAttribute() envía datos temporales que sobreviven a un "redirect:" (no a "forward:").
    // "forward:" reenvía la misma petición en el servidor; "redirect:" ordena al navegador hacer una nueva petición GET.
    @GetMapping("/name/{name}")
    public String showFilteredSkill(@PathVariable String name, RedirectAttributes redirectAttributes){
        List<Skill> skillsFiltered = skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(name))
                .toList();

        if(skillsFiltered.isEmpty()){
            redirectAttributes.addFlashAttribute("filterMessage", "No se encontraron resultados para: " + name);
            return "forward:/skills?filter="+name;
        }
        redirectAttributes.addFlashAttribute("filterMessage", "Filtro: " + name);
        return "forward:/skills?filter="+name;
    }

//    @GetMapping("/name/{name}")
//    public String showFilteredSkill(@PathVariable String name, RedirectAttributes redirectAttributes) {
//
//        boolean hasResults = skills.stream()
//                .anyMatch(skill -> skill.getName().equalsIgnoreCase(name));
//
//        if (!hasResults) {
//            redirectAttributes.addFlashAttribute("filterMessage", "No results found for: " + name);
//        } else {
//            redirectAttributes.addFlashAttribute("filterMessage", "Filter: " + name);
//        }
//
//        return "redirect:/skills?filter=" + name;
//    }

    // Envía una instancia vacía de Skill en Model para enlazarla con th:object en el formulario Thymeleaf.
    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("skill", new Skill());
        return "add-skill";
    }

    // @PostMapping atiende envíos POST de formularios; "redirect:" tras guardar evita duplicados al recargar.
    @PostMapping("/add")
    // @ModelAttribute vincula automáticamente los datos enviados desde el formulario HTML con un objeto Skill.
    public String addSkill(@ModelAttribute Skill skill){
        skills.add(skill);
        return "redirect:/skills";
    }
}
