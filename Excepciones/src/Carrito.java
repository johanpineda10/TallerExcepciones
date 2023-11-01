import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Container;
import java.awt.FlowLayout;

public class Carrito extends JFrame{
    Container contenedor;
    JLabel jlTitulo, jlPlatos, jlTotal, jlResulTotal;
    JTextArea jaPlatos;
    JScrollPane scroll;
    JButton btnComprar, btnSalir;
    
    public Carrito(String carro[][], int fila){
        contenedor = getContentPane();
        contenedor.setLayout(null);

        jlTitulo = new JLabel("CARRITO DE COMPRAS");
        jlTitulo.setBounds(150, 10, 250, 20);
        jlTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlTitulo);

        jlPlatos = new JLabel("Factura: ");
        jlPlatos.setBounds(90, 60, 250, 20);
        jlPlatos.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jaPlatos = new JTextArea(5, 10);
        scroll = new JScrollPane(jaPlatos);
        scroll.setBounds(180, 60, 200, 200);
        contenedor.add(jlPlatos);
        contenedor.add(scroll);

        jlTotal = new JLabel("Total: ");
        jlTotal.setBounds(90, 280, 250, 20);
        jlTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jlResulTotal = new JLabel("");
        jlResulTotal.setBounds(150, 280, 150, 20);
        jlResulTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlTotal);
        contenedor.add(jlResulTotal);

        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(140, 350, 110, 30);
        btnComprar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        //btnComprar.addActionListener(this);
        contenedor.add(btnComprar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(270, 350, 100, 30);
        btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        //btnSalir.addActionListener(this);
        contenedor.add(btnSalir);

        jlResulTotal.setText(carro[0][0]);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
}
