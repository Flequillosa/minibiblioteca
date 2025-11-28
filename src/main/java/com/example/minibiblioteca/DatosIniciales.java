package com.example.minibiblioteca;

import com.example.minibiblioteca.service.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Marcamos esta clase como componente de Spring para que se detecte automáticamente
@Component
public class DatosIniciales implements CommandLineRunner {

    // Declaramos una referencia al servicio de libros;
    private final LibroService libroService;

    // Constructor donde Spring inyecta automáticamente el LibroService
    public DatosIniciales(LibroService libroService) {
        this.libroService = libroService;
    }

    // Método que se ejecuta automáticamente al iniciar la aplicación
    @Override
    public void run(String... args) throws Exception {
        // Añadimos libros de ejemplo al iniciar la aplicación
        libroService.addLibro("El Quijote", "Miguel de Cervantes");
        libroService.addLibro("Cien años de soledad", "Gabriel García Márquez");
        libroService.addLibro("1984", "George Orwell");
    }
}
