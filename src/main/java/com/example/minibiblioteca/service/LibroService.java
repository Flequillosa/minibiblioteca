package com.example.minibiblioteca.service;

import com.example.minibiblioteca.model.Libro;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    // Lista dinámica de libros, inicialmente vacía.
    private List<Libro> libros = new ArrayList<>();

    // Contador para asignar IDs únicos a cada libro
    private int nextId = 1;

    // Devuelve todos los libros
    public List<Libro> getAll() {
        return libros;
    }

    // Añade un libro a la lista con un ID único
    public void addLibro(String titulo, String autor) {
        libros.add(new Libro(nextId++, titulo, autor));
    }

    // Elimina un libro por ID
    public void deleteLibro(int id) {
        libros.removeIf(l -> l.getId() == id); // Quita cualquier libro cuyo ID coincida
    }

    // Cambia el estado prestado/no prestado de un libro por ID
    public void toggleEstado(int id) {
        for (Libro l : libros) {// Recorre la lista de libros
            if (l.getId() == id) {// Cambia de true a false o viceversa
                l.setPrestado(!l.isPrestado());
                break;
            }
        }
    }

    // Filtra libros por estado: "prestados", "disponibles", o devuelve todos
    public List<Libro> filtrarPorEstado(String filtro) {
        switch (filtro) {
            case "prestados":
                return libros.stream().filter(Libro::isPrestado).collect(Collectors.toList());
            case "disponibles":
                return libros.stream().filter(l -> !l.isPrestado()).collect(Collectors.toList());
            default:
                return libros;// Si es "all" o cualquier otro valor, devuelve todos
        }
    }

    // Busca libros por título o autor, ignorando mayúsculas/minúsculas
    public List<Libro> buscar(String q) {
        if (q == null || q.trim().isEmpty())
            return libros;// Si la búsqueda está vacía, devuelve todos
        String query = q.toLowerCase();
        return libros.stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(query) ||
                        l.getAutor().toLowerCase().contains(query))
                .collect(Collectors.toList());
    }

    // Combina filtrado y búsqueda
    public List<Libro> obtenerFiltradosYBuscados(String filtro, String q) {
        List<Libro> resultado = filtrarPorEstado(filtro);// Primero filtramos por estado
        if (q != null && !q.trim().isEmpty()) {
            String query = q.toLowerCase();
            // Filtramos los resultados anteriores por título o autor
            resultado = resultado.stream()
                    .filter(l -> l.getTitulo().toLowerCase().contains(query) ||
                            l.getAutor().toLowerCase().contains(query))
                    .collect(Collectors.toList());
        }
        return resultado;// Devolvemos la lista final filtrada y buscada
    }
}
