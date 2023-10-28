import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;

public class CrearPlato extends JFrame{
    Container contenedor;
    public CrearPlato(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
    }
}
