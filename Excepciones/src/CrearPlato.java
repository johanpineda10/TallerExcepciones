import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;

public class CrearPlato extends JFrame{
    Container contenedor;
    JLabel jlNombre, jlDescripcion, jlCosto, jlTiempo, jlTipo;  
    JTextField jtNombre, jtCosto, jtTiempo;
    JTextArea jaDescripcion;
    JScrollPane scroll;
    JComboBox <String> jcTipo;

    public CrearPlato(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        jlNombre = new JLabel("Nombre del plato");
        jtNombre = new JTextField(10);
        contenedor.add(jlNombre);
        contenedor.add(jtNombre);

        jlDescripcion = new JLabel("Descripcion");
        jaDescripcion = new JTextArea(10,10);
        scroll = new JScrollPane(jaDescripcion);
        contenedor.add(jlDescripcion);
        contenedor.add(scroll);

        jlTipo = new JLabel("Tipo de plato");
        String tipo [] = {"Entrada","Bebida","Plato fuerte"};
        jcTipo = new JComboBox<String>(tipo);
        //jcTipo.addItemListener(this);
        contenedor.add(jlTipo);
        contenedor.add(jcTipo);

        jlTiempo = new JLabel("Tiempo de preparacion");
        jtTiempo = new JTextField(5);
        contenedor.add(jlTiempo);
        contenedor.add(jtTiempo);
        
        jlCosto = new JLabel("Costo del plato");
        jtCosto = new JTextField(5);
        contenedor.add(jtCosto);
        contenedor.add(jlCosto);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
    }
}
