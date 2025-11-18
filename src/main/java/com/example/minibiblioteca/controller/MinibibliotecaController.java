package com.example.minibiblioteca.controller;
import com.example.minibiblioteca.model.Libro; // Importamos nuestro modelo Libro
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MinibibliotecaController {

    //Lista dinámica de libros
    private List<Libro> libros = new ArrayList<>();

    //Contador para asignar IDs únicos a los libros
    private int nextId = 1;

    //Ruta principal: muestra la lista de libros
    @GetMapping("/")
    public String verLibros(Model model) {
        //Añadimos la lista de libros al modelo para enviarla a la vista
        model.addAttribute("libros", libros);
        return "listView"; //Retorna la vista HTML que renderiza la lista
    }

    //Ruta para añadir libros predefinidos con parámetros ?titulo=...&autor=...
    @GetMapping("/add")
    public String addLibro(@RequestParam String titulo,
                           @RequestParam String autor,
                           Model model) {

        //Creamos un nuevo libro con ID único y lo añadimos a la lista
        libros.add(new Libro(nextId++, titulo, autor));

        //Actualizamos el modelo para la vista
        model.addAttribute("libros", libros);

        //Retornamos la misma vista para que se muestre la lista actualizada
        return "listView";
    }

    //Ruta para eliminar un libro por ID
    @GetMapping("/delete/{id}")
    public String deleteLibro(@PathVariable int id) {

        //Eliminamos el libro cuyo ID coincida con el recibido
        libros.removeIf(l -> l.getId() == id);

        //Redirigimos a la página principal para ver la lista actualizada
        return "redirect:/";
    }

     // NUEVO: Ruta para cambiar el estado prestado/no prestado de un libro por ID
    @GetMapping("/toggle/{id}")
    public String togglePrestado(@PathVariable int id) {
        //Buscamos el libro con el ID indicado
        for (Libro l : libros) {
            if (l.getId() == id) {
                //Cambiamos su estado prestado
                l.setPrestado(!l.isPrestado());
                break; //Salimos del bucle al encontrarlo
            }
        }

        //Redirigimos a la página principal para ver la lista actualizada
        return "redirect:/";
    }
}

