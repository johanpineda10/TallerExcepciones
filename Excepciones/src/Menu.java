import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{
    Container contenedor; 
    JButton btnCP, btnEP, btnC;

    public Menu(){
        contenedor = getContentPane();
        setLocationRelativeTo(null);
        contenedor.setLayout(null);

        btnCP = new JButton("CREAR PLATO");
        btnCP.setBounds(120, 50, 150, 40);
        btnCP.addActionListener(this);
        contenedor.add(btnCP);

        btnEP = new JButton("ELEGIR PLATO");
        btnEP.setBounds(120, 100, 150, 40);
        contenedor.add(btnEP);

        btnC = new JButton("CARRITO");
        btnC.setBounds(120, 150, 150, 40);
        contenedor.add(btnC);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCP){
            dispose();
            new CrearPlato();
           //cp.setVisible(true);
        }else if(e.getSource() == btnEP){
            dispose();
            new ElegirPlato();
        }else if(e.getSource() == btnC){
            dispose();
            new Carrito();
        }
    }
}
