package com.example.minibiblioteca.controller;
import com.example.minibiblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class LibroController {
    // Inyectamos el servicio que maneja la lógica de negocio
    @Autowired
    private LibroService libroService;

    // Mostrar libros, filtros y búsqueda
    @GetMapping("/")
    public String verLibros(Model model,
            @RequestParam(value = "filtro", required = false, defaultValue = "all") String filtro,
            @RequestParam(value = "q", required = false) String q,
            @RequestParam(value = "txtMensaje", required = false) String txtMensaje,
            @RequestParam(value = "txtError", required = false) String txtError) {

        // Llama al servicio para obtener la lista de libros filtrada y/o buscada
        model.addAttribute("libros", libroService.obtenerFiltradosYBuscados(filtro, q));
        // Añadimos los parámetros a la vista para mantener el estado de búsqueda/filtro
        // y mensajes
        model.addAttribute("filtro", filtro);
        model.addAttribute("q", q);
        model.addAttribute("txtMensaje", txtMensaje);
        model.addAttribute("txtError", txtError);
        return "listLibros"; // Nombre de la vista Thymeleaf que se va a renderizar
    }

    // Añadir libro
    @GetMapping("/add")
    public String addLibro(@RequestParam("titulo") String titulo,
            @RequestParam(value = "autor", required = false) String autor) {
        // Validación: el título no puede estar vacío
        if (titulo == null || titulo.trim().isEmpty()) {
            String err = "El título no puede estar vacío";
            // Redirige a la raíz pasando el mensaje de error codificado en la URL
            return "redirect:/?txtError=" + URLEncoder.encode(err, StandardCharsets.UTF_8);
        }
        // Llamamos al servicio para añadir el libro
        libroService.addLibro(titulo, autor);
        // Creamos un mensaje de éxito
        String mensaje = "Libro añadido correctamente: " + titulo;
        // Redirige a la raíz pasando el mensaje de éxito codificado en la URL
        return "redirect:/?txtMensaje=" + URLEncoder.encode(mensaje, StandardCharsets.UTF_8);
    }

    // Eliminar libro
    @GetMapping("/delete/{id}") // Ruta dinámica con el id del libro a eliminar
    public String deleteLibro(@PathVariable int id) {
        // Llamamos al servicio para eliminar el libro
        libroService.deleteLibro(id);
        // Creamos un mensaje de éxito
        String mensaje = "Libro eliminado correctamente (id:" + id + ")";
        // Redirige a la raíz pasando el mensaje de éxito
        return "redirect:/?txtMensaje=" + URLEncoder.encode(mensaje, StandardCharsets.UTF_8);
    }

    // Cambiar estado prestado/no prestado
    @GetMapping("/toggle/{id}") // Ruta dinámica con el id del libro a modificar
    public String togglePrestado(@PathVariable int id) {
        // Llamamos al servicio para cambiar el estado del libro
        libroService.toggleEstado(id);
        // Creamos un mensaje de éxito
        String mensaje = "Estado cambiado (id del libro :" + id + ")";
        // Redirige a la raíz pasando el mensaje de éxito
        return "redirect:/?txtMensaje=" + URLEncoder.encode(mensaje, StandardCharsets.UTF_8);
    }
}
