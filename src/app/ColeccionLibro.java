package app;

import exceptions.ArrayTagLlenoException;
import exceptions.LibroNoExistenteException;
import exceptions.LibroYaEnColeccionException;

import java.awt.*;
import java.util.Arrays;
import java.util.TreeSet;

public class ColeccionLibro implements Comparable<ColeccionLibro> {
    private Image coverColeccion;
    private String titulo;
    private String autor;
    private String estadoPublicacion;
    private String estadoColeccion;
    private int totalVolumenes;
    private int volumenesPoseidos;
    private String[] tags = new String[3];
    private TreeSet<Libro> coleccionVolumens = new TreeSet<Libro>();

    //Constantes de estado
    //Publicacion
    public static final int COMPLETADO = 0;
    public static final int EN_EMISION = 1;
    public static final int HIATUS = 2;
    public static final int CANCELADO = 3;

    //Coleccion
    public static final int CONTINUA = 1;
    public static final int ABANDONADO = 2;

    public ColeccionLibro() {
    }

    /**
     * Crea una instancia de ColeccionLibro
     *
     * @param coverColeccion    - Cover de la coleccion de libros
     * @param titulo            - Titulo de la coleccion de libros
     * @param autor             - Nombre del escritor de lo libros
     * @param estadoPublicacion - Estado de piblicacion de la coleccion [Completado - EnEmision - Hiatus - Cancelado]
     * @param estadoColeccion   - Estado de la coleccion [Completado - Continua - Abandonado]
     * @param totalVolumenes    - Numero total devolumenes al dia de hoy
     * @param volumenesPoseidos - Numero total de volumenes que tengo en la coleccion
     */
    public ColeccionLibro(Image coverColeccion, String titulo, String autor, String estadoPublicacion, String estadoColeccion, int totalVolumenes, int volumenesPoseidos) {
        this.coverColeccion = coverColeccion;
        this.titulo = titulo;
        this.autor = autor;
        this.estadoPublicacion = estadoPublicacion;
        this.estadoColeccion = estadoColeccion;
        this.totalVolumenes = totalVolumenes;
        this.volumenesPoseidos = volumenesPoseidos;
    }

    public Image getCoverColeccion() {
        return coverColeccion;
    }

    public void setCoverColeccion(Image coverColeccion) {
        this.coverColeccion = coverColeccion;
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

    public String getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(String estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public String getEstadoColeccion() {
        return estadoColeccion;
    }

    public void setEstadoColeccion(String estadoColeccion) {
        this.estadoColeccion = estadoColeccion;
    }

    public int getTotalVolumenes() {
        return totalVolumenes;
    }

    public void setTotalVolumenes(int totalVolumenes) {
        this.totalVolumenes = totalVolumenes;
    }

    public int getVolumenesPoseidos() {
        return volumenesPoseidos;
    }

    public void setVolumenesPoseidos(int volumenesPoseidos) {
        this.volumenesPoseidos = volumenesPoseidos;
    }

    public String[] getTags() {
        return tags;
    }

    /**
     * Añade una tag nueva a las tags, si el array de tags esta lleno lanza una excepcion
     * @param tag - nombre de la tag que se quiere aññaddir
     * @return - true si ha añadido la tag
     * @throws ArrayTagLlenoException - Excepcion que se lanza si el arra de tags con un limite de 3, estálleno
     */
    public boolean addTags(String tag) throws ArrayTagLlenoException {
        for (int i = 0; i < this.getTags().length; i++) {
            if(tags[i].isEmpty()){
                tags[i] = tag;
                return true;
            }
        }
        throw new ArrayTagLlenoException();
    }

    public TreeSet<Libro> getColeccionVolumens() {
        return coleccionVolumens;
    }

    public void setColeccionVolumens(TreeSet<Libro> coleccionVolumens) {
        this.coleccionVolumens = coleccionVolumens;
    }

    /**
     * Añade libro a la coleccion de libros si no lo añade lanza el error
     * de Libro ya en coleccion
     *
     * @param l - Libro que desea a añadir
     * @throws LibroYaEnColeccionException - Error que se lanza si un libro ya esta presente en la collecion al momento de añadirlo
     */
    public void añadirLibro(Libro l) throws LibroYaEnColeccionException {
        if (!coleccionVolumens.add(l)) {
            throw new LibroYaEnColeccionException();
        }
    }

    /**
     * Elimina libro que tiene el volumen
     *
     * @param volumen - Numero del libro de la coleccion
     * @throws LibroNoExistenteException - Si el librono existe
     */
    public void eliminarLibro(int volumen) throws LibroNoExistenteException {
        if (!this.coleccionVolumens.removeIf(libro -> libro.getVolumen() == volumen)) {
            throw new LibroNoExistenteException();
        }

    }

    /**
     * Establece el estado de un libro de la coleccion
     *
     * @param volumen        - volumen del que se quiere cambiar el estado
     * @param variableEstado - Variable de estado
     */
    public void establecerEstadoLibro(int volumen, int variableEstado) {
        for (Libro l : coleccionVolumens) {

            if (l.getVolumen() == volumen) {

                l.setEstado(variableEstado);
            }


        }

    }

    /**
     * Establece la Cover image del libro
     *
     * @param volumen    - Volumen del libro que se quiere modificar
     * @param coverImage - Imagen de cover del libro
     */
    public void cambiarCover(int volumen, Image coverImage) {
        for (Libro l : coleccionVolumens) {
            if (l.getVolumen() == volumen) {
                l.setCoverVolumen(coverImage);
            }
        }
    }

    /**
     * Asigna/Cambia el estado de un libro
     * @param volumen
     * @param estado
     */
    public void cambiarEstadoLibro (int volumen, int estado){
        for (Libro l: this.coleccionVolumens){
            if(l.getVolumen() == volumen){
                l.setEstado(estado);
            }
        }
    }

    @Override
    public int compareTo(ColeccionLibro cl) {
        if (this.titulo.compareTo(cl.titulo) == 0) {
            return 0;
        } else if (this.titulo.compareTo(cl.titulo) == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "ColeccionLibro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", estadoPublicacion='" + estadoPublicacion + '\'' +
                ", estadoColeccion='" + estadoColeccion + '\'' +
                ", totalVolumenes=" + totalVolumenes +
                ", volumenesPoseidos=" + volumenesPoseidos +
                ", tags=" + Arrays.toString(tags) +
                ", coleccionVolumens=" + coleccionVolumens +
                '}';
    }
}
