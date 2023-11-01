import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearPlato extends JFrame implements ActionListener {
    Container contenedor;
    JLabel jlTitu, jlNombre, jlDescripcion, jlCosto, jlTiempo, jlTipo;
    JTextField jtNombre, jtCosto, jtTiempo;
    JTextArea jaDescripcion;
    JScrollPane scroll;
    JComboBox<String> jcTipo;
    JButton btnGuardar, btnSalir;
    int fila;
    String guarda[][];
    Menu menu;

    public CrearPlato(String[][] guarda, int fila, Menu menu) {
        
        contenedor = getContentPane();
        setLocationRelativeTo(null);
        contenedor.setLayout(null);

        jlTitu = new JLabel("CREACION DE PLATOS");
        jlTitu.setBounds(150, 10, 250, 20);
        jlTitu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlTitu);

        jlNombre = new JLabel("Nombre del plato: ");
        jlNombre.setBounds(90, 60, 250, 20);
        jlNombre.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jtNombre = new JTextField(20);
        jtNombre.setBounds(270, 60, 150, 25);
        contenedor.add(jlNombre);
        contenedor.add(jtNombre);

        jlDescripcion = new JLabel("Descripcion: ");
        jlDescripcion.setBounds(90, 120, 250, 20);
        jlDescripcion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jaDescripcion = new JTextArea(5, 10);
        scroll = new JScrollPane(jaDescripcion);
        scroll.setBounds(270, 100, 150, 80);
        contenedor.add(jlDescripcion);
        contenedor.add(scroll);

        jlTipo = new JLabel("Tipo de plato:");
        jlTipo.setBounds(90, 200, 250, 20);
        jlTipo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        String tipo[] = { "Entrada", "Bebida", "Plato fuerte" };
        jcTipo = new JComboBox<String>(tipo);
        jcTipo.setBounds(270, 200, 150, 25);
        jcTipo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        // jcTipo.addItemListener(this);
        contenedor.add(jlTipo);
        contenedor.add(jcTipo);

        jlTiempo = new JLabel("Tiempo preparacion: ");
        jlTiempo.setBounds(90, 250, 180, 25);
        jlTiempo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jtTiempo = new JTextField(5);
        jtTiempo.setBounds(270, 250, 150, 25);
        jtTiempo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jlTiempo);
        contenedor.add(jtTiempo);

        jlCosto = new JLabel("Costo del plato:");
        jlCosto.setBounds(90, 310, 180, 25);
        jlCosto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jtCosto = new JTextField(5);
        jtCosto.setBounds(270, 310, 150, 25);
        jtCosto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contenedor.add(jtCosto);
        contenedor.add(jlCosto);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 380, 100, 30);
        btnGuardar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnGuardar.addActionListener(this);
        contenedor.add(btnGuardar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(270, 380, 100, 30);
        btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnSalir.addActionListener(this);
        contenedor.add(btnSalir);

        this.guarda = guarda;
        this.fila = fila;
        this.menu= menu;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            Crear(guarda, fila);
            menu.setVisible(true);
            dispose();
        } else if (e.getSource() == btnSalir) {
            dispose();
            Menu m = new Menu();
            m.setVisible(true);
        }
    }

    public void Crear(String crear[][], int fila) {
        if(jtNombre.getText().equals("") || jaDescripcion.getText().equals("") || jcTipo.getSelectedItem().equals("") || jtTiempo.getText().equals("")||jtCosto.getText().equals("crear")){
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
        }else{
            String nombre = jtNombre.getText();
            String descrip = jaDescripcion.getText();
            String tipo = "" + jcTipo.getSelectedItem();
            try{
            int tiempo = Integer.parseInt(jtTiempo.getText());
            int precio = Integer.parseInt(jtCosto.getText());

            crear[fila][0] = nombre;
            crear[fila][1] = descrip;
            crear[fila][2] = tipo;
            crear[fila][3] = "" + tiempo;
            crear[fila][4] = "" + precio;
            fila++;
            
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Digite numeros");
                return;
            }
            JOptionPane.showMessageDialog(null, "Plato Creado con exito");
            this.guarda = crear;
        }
    }
        
}

