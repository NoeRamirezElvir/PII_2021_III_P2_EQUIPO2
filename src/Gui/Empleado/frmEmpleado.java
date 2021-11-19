package Gui.Empleado;

import Datos.Empleado.EmpleadoDatos;
import Negocio.Empleado.EmpleadoNegocio;
import Negocio.Persona.PersonaNegocio;
import Recursos.Clases.Empleado;
import Recursos.Clases.Item;
import Recursos.Clases.ItemCE;
import Recursos.Clases.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmEmpleado extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JLabel lblImagen;
    private JPanel jpaContenido;
    private JLabel lblNombre;
    private JLabel lblFechaIngresoE;
    private JLabel lblCargoE;
    private JLabel lblSueldo;
    private JLabel lblDiasTrabajoE;
    private JLabel lblCorreoElectronicoE;
    private JLabel lblDepartamentoE;
    private JLabel lblCodigoE;
    private JLabel lblEmpleados;
    private JComboBox cboDNICE;
    private JTextField txtCodigoE;
    private JTextField txtFechaIngresoE;
    private JTextField txtCargoE;
    private JTextField txtSueldo;
    private JComboBox cboHorarioE;
    private JTextField txtCorreoElectronicoE;
    private JComboBox cboDepartamentoE;
    private JComboBox cboEmpleadosE;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JPanel fpaBotones;
    private JButton btnRegistrarE;
    private JButton btnActualizarE;
    private JButton btnEliminarE;
    private JButton btnBuscarE;
    private JButton btnListarE;
    private JButton btnLeerComboE;
    private JButton btnLimpiar;
    private JLabel lblDNI;
    private JTextField txtDNI;
    private JButton btnNombre;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmEmpleado() {
        //
        setTitle("Registro de Empleados");
        setContentPane(this.jpaPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        ImageIcon imagen = new ImageIcon("src/Recursos/Imagenes/PersonaCE/iconoVentanaEmpleado.png");
        setIconImage(imagen.getImage());
        //
        iniciar();
        btnRegistrarE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Empleado empleado = new Empleado();
                    obtenerInfoPersona(empleado);
                    empleado.setCodigo(Integer.parseInt(txtCodigoE.getText()));
                    empleado.setCargo(txtCargoE.getText());
                    empleado.setFechaIngreso(convertirTextoFecha(txtFechaIngresoE.getText()));
                    empleado.setSueldo(Double.parseDouble(txtSueldo.getText()));
                    empleado.setHorario(String.valueOf(cboHorarioE.getSelectedItem()));
                    empleado.setCorreoElectronico(txtCorreoElectronicoE.getText());
                    empleado.setDepartamento(String.valueOf(cboDepartamentoE.getSelectedItem()));
                    String respuesta = new EmpleadoNegocio().Insertar(empleado);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarCBOempleados();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage() ,"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        txtFechaIngresoE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c>= '0') && (c<='9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))){
                    JOptionPane.showMessageDialog(null,"Porfavor Ingrese una fecha correcta");
                    e.consume();
                }
            }
        });
        btnActualizarE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Empleado empleado = new Empleado();
                    obtenerInfoPersona(empleado);
                    empleado.setCodigo(Integer.parseInt(txtCodigoE.getText()));
                    empleado.setCargo(txtCargoE.getText());
                    empleado.setFechaIngreso(convertirTextoFecha(txtFechaIngresoE.getText()));
                    empleado.setSueldo(Double.parseDouble(txtSueldo.getText()));
                    empleado.setHorario(String.valueOf(cboHorarioE.getSelectedItem()));
                    empleado.setCorreoElectronico(txtCorreoElectronicoE.getText());
                    empleado.setDepartamento(String.valueOf(cboDepartamentoE.getSelectedItem()));
                    String respuesta = new EmpleadoNegocio().Actualizar(empleado);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Actualizado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarCBOempleados();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage() ,"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    int filaSeleccionada = tblDatos.getSelectedRow();
                    txtDNI.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                    txtCodigoE.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                    txtFechaIngresoE.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                    txtCargoE.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                    txtSueldo.setText(modelo.getValueAt(filaSeleccionada,4).toString());
                    cboHorarioE.setSelectedItem(modelo.getValueAt(filaSeleccionada,5).toString());
                    txtCorreoElectronicoE.setText(modelo.getValueAt(filaSeleccionada,6).toString());
                    cboDepartamentoE.setSelectedItem(modelo.getValueAt(filaSeleccionada,7).toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage() ,"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminarE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int confirmar = JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar el registro?",
                            "Eliminar Precaucion",JOptionPane.WARNING_MESSAGE);
                    if(confirmar == JOptionPane.YES_OPTION){
                        Empleado empleado = new Empleado();
                        empleado.setDNI(Long.parseLong(txtDNI.getText()));
                        empleado.setCodigo(Integer.parseInt(txtCodigoE.getText()));
                        empleado.setCargo(txtCargoE.getText());
                        empleado.setFechaIngreso(convertirTextoFecha(txtFechaIngresoE.getText()));
                        empleado.setSueldo(Double.parseDouble(txtSueldo.getText()));
                        empleado.setHorario(String.valueOf(cboHorarioE.getSelectedItem()));
                        empleado.setCorreoElectronico(txtCorreoElectronicoE.getText());
                        empleado.setDepartamento(String.valueOf(cboDepartamentoE.getSelectedItem()));
                        new EmpleadoNegocio().Eliminar(empleado);
                        limpiar();
                        leerDatos();
                        llenarCBOempleados();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscarE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Empleado empleado = new Empleado();
                    empleado.setCorreoElectronico(txtCorreoElectronicoE.getText());
                    List<Empleado> listaEmpleado=new EmpleadoNegocio().Buscar(empleado);
                    modelo.setRowCount(0);
                    for(Empleado item:listaEmpleado){
                        Object [] registro ={
                                item.getDNI(),
                                item.getCodigo(),
                                sdf.format(item.getFechaIngreso()),
                                item.getCargo(),
                                item.getSueldo(),
                                item.getHorario(),
                                item.getCorreoElectronico(),
                                item.getDepartamento()
                        };
                        modelo.addRow(registro);
                    }
                    tblDatos.setModel(modelo);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListarE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        btnLeerComboE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Object obj= cboEmpleadosE.getSelectedItem();
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
        cboDNICE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = cboDNICE.getSelectedItem();
                long item = ((Item)obj).getID();
                txtDNI.setText(String.valueOf(item));
            }
        });
    }
    private void iniciar(){
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Codigo");
        modelo.addColumn("Fecha de Ingreso");
        modelo.addColumn("Cargo");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Horario");
        modelo.addColumn("Correo Electronico");
        modelo.addColumn("Departamento");
        limpiar();
        leerDatos();
        llenarDNI();
        llenarCBOempleados();
    }
    public void limpiar(){
        txtCargoE.setText("");
        txtCodigoE.setText("0");
        txtSueldo.setText("0.0");
        txtCorreoElectronicoE.setText("");
        txtFechaIngresoE.setText("00/00/0000");
        txtDNI.setText("0");
    }
    private void leerDatos(){
        try{
            List<Empleado> listaEmpleado = new EmpleadoNegocio().Leer();
            modelo.setRowCount(0);
            for (Empleado item:listaEmpleado) {
                Object [] registro = {
                        item.getDNI(),
                        item.getCodigo(),
                        sdf.format(item.getFechaIngreso()),
                        item.getCargo(),
                        item.getSueldo(),
                        item.getHorario(),
                        item.getCorreoElectronico(),
                        item.getDepartamento()
                };
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void llenarDNI(){
        try{
            List<Persona> listaPersona = new PersonaNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Persona persona: listaPersona) {
                Item item = new Item(persona.getDNI(), persona.getNombre());
                modeloCombo.addElement(item);
            }
            cboDNICE.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void llenarCBOempleados(){
        try{
            List<Empleado> listaEmpleado = new EmpleadoNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Empleado empleado: listaEmpleado) {
                Item item=new Item(empleado.getDNI(), empleado.getCorreoElectronico());
                modeloCombo.addElement(item);
            }
            cboEmpleadosE.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void obtenerInfoPersona(Empleado empleado){
        try{
            List<Persona> listaPersona = new PersonaNegocio().Leer();
            long dni = Long.parseLong(txtDNI.getText());
            for (Persona item: listaPersona) {
                if(dni == item.getDNI()){
                    empleado.setDNI(item.getDNI());
                    empleado.setNombre(item.getNombre());
                    empleado.setApellido(item.getApellido());
                    empleado.setEdad(item.getEdad());
                    empleado.setDireccion(item.getDireccion());
                    empleado.setGenero(item.getGenero());
                    empleado.setTelefono(item.getTelefono());
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
