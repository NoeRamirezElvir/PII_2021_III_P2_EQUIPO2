package Gui.Personas;

import Negocio.Persona.PersonaNegocio;
import Recursos.Clases.Item;
import Recursos.Clases.Persona;
import com.sun.org.apache.xpath.internal.objects.XObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmPersonas extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JPanel jpaImagen;
    private JLabel lblImagen;
    private JPanel jpaContenido;
    private JTextField txtDNIP;
    private JTextField txtNombreP;
    private JTextField txtAPellidoP;
    private JTextField txtEdadP;
    private JTextField txtDireccionP;
    private JComboBox cboGeneroP;
    private JTextField txtTelefonoP;
    private JLabel lblDNI;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblEdad;
    private JLabel lblDireccion;
    private JLabel lblGenero;
    private JLabel lblTelefono;
    private JComboBox cboPersonasP;
    private JLabel lblPersonas;
    private JPanel jpaBotones;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    DefaultTableModel modelo;


    public frmPersonas() {
        //
        setTitle("Registro de Personas");
        setContentPane(this.jpaPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        ImageIcon imagen = new ImageIcon("src/Recursos/Imagenes/PersonaCE/iconoVentanaPersona32x32.png");
        setIconImage(imagen.getImage());
        //
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Persona persona = new Persona();
                    persona.setDNI(Long.parseLong(txtDNIP.getText()));
                    persona.setNombre(txtNombreP.getText());
                    persona.setApellido(txtAPellidoP.getText());
                    persona.setEdad(Integer.parseInt(txtEdadP.getText()));
                    persona.setDireccion(txtDireccionP.getText());
                    persona.setGenero(String.valueOf(cboGeneroP.getSelectedItem()));
                    persona.setTelefono(Long.parseLong(txtTelefonoP.getText()));
                    String respuesta = new PersonaNegocio().Insertar(persona);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboPersonas();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Persona persona = new Persona();
                    persona.setDNI(Long.parseLong(txtDNIP.getText()));
                    persona.setNombre(txtNombreP.getText());
                    persona.setApellido(txtAPellidoP.getText());
                    persona.setEdad(Integer.parseInt(txtEdadP.getText()));
                    persona.setDireccion(txtDireccionP.getText());
                    persona.setGenero(String.valueOf(cboGeneroP.getSelectedItem()));
                    persona.setTelefono(Long.parseLong(txtTelefonoP.getText()));
                    String respuesta = new PersonaNegocio().Actualizar(persona);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Actualizado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboPersonas();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int confirmar = JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar el registro?",
                            "Eliminar Precaucion",JOptionPane.WARNING_MESSAGE);
                    if(confirmar == JOptionPane.YES_OPTION){
                        Persona persona = new Persona();
                        persona.setDNI(Long.parseLong(txtDNIP.getText()));
                        persona.setNombre(txtNombreP.getText());
                        persona.setApellido(txtAPellidoP.getText());
                        persona.setEdad(Integer.parseInt(txtEdadP.getText()));
                        persona.setDireccion(txtDireccionP.getText());
                        persona.setGenero(String.valueOf(cboGeneroP.getSelectedItem()));
                        persona.setTelefono(Long.parseLong(txtTelefonoP.getText()));
                        new PersonaNegocio().Eliminar(persona);
                        limpiar();
                        leerDatos();
                        llenarComboPersonas();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Persona persona = new Persona();
                    persona.setNombre(txtNombreP.getText());
                    List<Persona> listaPersona = new PersonaNegocio().Buscar(persona);
                    modelo.setRowCount(0);
                    for(Persona item: listaPersona){
                        Object [] registro = {
                                item.getDNI(),
                                item.getNombre(),
                                item.getApellido(),
                                item.getEdad(),
                                item.getDireccion(),
                                item.getGenero(),
                                item.getTelefono()
                        };
                        modelo.addRow(registro);
                    }
                    tblDatos.setModel(modelo);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                txtDNIP.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                txtNombreP.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                txtAPellidoP.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtEdadP.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                txtDireccionP.setText(modelo.getValueAt(filaSeleccionada,4).toString());
                cboGeneroP.setSelectedItem(modelo.getValueAt(filaSeleccionada,5).toString());
                txtTelefonoP.setText(modelo.getValueAt(filaSeleccionada,6).toString());
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
                llenarComboPersonas();
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboPersonasP.getSelectedItem();
                long itemPersona = ((Item)objeto).getID();
                JOptionPane.showMessageDialog(null,"DNI: " + itemPersona);
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }
    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");
        modelo.addColumn("Direccion");
        modelo.addColumn("Genero");
        modelo.addColumn("Telefono");
        limpiar();
        leerDatos();
        llenarComboPersonas();
    }
    public void limpiar(){
        txtDNIP.setText("0");
        txtNombreP.setText("");
        txtAPellidoP.setText("");
        txtEdadP.setText("0");
        txtDireccionP.setText("");
        txtTelefonoP.setText("0");
    }
    private void llenarComboPersonas(){
        try{
            List<Persona> listaPersona = new PersonaNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for(Persona persona: listaPersona){
                Item item = new Item(persona.getDNI(),persona.getNombre());
                modeloCombo.addElement(item);
            }
            cboPersonasP.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void leerDatos() {
        try{
            List<Persona> listaPersona = new PersonaNegocio().Leer();
            modelo.setRowCount(0);
            for(Persona persona: listaPersona){
                Object [] registro = {
                        persona.getDNI(),
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getEdad(),
                        persona.getDireccion(),
                        persona.getGenero(),
                        persona.getTelefono()
                };
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
