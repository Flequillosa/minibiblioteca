package com.example.minibiblioteca.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MinibibliotecaController {

    //Lista dinámica de libros (como strings "Título - Autor")
    private List<String> libros = new ArrayList<>();

    @GetMapping("/")
    public String verLibros(Model model) {
        model.addAttribute("libros", libros);
        return "listView";
    }

    @GetMapping("/add")
    public String addLibro(@RequestParam String titulo, 
                           @RequestParam String autor, 
                           Model model) {
        //Creamos el string del libro y lo añadimos a la lista
        String libro = titulo + " - " + autor;
        libros.add(libro);

        //Enviamos lista actualizada a la vista
        model.addAttribute("libros", libros);

        //Devolvemos directamente la vista
        return "listView";
    }
}
