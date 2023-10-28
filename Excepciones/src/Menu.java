import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;

public class Menu extends JFrame{
    Container contenedor; 

    public Menu(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
    }
}
