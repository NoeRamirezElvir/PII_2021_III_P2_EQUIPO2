package Gui.Principal;

import Gui.Personas.frmPersonas;
import Gui.Cliente.frmCliente;
import Gui.Empleado.frmEmpleado;
import Gui.BienesInmuebles.frmBienesInmuebles;
import Gui.Casa.frmCasa;
import Gui.Terreno.frmTerreno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmPrincipal extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaContenido;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JButton btnPersona;
    private JButton btnCliente;
    private JButton btnEmpleado;
    private JButton btnInmueble;
    private JButton btnCasa;
    private JButton btnTerreno;
    JFrame ventana = new JFrame();

    public frmPrincipal(){
        setContentPane(this.jpaPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        ImageIcon imagen = new ImageIcon("src/Recursos/Imagenes/Principal/principal.png");
        setIconImage(imagen.getImage());


        btnPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmPersonas v = new frmPersonas();
                v.setVisible(true);
            }
        });
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmCliente v=new frmCliente();
                v.setVisible(true);
            }
        });
        btnEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmEmpleado v=new frmEmpleado();
                v.setVisible(true);
            }
        });
        btnInmueble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmBienesInmuebles v=new frmBienesInmuebles();
                v.setVisible(true);
            }
        });
        btnCasa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmCasa v=new frmCasa();
                v.setVisible(true);
            }
        });
        btnTerreno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmTerreno v=new frmTerreno();
                v.setVisible(true);
            }
        });
    }


}
