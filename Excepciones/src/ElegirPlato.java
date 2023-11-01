import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Container;

public class ElegirPlato extends JFrame implements ActionListener, ItemListener{
    Container contenedor;
    JLabel jlTitu, jlNombre, jlDes, jlCosto, jlTiempo, jlTipo, jlResulTipo, jlResulTiempo, jlResulCosto;
    JComboBox <String> jcPlato;
    JTextArea jaDes;
    JScrollPane scroll;
    JButton btnAgregarCarrito, btnSalir, btnCarrito;
    String guar[][];
    int fila;
    String carro[][] = new String[20][5];
    int fi = 0;
    public ElegirPlato(String guarda[][], int fila){
        contenedor = getContentPane();
        setLocationRelativeTo(null);
        contenedor.setLayout(null);

        jlTitu = new JLabel("CARTA");
        jlTitu.setBounds(150, 10, 250, 20);
        jlTitu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlTitu);

        jlNombre = new JLabel("Nombre del plato: ");
        jlNombre.setBounds(90, 60, 250, 20);
        jlNombre.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        String p[] = new String[fila];
        for(int i = 0; i <fila;i++){
            p[i] = guarda[i][0]; 
        }
        System.out.println(guarda[0][0]);
        jcPlato = new JComboBox<String>(p);
        jcPlato.setBounds(270, 60, 150, 25);
        jcPlato.addItemListener(this);
        jcPlato.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        contenedor.add(jlNombre);
        contenedor.add(jcPlato);

        jlDes = new JLabel("Descripcion: ");
        jlDes.setBounds(90, 120, 250, 20);
        jlDes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jaDes = new JTextArea(5, 10);
        scroll = new JScrollPane(jaDes);
        scroll.setBounds(270, 100, 150, 80);
        contenedor.add(jlDes);
        contenedor.add(scroll);

        jlTipo = new JLabel("Tipo de plato:");
        jlTipo.setBounds(90, 200, 250, 20);
        jlTipo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jlResulTipo = new JLabel("");
        jlResulTipo.setBounds(270, 200, 150, 25);
        jlResulTipo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlTipo);
        contenedor.add(jlResulTipo);

        jlTiempo = new JLabel("Tiempo preparacion: ");
        jlTiempo.setBounds(90, 250, 180, 25);
        jlTiempo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jlResulTiempo = new JLabel("");
        jlResulTiempo.setBounds(270, 250, 150, 25);
        jlResulTiempo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlTiempo);
        contenedor.add(jlResulTiempo);

        jlCosto = new JLabel("Costo del plato:");
        jlCosto.setBounds(90, 310, 180, 25);
        jlCosto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jlResulCosto = new JLabel("");
        jlResulCosto.setBounds(270, 310, 150, 25);
        jlResulCosto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlCosto);
        contenedor.add(jlResulCosto);
        
        btnAgregarCarrito = new JButton("Comprar");
        btnAgregarCarrito.setBounds(80, 380, 110, 30);
        btnAgregarCarrito.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnAgregarCarrito.addActionListener(this);
        contenedor.add(btnAgregarCarrito);

        btnCarrito = new JButton("Carrito");
        btnCarrito.setBounds(200, 380, 100, 30);
        btnCarrito.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnCarrito.addActionListener(this);
        contenedor.add(btnCarrito);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(320, 380, 100, 30);
        btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnSalir.addActionListener(this);
        contenedor.add(btnSalir);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        this.guar = guarda;
        this.fila = fila;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregarCarrito) {
            agregar(carro, fi);
            fi++;
            JOptionPane.showMessageDialog(null, "Plato agregado al carrito");

            //dispose();
        } else if (e.getSource() == btnCarrito) {
            
            Carrito car = new Carrito(carro, fi);
            car.setVisible(true);
            dispose();
        } else if (e.getSource() == btnSalir) {
            dispose();
            Menu m = new Menu();
            m.setVisible(true);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange()==1){
            if(e.getSource()==jcPlato){
                for(int i= 0; i < fila; i++){
                    if(guar[i][0].equals(jcPlato.getSelectedItem())){
                        jaDes.setText(guar[i][1]);
                        jlResulTipo.setText(guar[i][2]);
                        jlResulTiempo.setText(guar[i][3]);
                        jlResulCosto.setText(guar[i][4]);
                    }
                }
            }
        }
    }

    public void agregar(String carros[][], int fila){
        carros[fila][0] = ""+jcPlato.getSelectedItem();
        carros[fila][1] = jaDes.getText();
        carros[fila][2] = jlResulTipo.getText();
        carros[fila][3] = jlResulTiempo.getText();
        carros[fila][4] = jlResulCosto.getText();
        this.carro = carros;
    }
}
