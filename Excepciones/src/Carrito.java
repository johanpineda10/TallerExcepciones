import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;

public class Carrito extends JFrame{
    Container contenedor;
    public Carrito(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setVisible(true);
    }
}
