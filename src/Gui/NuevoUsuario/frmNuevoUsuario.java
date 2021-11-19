package Gui.NuevoUsuario;

import Negocio.Usuario.UsuarioNegocio;
import Recursos.Clases.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class frmNuevoUsuario extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JPanel jpaContenido;
    private JLabel lblNombreUsuario;
    private JLabel lblContraseña;
    private JTextField txtNombre;
    private JTextField txtContraseña;
    private JPanel jpaBotones;
    private JButton btnCrear;
    private JButton btnCancelar;
    private long contador = 0;


    public frmNuevoUsuario() {
        //Iniciar el form
        setTitle("Nuevo Usuario");
        setContentPane(this.jpaPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);

        ImageIcon imagen = new ImageIcon("src/Recursos/Imagenes/Principal/iconoNuevoUsuario32x32.png");
        setIconImage(imagen.getImage());
        ///



        //ventanaUsuario.setContentPane(new frmNuevoUsuario().jpaPrincipal);
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    contador++;
                    Usuario usuario = new Usuario();
                    usuario.setNumeroCuenta(contador);
                    usuario.setNombre(txtNombre.getText());
                    usuario.setClave(txtContraseña.getText());
                    if(new UsuarioNegocio().validarNombreUsuario(usuario)){
                        throw new Exception("El usuario ya esta en uso.");
                    }
                    String respuesta = new UsuarioNegocio().insertar(usuario);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        txtNombre.setText("");
                        txtContraseña.setText("");
                    } else {
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
