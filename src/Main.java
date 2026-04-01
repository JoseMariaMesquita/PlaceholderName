import app.ColeccionLibro;
import app.GestorColeccionLibro;
import app.Libro;
import gui.PanelLibro;
import gui.VentanaLogin;
import gui.VentanaPrincipalUsuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //Test
    GestorColeccionLibro g = new GestorColeccionLibro();
    VentanaPrincipalUsuario p = new VentanaPrincipalUsuario(g);
}
