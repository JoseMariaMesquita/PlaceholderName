package gui;

import app.ColeccionLibro;
import app.GestorColeccionLibro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;

//ToDo terminar ventana principal de usuario
public class VentanaPrincipalUsuario extends JFrame {
    VentanaLogin identificcadorUsuario;
    GestorColeccionLibro gestor;

    //Paneles Basico
    //ToDo Convertir en GridBagLayout para establecer tamaños fijos de grid
    private JPanel mestraColeccion = new JPanel(new GridLayout(0,3,10,10));
    private JPanel barraSeleccion = new JPanel(new GridLayout(0,1,10,10));
    private JScrollPane scroll = new JScrollPane(mestraColeccion);

    //Paneles Especifico
    //Barra Seleccion
    private JPanel usuario = new JPanel(new GridLayout(2,1,10,10));
    private JPanel botoneraLibrosColeccion = new JPanel(new GridLayout(1,2,10,10));
    private JPanel buscadorTags = new JPanel(new GridLayout(0,1,10,10));

    //Botones
    private JButton añadirColeccion = new JButton("+ Coleccion");
    private JButton añadirLibro = new JButton("+ Libro");

    //Usuario
    private JLabel nombreUsuario = new JLabel("Nombre", SwingConstants.CENTER);




    public VentanaPrincipalUsuario(GestorColeccionLibro gestor) throws HeadlessException {
        this.gestor = gestor;
        inicializar();
    }

    private void inicializar(){
        //Configuracion Ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new GridLayout(1,2,10,10));
        this.setLayout(new GridLayout(1,2,10,10));
        this.setTitle("Biblioteca");
        this.setLocationRelativeTo(null);

        //BarraLateral
        this.usuario.add(nombreUsuario);

        this.botoneraLibrosColeccion.add(añadirColeccion);
        this.botoneraLibrosColeccion.add(añadirLibro);

        this.barraSeleccion.add(usuario);
        this.barraSeleccion.add(botoneraLibrosColeccion);
        this.barraSeleccion.add(buscadorTags);
        this.add(barraSeleccion);

        this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
        this.setSize(new Dimension(500,500));
        this.setVisible(true);

        añadirColeccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelLibro p = new PanelLibro();
                mestraColeccion.add(new PanelLibro());
                mestraColeccion.revalidate();
                mestraColeccion.repaint();
                revalidate();
                repaint();
            }
        });
    }
}
