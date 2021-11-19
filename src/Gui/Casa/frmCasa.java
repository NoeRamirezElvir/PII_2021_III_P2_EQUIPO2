package Gui.Casa;

import Negocio.BienesInmuebles.BienesInmueblesNegocio;
import Negocio.Casa.CasaNegocio;
import Recursos.Clases.BienesInmuebles;
import Recursos.Clases.Casa;
import Recursos.Clases.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmCasa extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JLabel lblImagen;
    private JPanel jpaContenido;
    private JLabel lblIDescripcion;
    private JLabel lblNumHabitacionesC;
    private JLabel lblNumPisosC;
    private JLabel lblServiciosBasicosC;
    private JLabel lblColorC;
    private JLabel lblMaterialC;
    private JLabel lblPropietarioC;
    private JLabel lblTipo;
    private JComboBox cboDescripcion;
    private JTextField txtNumeroHabitacionesC;
    private JTextField txtNumeroPisosC;
    private JComboBox cboServiciosBasicosC;
    private JTextField txtColorC;
    private JTextField txtMaterialC;
    private JTextField txtPropietarioC;
    private JPanel jpaBotones;
    private JButton btnRegistrarC;
    private JButton btnLeerComboC;
    private JButton btnActualizarC;
    private JButton btnEliminarC;
    private JButton btnBuscarC;
    private JButton btnListarC;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JComboBox cboTipo;
    private JComboBox cboViviendas;
    private JLabel lblViviendas;
    private JTextField txtID;
    private JLabel lblID;
    private JButton btnLimpiar;
    DefaultTableModel modelo;

    public frmCasa() {
        //
        setTitle("Registro de Casas");
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
                    Casa casa = new Casa();
                    obtenerInfoInmueble(casa);
                    casa.setNumeroHabitaciones(Integer.parseInt(txtNumeroHabitacionesC.getText()));
                    casa.setNumeroPlantas(Integer.parseInt(txtNumeroPisosC.getText()));
                    casa.setServiciosBasicos(String.valueOf(cboServiciosBasicosC.getSelectedItem()));
                    casa.setColor(txtColorC.getText());
                    casa.setMaterial(txtMaterialC.getText());
                    casa.setPropietario(txtPropietarioC.getText());
                    casa.setTipo(String.valueOf(cboTipo.getSelectedItem()));
                    String respuesta=new CasaNegocio().Insertar(casa);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarCBOViviendas();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Casa casa = new Casa();
                    obtenerInfoInmueble(casa);
                    casa.setNumeroHabitaciones(Integer.parseInt(txtNumeroHabitacionesC.getText()));
                    casa.setNumeroPlantas(Integer.parseInt(txtNumeroPisosC.getText()));
                    casa.setServiciosBasicos(String.valueOf(cboServiciosBasicosC.getSelectedItem()));
                    casa.setColor(txtColorC.getText());
                    casa.setMaterial(txtMaterialC.getText());
                    casa.setPropietario(txtPropietarioC.getText());
                    casa.setTipo(String.valueOf(cboTipo.getSelectedItem()));
                    String respuesta=new CasaNegocio().Actualizar(casa);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Actualizado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarCBOViviendas();
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
                    if(confirmar == JOptionPane.YES_OPTION) {
                        Casa casa= new Casa();
                        casa.setID(Integer.parseInt(txtID.getText()));
                        casa.setNumeroHabitaciones(Integer.parseInt(txtNumeroHabitacionesC.getText()));
                        casa.setNumeroPlantas(Integer.parseInt(txtNumeroPisosC.getText()));
                        casa.setServiciosBasicos(String.valueOf(cboServiciosBasicosC.getSelectedItem()));
                        casa.setColor(txtColorC.getText());
                        casa.setMaterial(txtMaterialC.getText());
                        casa.setPropietario(txtPropietarioC.getText());
                        casa.setTipo(String.valueOf(cboTipo.getSelectedItem()));
                        new CasaNegocio().Eliminar(casa);
                        limpiar();
                        leerDatos();
                        llenarCBOViviendas();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    int filaSeleccionada = tblDatos.getSelectedRow();
                    txtID.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                    txtNumeroHabitacionesC.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                    txtNumeroPisosC.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                    cboServiciosBasicosC.setSelectedItem(modelo.getValueAt(filaSeleccionada,3).toString());
                    txtColorC.setText(modelo.getValueAt(filaSeleccionada,4).toString());
                    txtMaterialC.setText(modelo.getValueAt(filaSeleccionada,5).toString());
                    txtPropietarioC.setText(modelo.getValueAt(filaSeleccionada,6).toString());
                    cboTipo.setSelectedItem(modelo.getValueAt(filaSeleccionada,7).toString());


                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Casa casa = new Casa();
                    casa.setPropietario(txtPropietarioC.getText());
                    List<Casa> listaCasa = new CasaNegocio().Buscar(casa);
                    modelo.setRowCount(0);
                    for (Casa item: listaCasa) {
                        Object [] registro={
                                item.getID(),
                                item.getNumeroHabitaciones(),
                                item.getNumeroPlantas(),
                                item.getServiciosBasicos(),
                                item.getColor(),
                                item.getMaterial(),
                                item.getPropietario(),
                                item.getTipo()
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
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
        cboDescripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Object obj = cboDescripcion.getSelectedItem();
                    long item= ((Item)obj).getID();
                    txtID.setText(String.valueOf(item));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLeerComboC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Object obj =cboViviendas.getSelectedItem();
                    long item=((Item)obj).getID();
                    JOptionPane.showMessageDialog(null,"ID: " + item);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void iniciar(){
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("ID");
        modelo.addColumn("No. Habitaciones");
        modelo.addColumn("No. Pisos");
        modelo.addColumn("Servicios Basicos");
        modelo.addColumn("Color");
        modelo.addColumn("Material");
        modelo.addColumn("Propietario");
        modelo.addColumn("Tipo");
        limpiar();
        leerDatos();
        llenarID();
        llenarCBOViviendas();
    }
    public void limpiar(){
        txtNumeroHabitacionesC.setText("0");
        txtNumeroPisosC.setText("0");
        txtColorC.setText("");
        txtMaterialC.setText("");
        txtPropietarioC.setText("");
        txtID.setText("0");
    }
    public void leerDatos(){
        try{
            List<Casa> listaCasas = new CasaNegocio().Leer();
            modelo.setRowCount(0);
            for (Casa item: listaCasas) {
                Object [] registro={
                        item.getID(),
                        item.getNumeroHabitaciones(),
                        item.getNumeroPlantas(),
                        item.getServiciosBasicos(),
                        item.getColor(),
                        item.getMaterial(),
                        item.getPropietario(),
                        item.getTipo()
                };
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);
        }catch(Exception e){
            e.getMessage();
        }
    }
    public void llenarID(){
        try{
            List<BienesInmuebles> listaInmuebles= new BienesInmueblesNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (BienesInmuebles inmueble: listaInmuebles){
                Item item = new Item(inmueble.getID(),inmueble.getDescripcion());
                modeloCombo.addElement(item);
            }
            cboDescripcion.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void llenarCBOViviendas(){
        try{
            List<Casa> listaCasa = new CasaNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Casa casa: listaCasa) {
                Item item = new Item(casa.getID(),casa.getTipo());
                modeloCombo.addElement(item);
            }
            cboViviendas.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void obtenerInfoInmueble(Casa casa){
        try{
            List<BienesInmuebles> listaInmuebles = new BienesInmueblesNegocio().Leer();
            int id=Integer.parseInt(txtID.getText());
            for (BienesInmuebles item: listaInmuebles) {
                if(id == item.getID()){
                    casa.setID(item.getID());
                    casa.setPrecioVenta(item.getPrecioVenta());
                    casa.setPrecioRenta(item.getPrecioRenta());
                    casa.setDescripcion(item.getDescripcion());
                    casa.setDireccion(item.getDireccion());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
