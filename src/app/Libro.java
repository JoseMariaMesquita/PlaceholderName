package app;

import java.awt.*;

public class Libro implements Comparable<Libro>{
    //En caso de no pertenecer a ninguna coleccion
    private Image coverVolumen;
    private int volumen;
    private int paginas;
    private int capitulos;
    private int estado;

    //Constantes de Estado
    public static final int LIBRO_LEIDO = 2;
    public static final int LIBRO_EMPEZADO = 1;
    public static final int LIBRO_POR_LEER = 0;

    /**
     * Constructos para aquellos libros que forman parte de una coleccion
     * @param volumen - Dentro dela coleccion que volumen es
     * @param paginas - numero de paginas del volumen
     * @param capitulos - numerode capitulos del volumen
     * @param estado - estado del volumen [Leido, PorLeer, Empezddo]
     */
    public Libro(Image coverVolumen,int volumen, int paginas, int capitulos, int estado) {
        this.coverVolumen = coverVolumen;
        this.volumen = volumen;
        this.paginas = paginas;
        this.capitulos = capitulos;
        this.estado = estado;
    }

    public Libro(Image coverVolumen,int paginas, int capitulos, int estado) {
        this.coverVolumen = coverVolumen;
        this.paginas = paginas;
        this.capitulos = capitulos;
        this.estado = estado;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Image getCoverVolumen() {
        return coverVolumen;
    }

    public void setCoverVolumen(Image coverVolumen) {
        this.coverVolumen = coverVolumen;
    }

    @Override
    /**
     * Devolvera un valor dependiendode la comparacion de un atributo con ese mismo atributo de un objeto
     * del mismo tipo. Siendo los valores 0 sison iguales, 1 si es mayor, -1 si es menor;
     */
    public int compareTo(Libro l) {
        if(this.volumen == l.volumen){
            return 0;
        }else if(this.volumen > l.volumen){
            return 1;
        }else{
            return -1;
        }
    }

}
