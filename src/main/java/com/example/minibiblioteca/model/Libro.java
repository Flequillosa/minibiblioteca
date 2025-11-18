package com.example.minibiblioteca.model;

//Esta clase representa un libro dentro de la mini biblioteca
public class Libro {
    // Atributos del libro
    private int id;
    private String titulo;
    private String autor;
    private boolean prestado; // Nuevo atributo

    // Constructor para inicializar un libro con ID, título y autor
    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters y setters para acceder y modificar los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    //Añadimos prestado
    public boolean isPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}