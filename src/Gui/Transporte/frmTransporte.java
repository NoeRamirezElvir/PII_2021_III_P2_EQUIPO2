package Gui.Transporte;


import Negocio.BienesMuebles.BienesMueblesNegocio;
import Negocio.Transporte.TransporteNegocio;
import Recursos.Clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmTransporte extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JPanel jpaContain;
    private JPanel jpaBotones;
    private JPanel jpaDatos;
    private JScrollPane sclPDatos;
    private JTable tblDatos;
    private JLabel lblTitulo;
    private JLabel lblId;
    private JComboBox cboID;
    private JLabel lblDescripcion;
    private JTextField txtDescripcion;
    private JLabel lblMarca;
    private JTextField txtMarca;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblModelo;
    private JTextField txtModelo;
    private JLabel lblCapacidad;
    private JTextField txtCapacidad;
    private JLabel lblNoEjes;
    private JTextField txtNoEjes;
    private JLabel lblCaballosFuerza;
    private JLabel lblLugarF;
    private JComboBox cboTipo;
    private JComboBox cboVoltaje;
    private JButton btnRegistrar;
    private JButton btnListar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnLeerCombo;
    private JButton btnLimpiar;
    private JComboBox cboTransporte;
    private JLabel lblElectrodomesticos;
    private JTextField txtCaballosFuerza;
    private JTextField txtLugarF;
    DefaultTableModel modelo = new DefaultTableModel();

    public frmTransporte() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Transporte electrodomestico = new Transporte();
                    electrodomestico.setID(Integer.parseInt(cboID.getSelectedItem().toString()));
                    electrodomestico.setNombre(txtNombre.getText());
                    electrodomestico.setMarca(txtMarca.getText());
                    electrodomestico.setModelo(txtModelo.getText());
                    electrodomestico.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
                    electrodomestico.setNoEjes(Integer.parseInt(txtNoEjes.getText()));
                    electrodomestico.setCaballosFuerza(Integer.parseInt(txtCaballosFuerza.getText()));
                    electrodomestico.setLugarFabricacion(txtLugarF.getText());
                    String respuesta = new TransporteNegocio().Insertar(electrodomestico);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, respuesta.toString(), "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboBox();
                    } else {
                        throw new Exception(respuesta);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cboID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Object obj = cboID.getSelectedItem();
                    String item= ((ItemCE)obj).getNombre();
                    txtDescripcion.setText(String.valueOf(item));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Transporte electrodomestico = new Transporte();
                    electrodomestico.setID(Integer.parseInt(cboID.getSelectedItem().toString()));
                    electrodomestico.setNombre(txtNombre.getText());
                    electrodomestico.setMarca(txtMarca.getText());
                    electrodomestico.setModelo(txtModelo.getText());
                    electrodomestico.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
                    electrodomestico.setNoEjes(Integer.parseInt(txtNoEjes.getText()));
                    electrodomestico.setCaballosFuerza(Integer.parseInt(txtCaballosFuerza.getText()));
                    electrodomestico.setLugarFabricacion(txtLugarF.getText());
                    String respuesta = new TransporteNegocio().Actualizar(electrodomestico);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, respuesta.toString(), "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboBox();
                    } else {
                        throw new Exception(respuesta);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int confirmacion = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea Eliminar este Electrodomestico?", "Confirmacion", JOptionPane.WARNING_MESSAGE);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        Transporte electrodomestico = new Transporte();
                        electrodomestico.setID(Integer.parseInt(cboID.getSelectedItem().toString()));
                        electrodomestico.setNombre(txtNombre.getText());
                        electrodomestico.setMarca(txtMarca.getText());
                        electrodomestico.setModelo(txtModelo.getText());
                        electrodomestico.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
                        electrodomestico.setNoEjes(Integer.parseInt(txtNoEjes.getText()));
                        electrodomestico.setCaballosFuerza(Integer.parseInt(txtCaballosFuerza.getText()));
                        electrodomestico.setLugarFabricacion(txtLugarF.getText());
                        String respuesta = new TransporteNegocio().Eliminar(electrodomestico);
                        if (!respuesta.contains("Error")) {
                            JOptionPane.showMessageDialog(null, respuesta, "Exito", JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                            llenarComboBox();
                        } else {
                            throw new Exception(respuesta);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Transporte electrodomestico = new Transporte();
                    electrodomestico.setNombre(txtNombre.getText());
                    List<Transporte> electrodomesticosList = new TransporteNegocio().Buscar(electrodomestico);
                    modelo.setRowCount(0);//recuento de filas
                    for (Transporte it : electrodomesticosList) {
                        Object[] registroLeido = {it.getID()
                                ,it.getNombre()
                                ,it.getMarca()
                                ,it.getModelo()
                                ,it.getCapacidad()
                                ,it.getNoEjes()
                                ,it.getCaballosFuerza()
                                ,it.getLugarFabricacion()};
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboTransporte.getSelectedItem();
                long itemBienMueble = ((Item)objeto).getID();
                JOptionPane.showMessageDialog(null,itemBienMueble);
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    int filaSeleccionada = tblDatos.getSelectedRow();
                    cboID.setSelectedItem((modelo.getValueAt(filaSeleccionada,0).toString()));
                    txtNombre.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                    txtMarca.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                    txtModelo.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                    txtCapacidad.setText(modelo.getValueAt(filaSeleccionada,4).toString());
                    txtNoEjes.setText(modelo.getValueAt(filaSeleccionada,5).toString());
                    txtCaballosFuerza.setText(modelo.getValueAt(filaSeleccionada,6).toString());
                    txtLugarF.setText(modelo.getValueAt(filaSeleccionada,7).toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void llenarComboBox() {
        try{
            List<Transporte> electrodomesticosList = new TransporteNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Transporte it: electrodomesticosList) {
                Item item = new Item((it.getID()), it.getNombre());
                modeloCombo.addElement(item);
            }
            cboTransporte.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void limpiar() {
        txtDescripcion.setText("");
        txtMarca.setText("");
        txtCapacidad.setText("");
        txtModelo.setText("");
        txtNombre.setText("");
        txtNoEjes.setText("");
        txtCaballosFuerza.setText("");
        txtLugarF.setText("");
    }
    private void Iniciar() {
        setTitle("Transportes");
        setContentPane(this.jpaPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Capacidad");
        modelo.addColumn("No. de Ejes");
        modelo.addColumn("Caballos de Fuerza (HP)");
        modelo.addColumn("Lugar de Fabricación");
        leerDatos();
        llenarCboID();
        llenarComboBox();
    }
    private void llenarCboID() {
        try{
            List<BienesMuebles> mueblesList = new BienesMueblesNegocio().Leer();
            DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
            for (BienesMuebles it: mueblesList) {
                ItemCE objeto = new ItemCE(it.getID(),it.getDescripcion());
                boxModel.addElement(objeto);
            }
            cboID.setModel(boxModel);
        }catch (Exception e){
        }
    }
    private void leerDatos() {
        try {
            List<Transporte> electrodomesticosList = new TransporteNegocio().Leer();
            modelo.setRowCount(0);
            for (Transporte it: electrodomesticosList) {
                Object[] registroLeido = {it.getID(),
                        it.getNombre()
                        ,it.getMarca()
                        ,it.getModelo()
                        ,it.getCapacidad()
                        ,it.getNoEjes()
                        ,it.getCaballosFuerza()
                        ,it.getLugarFabricacion()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){
        }
    }
    public Transporte obtenerInfoMueble(Transporte electrodomestico) {
        try{
            List<BienesMuebles> listaMuebles = new BienesMueblesNegocio().Leer();
            int id=Integer.parseInt(txtDescripcion.getText());
            for (BienesMuebles item: listaMuebles) {
                if(id == item.getID()){
                    electrodomestico.setID(item.getID());
                    electrodomestico.setPrecio(item.getPrecio());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return electrodomestico;
    }
}
