package app;

import exceptions.ArrayTagLlenoException;
import exceptions.ColeccionNoExistenteException;
import exceptions.ColeccionYaExistenteException;
import exceptions.EstadoInexistenteException;

import java.util.TreeSet;

public class GestorColeccionLibro {

    private TreeSet<ColeccionLibro> gestorColecciones = new TreeSet<ColeccionLibro>();

    public GestorColeccionLibro() {
    }

    /**
     * Añade una coleccion de libros al gestor de colecciones de libros
     *
     * @param cl - Coleccion de libros
     * @throws ColeccionYaExistenteException - Excepcion que se lanza si la coleccion ya se encuentra en el gestor
     */
    private void añadirLibro(ColeccionLibro cl) throws ColeccionYaExistenteException {
        if (!this.gestorColecciones.add(cl)) {
            throw new ColeccionYaExistenteException();
        }
    }

    /**
     * Elimina una coleccion de libros
     * @param titulo - titulo la coleccion
     * @throws ColeccionNoExistenteException - Excepcion que se lanza si la coleccion no se encuentra en el gestor
     */
    private void eliminarColeccion(String titulo) throws ColeccionNoExistenteException {
        if (this.gestorColecciones.removeIf(coleccionLibro ->
                coleccionLibro.getTitulo().toLowerCase().strip().equals(titulo.toLowerCase().strip()))) {
            throw new ColeccionNoExistenteException();
        }
    }

    //ToDo Mejorar esto para que se haga con numero en vez de con string, no tiene sentdo la forma en la que lo estoy haciendo
    /**
     * Cambia el estado de la coleccion
     * @param titulo - nombre de lacoleccion a editar
     * @param estado - estado de la coleccion
     * @throws EstadoInexistenteException
     */
    private void cambiarEstadoColeccion(String titulo, int estado) throws EstadoInexistenteException, ColeccionNoExistenteException {
        String[] estados = {"Completado","Continua","Abandonado"};
        boolean coleccionEnGestor = false;
        for (ColeccionLibro cl: gestorColecciones){
            if(cl.getTitulo().toLowerCase().strip().equals(titulo.toLowerCase().strip())){
                coleccionEnGestor = true;
                switch (estado){
                    case 0->{
                        cl.setEstadoColeccion(estados[ColeccionLibro.COMPLETADO]);
                    }

                    case 1 ->{
                        cl.setEstadoColeccion(estados[ColeccionLibro.CONTINUA]);
                    }

                    case 2 ->{
                        cl.setEstadoColeccion(estados[ColeccionLibro.ABANDONADO]);
                    }

                    default -> {
                        throw new EstadoInexistenteException();
                    }
                }
            }
        }

        if(!coleccionEnGestor){
            throw new ColeccionNoExistenteException();
        }
    }

    /**
     * Cambia el estado de la publicacion
     * @param titulo - nombre de lacoleccion a editar
     * @param estado - estado de la coleccion
     * @throws EstadoInexistenteException
     */
    private void cambiarEstadoPublicacion(String titulo, int estado) throws EstadoInexistenteException, ColeccionNoExistenteException{
        String[] estados = {"Completado","En Emisión","Hiatus","Cancelado"};
        boolean coleccionEnGestor = false;
        for (ColeccionLibro cl: gestorColecciones){
            if(cl.getTitulo().toLowerCase().strip().equals(titulo.toLowerCase().strip())){
                coleccionEnGestor = true;
                switch (estado){
                    case 0->{
                        cl.setEstadoColeccion(estados[ColeccionLibro.COMPLETADO]);
                    }

                    case 1 ->{
                        cl.setEstadoColeccion(estados[ColeccionLibro.EN_EMISION]);
                    }

                    case 2 ->{
                        cl.setEstadoColeccion(estados[ColeccionLibro.HIATUS]);
                    }

                    case 3 ->{
                        cl.setEstadoColeccion(estados[ColeccionLibro.CANCELADO]);
                    }

                    default -> {
                        throw new EstadoInexistenteException();
                    }
                }
            }
        }

        if(!coleccionEnGestor){
            throw new ColeccionNoExistenteException();
        }
    }

    /**
     * Asigna tag a la coleccion
     * @param titulo - nombre de la coleccion a la que se le quiere añadir una tag
     * @param tags - nombre de la tag que se quiere asignar
     * @throws ColeccionNoExistenteException - Excepcion que se lanza cuando no se encuentra la coleccion
     * @throws ArrayTagLlenoException - Excepcion que se lanza cuando el array de tags esta lleno es decir se  llega al limite de tags
     */
    private void asignarTags(String titulo, String tags) throws ColeccionNoExistenteException, ArrayTagLlenoException{
        boolean coleccionEnGestor = false;
        for (ColeccionLibro cl: gestorColecciones){
            if(cl.getTitulo().toLowerCase().strip().equals(titulo)){
                coleccionEnGestor = true;
                cl.addTags(tags);
            }
        }

        if(!coleccionEnGestor){
            throw new ColeccionNoExistenteException();
        }
    }



}
