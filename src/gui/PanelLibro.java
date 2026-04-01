package gui;

import app.ColeccionLibro;
import app.Libro;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelLibro extends JPanel {
    //Imagen
    private ColeccionLibro cl;
    private Image imagen;
    private JLabel labelImagen = new JLabel();
    private JLayeredPane panelImagen = new JLayeredPane();

    public PanelLibro() {
        this.setPreferredSize(new Dimension(10, 10));
        this.setMinimumSize(new Dimension(10, 10));
        this.setMaximumSize(new Dimension(10, 10));
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.add(new JLabel("Test"));



    }

    public PanelLibro(ColeccionLibro cl) {
        this.cl = cl;
        this.imagen = cl.getCoverColeccion();
    }

    private void inicializarPanel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));


        //Imagen
        labelImagen.setIcon(new ImageIcon(imagen.getScaledInstance((int)(this.getX()*0.2),(int)(this.getY()*0.2),Image.SCALE_SMOOTH)));
        labelImagen.setBounds(this.getX(),this.getY(),(int)(this.getX()*0.2),(int)(this.getY()*0.2));

        //Panel
        panelImagen.setPreferredSize(new Dimension((int) (this.getX()*0.2),(int)(this.getY()*0.2)));
        panelImagen.add(labelImagen);
        this.add(panelImagen);

        this.setVisible(true);
        panelImagen.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                InformacionLibro info = new InformacionLibro(PanelLibro.this,cl);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                labelImagen.setBounds(getX()-10,getY()-10,getX(),getY());
                labelImagen.setIcon(new ImageIcon(imagen.getScaledInstance(getX(),getY(),Image.SCALE_SMOOTH)));
                panelImagen.repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                labelImagen.setIcon(new ImageIcon(imagen.getScaledInstance((int)(getX()*0.2),(int)(getY()*0.2),Image.SCALE_SMOOTH)));
                labelImagen.setBounds(getX(),getY(),(int)(getX()*0.2),(int)(getY()*0.2));

                panelImagen.repaint();
            }
        });

    }
}
