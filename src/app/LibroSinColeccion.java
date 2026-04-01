package app;

import java.awt.*;

public class LibroSinColeccion extends Libro{
    private String titulo;
    private String autor;
    private String editorial;
    private Image imagenLibro;

    /**
     * Crea una instancia del objeto LibroSinColeccion
     * @param paginas - Numero de paginas del libro
     * @param capitulos - numero de capitulos del libro
     * @param estado - estado del volumen [Leido, PorLeer, Empezddo]
     * @param titulo - Nombre del libro
     * @param autor - nombre del escritor ddel libro
     * @param editorial - nombre de la editorialque publica el libro
     */
    public LibroSinColeccion(Image imagenLibro,int paginas, int capitulos, int estado, String titulo, String autor, String editorial) {
        super(imagenLibro,paginas, capitulos, estado);
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.titulo +
                "Autor: " + this.autor +
                "Editorial: " + this.editorial +
                "Capitulos: " + super.getCapitulos() +
                "Páginas: " + super.getPaginas() +
                "Estado: " + super.getEstado();
    }
}
