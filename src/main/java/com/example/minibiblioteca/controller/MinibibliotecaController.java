package com.example.minibiblioteca.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MinibibliotecaController {

    @GetMapping("/")
    public String verLibros(Model model) {
        //Lista estática de libros: título y autor
        List<String> libros = Arrays.asList(
            "El Quijote - Cervantes",
            "1984 - Orwell",
            "Harry Potter - J.K. Rowling"
        );

        //Enviamos la lista a la vista
        model.addAttribute("libros", libros);

        return "listView"; // Nombre de la vista Thymeleaf
    }
}
