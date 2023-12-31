import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;

public class Carrito extends JFrame implements ActionListener{
    Container contenedor;
    JLabel jlTitulo, jlPlatos, jlTotal, jlResulTotal, jlInfo, jlDuracion, jlResulDura;
    JTextArea jaPlatos;
    JScrollPane scroll;
    JButton btnComprar, btnSalir;
    
    int total = 0;
    int duracion = 0;
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
        scroll.setBounds(180, 60, 250, 200);
        contenedor.add(jlPlatos);
        contenedor.add(scroll);
        jlInfo = new JLabel("Nombre  "+"Descripcion   "+"Tipo  "+"Tiempo  "+"Costo  ");
        jlInfo.setBounds(180, 40, 250, 20);
        jlInfo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        
        String datos = "";
        for(int i = 0; i< fila; i++){
            datos += carro[i][0]+",   "+carro[i][1]+",   "+carro[i][2]+",   "+ carro[i][3]+",   "+carro[i][4]+"\n";
            total += Integer.parseInt(carro[i][4]);
            duracion += Integer.parseInt(carro[i][3]);
        }
        
        jaPlatos.setText(datos);
        jlTotal = new JLabel("Total de la compra: ");
        jlTotal.setBounds(90, 280, 250, 20);
        jlTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jlResulTotal = new JLabel("");
        jlResulTotal.setBounds(260, 280, 150, 20);
        jlResulTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlTotal);
        contenedor.add(jlResulTotal);
        contenedor.add(jlInfo);

        jlDuracion = new JLabel("Duracion (minutos): ");
        jlDuracion.setBounds(90, 310, 300, 20);
        jlDuracion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jlResulDura = new JLabel("");
        jlResulDura.setBounds(260, 310, 250, 20);
        jlResulDura.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlDuracion);
        contenedor.add(jlResulDura);

        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(140, 370, 110, 30);
        btnComprar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnComprar.addActionListener(this);
        contenedor.add(btnComprar);

        jlResulTotal.setText(""+total);
        jlResulDura.setText(""+duracion);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(270, 370, 100, 30);
        btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnSalir.addActionListener(this);
        contenedor.add(btnSalir);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnComprar) {
            try{
                if(total > 200000){
                    throw new ExcepTipo("Que vas a pagar ese monton por una comida");
                }
                if(duracion > 60){
                    throw new ExcepTipo("Mucha demora con esa comida, no la compres");
                }
                if(total < 200000 && duracion <= 60){
                    JOptionPane.showMessageDialog(null, "Compra realizada");
                    dispose();
                }
            }catch(ExcepTipo ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
        } else if (e.getSource() == btnSalir) {
            dispose();
            Menu m = new Menu();
            m.setVisible(true);
        }
    }
}
