package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//ToDo Terminar Mouse listener
public class PanelLibro extends JPanel {
    //Imagen
    JLabel coverImagen = new JLabel();
    JLabel titulo = new JLabel();

    public PanelLibro(JLabel coverImagen, JLabel titulo) {
        this.coverImagen = coverImagen;
        this.titulo = titulo;
    }

    private void inicializarPanel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(coverImagen);

        coverImagen.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
