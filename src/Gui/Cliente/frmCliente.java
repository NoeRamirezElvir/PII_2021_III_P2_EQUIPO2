package Gui.Cliente;

import Negocio.Cliente.ClienteNegocio;
import Negocio.Persona.PersonaNegocio;
import Recursos.Clases.Cliente;
import Recursos.Clases.Item;
import Recursos.Clases.ItemCE;
import Recursos.Clases.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class frmCliente extends JFrame {
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblCliente;
    private JLabel lblImagen;
    private JPanel jpaContenido;
    private JLabel lblNombre;
    private JComboBox cboDNICP;
    private JTextField txtCodigoC;
    private JTextField txtFechaIngreso;
    private JTextField txtSaldoC;
    private JTextField txtCorreoElectronicoC;
    private JTextField txtOcupacionC;
    private JLabel lblCodigoC;
    private JLabel lblCategoriaC;
    private JComboBox cboCategoriaC;
    private JLabel lblfechaIngresoC;
    private JLabel lblSaldoC;
    private JLabel lblCorreoElectronicoC;
    private JLabel lblOcupacionC;
    private JLabel lblMembresiaC;
    private JComboBox cboTipoMembresia;
    private JPanel jpaBotones;
    private JButton btnRegistrarC;
    private JButton btnActualizarC;
    private JButton btnEliminarC;
    private JButton btnBuscarC;
    private JButton btnListarC;
    private JButton btnLeerComboC;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JLabel lblComboBox;
    private JComboBox cboClientes;
    private JButton btnNombre;
    private JButton btnLimpiar;
    private JTextField txtDNI;
    private JLabel lblDNI;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;


    public frmCliente() {
        //
        setTitle("Registro de Clientes");
        setContentPane(this.jpaPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        ImageIcon imagen = new ImageIcon("src/Recursos/Imagenes/PersonaCE/iconoVentanaCliente32x32.png");
        setIconImage(imagen.getImage());
        //
        iniciar();
        btnRegistrarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        Cliente cliente = new Cliente();
                        obtenerInfoPersona(cliente);
                        cliente.setCodigo(Integer.parseInt(txtCodigoC.getText()));
                        cliente.setCategoria(String.valueOf(cboCategoriaC.getSelectedItem()));
                        cliente.setFechaIngreso(convertirTextoFecha(txtFechaIngreso.getText()));
                        cliente.setSaldo(Double.parseDouble(txtSaldoC.getText()));
                        cliente.setCorreoElectronico(txtCorreoElectronicoC.getText());
                        cliente.setOcupacion(txtOcupacionC.getText());
                        cliente.setTipoMembresia(String.valueOf(cboTipoMembresia.getSelectedItem()));
                        String respuesta = new ClienteNegocio().Insertar(cliente);
                        if(!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                            llenarCBOclientes();
                        }else{
                            throw new Exception(respuesta);
                        }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        txtFechaIngreso.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c>= '0') && (c<='9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))){
                    JOptionPane.showMessageDialog(null,"Porfavor Ingrese una fecha correcta");
                    e.consume();
                }
            }
        });
        btnActualizarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        Cliente cliente = new Cliente();
                        obtenerInfoPersona(cliente);
                        cliente.setCodigo(Integer.parseInt(txtCodigoC.getText()));
                        cliente.setCategoria(String.valueOf(cboCategoriaC.getSelectedItem()));
                        cliente.setFechaIngreso(convertirTextoFecha(txtFechaIngreso.getText()));
                        cliente.setSaldo(Double.parseDouble(txtSaldoC.getText()));
                        cliente.setCorreoElectronico(txtCorreoElectronicoC.getText());
                        cliente.setOcupacion(txtOcupacionC.getText());
                        cliente.setTipoMembresia(String.valueOf(cboTipoMembresia.getSelectedItem()));
                        String respuesta = new ClienteNegocio().Actualizar(cliente);
                        if(!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Actualizado","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                            llenarCBOclientes();
                        }else{
                            throw new Exception(respuesta);
                        }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int confirmar = JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar el registro?",
                            "Eliminar Precaucion",JOptionPane.WARNING_MESSAGE);
                    if(confirmar == JOptionPane.YES_OPTION){
                        Cliente cliente = new Cliente();
                        cliente.setDNI(Long.parseLong(txtDNI.getText()));
                        cliente.setCodigo(Integer.parseInt(txtCodigoC.getText()));
                        cliente.setCategoria(String.valueOf(cboCategoriaC.getSelectedItem()));
                        cliente.setFechaIngreso(convertirTextoFecha(txtFechaIngreso.getText()));
                        cliente.setSaldo(Double.parseDouble(txtSaldoC.getText()));
                        cliente.setCorreoElectronico(txtCorreoElectronicoC.getText());
                        cliente.setOcupacion(txtOcupacionC.getText());
                        cliente.setTipoMembresia(String.valueOf(cboTipoMembresia.getSelectedItem()));
                        new ClienteNegocio().Eliminar(cliente);
                        limpiar();
                        leerDatos();
                        llenarCBOclientes();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int filaSeleccionada = tblDatos.getSelectedRow();
                    txtDNI.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                    txtCodigoC.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                    cboCategoriaC.setSelectedItem(modelo.getValueAt(filaSeleccionada,2).toString());
                    txtFechaIngreso.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                    txtSaldoC.setText(modelo.getValueAt(filaSeleccionada,4).toString());
                    txtCorreoElectronicoC.setText(modelo.getValueAt(filaSeleccionada,5).toString());
                    txtOcupacionC.setText(modelo.getValueAt(filaSeleccionada,6).toString());
                    cboTipoMembresia.setSelectedItem(modelo.getValueAt(filaSeleccionada,7).toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cliente cliente = new Cliente();
                    cliente.setCorreoElectronico(txtCorreoElectronicoC.getText());
                    List<Cliente> listaCliente = new ClienteNegocio().Buscar(cliente);
                    modelo.setRowCount(0);
                    for (Cliente item: listaCliente) {
                        Object [] registro ={
                                item.getDNI(),
                                item.getCodigo(),
                                item.getCategoria(),
                                sdf.format(item.getFechaIngreso()),
                                item.getSaldo(),
                                item.getCorreoElectronico(),
                                item.getOcupacion(),
                                item.getTipoMembresia()
                        };
                        modelo.addRow(registro);
                    }
                    tblDatos.setModel(modelo);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        btnLeerComboC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Object obj=cboClientes.getSelectedItem();
                    long item=((Item)obj).getID();
                    JOptionPane.showMessageDialog(null,"DNI: " + item);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
        cboDNICP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = cboDNICP.getSelectedItem();
                long item = ((Item)obj).getID();
                txtDNI.setText(String.valueOf(item));
            }
        });
    }

    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Codigo");
        modelo.addColumn("Categoria");
        modelo.addColumn("Fecha de Ingreso");
        modelo.addColumn("Saldo");
        modelo.addColumn("Correo Electronico");
        modelo.addColumn("Ocupacion");
        modelo.addColumn("Tipo de Membresia");
        limpiar();
        leerDatos();
        llenarDNI();
        llenarCBOclientes();
    }
    public void limpiar(){
        txtCodigoC.setText("0");
        txtFechaIngreso.setText("00/00/0000");
        txtOcupacionC.setText("");
        txtSaldoC.setText("0.0");
        txtCorreoElectronicoC.setText("");
        txtDNI.setText("0");
    }

    private void leerDatos() {
        try {
            List<Cliente> listaCliente = new ClienteNegocio().Leer();
            modelo.setRowCount(0);
            for (Cliente item : listaCliente) {
                Object[] registro = {
                        item.getDNI(),
                        item.getCodigo(),
                        item.getCategoria(),
                        sdf.format(item.getFechaIngreso()),
                        item.getSaldo(),
                        item.getCorreoElectronico(),
                        item.getOcupacion(),
                        item.getTipoMembresia()
                };
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void llenarDNI() {
        try {
            List<Persona> listaPersona = new PersonaNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Persona persona : listaPersona) {
                Item item = new Item(persona.getDNI(), persona.getNombre());
                modeloCombo.addElement(item);
            }
            cboDNICP.setModel(modeloCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void llenarCBOclientes() {
        try{
            List<Cliente> listaCliente = new ClienteNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Cliente cliente:listaCliente){
                Item item = new Item(cliente.getDNI(),cliente.getCorreoElectronico());
                modeloCombo.addElement(item);
            }
            cboClientes.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void obtenerInfoPersona(Cliente pcliente){
        try{
            List<Persona> listaPersona = new PersonaNegocio().Leer();
            long dni = Long.parseLong(txtDNI.getText());
            for (Persona item: listaPersona) {
                if(dni == item.getDNI()){
                    pcliente.setDNI(item.getDNI());
                    pcliente.setNombre(item.getNombre());
                    pcliente.setApellido(item.getApellido());
                    pcliente.setEdad(item.getEdad());
                    pcliente.setDireccion(item.getDireccion());
                    pcliente.setGenero(item.getGenero());
                    pcliente.setTelefono(item.getTelefono());
                }
            }
        }catch(Exception e){
            e.printStackTrace() ;
        }
    }

    public Date convertirTextoFecha(String t){
        Date fecha = null;
        try{
            fecha = sdf.parse(t);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        return fecha;
    }
}
