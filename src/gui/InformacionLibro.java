package gui;

import app.ColeccionLibro;
import app.GestorColeccionLibro;
import app.Libro;

import javax.swing.*;

public class InformacionLibro extends JLabel {
    private JPanel origen;
    private GestorColeccionLibro gestor;
    private ColeccionLibro cl;


    public InformacionLibro(JPanel origen, ColeccionLibro cl) {
        this.origen = origen;
        this.cl = cl;
    }
}
