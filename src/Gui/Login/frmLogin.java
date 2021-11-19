package Gui.Login;

import Gui.NuevoUsuario.frmNuevoUsuario;
import Gui.Principal.frmPrincipal;
import Negocio.Usuario.UsuarioNegocio;
import Recursos.Clases.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmLogin extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblLogin;
    private JPanel jpaContenido;
    private JLabel lblNombreUsuario;
    private JLabel lblContraseña;
    private JTextField txtNombre;
    private JTextField txtContraseña;
    private JPanel jpaBotones;
    private JButton aceptarButton;
    private JButton salirButton;
    private JButton crearUsuarioButton;




    public frmLogin() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int confirmar = JOptionPane.showConfirmDialog(null,"¿Quieres cerrar la aplicacion?","Salir",
                      JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
              if(confirmar == JOptionPane.YES_OPTION){
                  System.exit(0);
              }
            }
        });
        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Ventana Nuevo Usuario
                frmNuevoUsuario v = new frmNuevoUsuario();
                v.setVisible(true);
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                usuario.setNombre(txtNombre.getText());
                usuario.setClave(txtContraseña.getText());
                if((new UsuarioNegocio().validarUsuario(usuario))){
                    //Ventana Principal
                    frmPrincipal v = new frmPrincipal();
                    v.setVisible(true);
                    txtContraseña.setText("");
                    txtNombre.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña son incorrectos", "Error inicio de sesion", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Log In");
        frame.setContentPane(new frmLogin().jpaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ImageIcon imagen = new ImageIcon("src/Recursos/Imagenes/Principal/iconoLogin.png");
        frame.setIconImage(imagen.getImage());

    }
}
