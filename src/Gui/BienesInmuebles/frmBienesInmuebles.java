package Gui.BienesInmuebles;

import Negocio.BienesInmuebles.BienesInmueblesNegocio;
import Recursos.Clases.BienesInmuebles;
import Recursos.Clases.ItemCE;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmBienesInmuebles extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JLabel lblImagen2;
    private JPanel jpaContenido;
    private JLabel lblIDBI;
    private JLabel lblPrecioVentaBI;
    private JLabel lblPrecioRentaBI;
    private JLabel lblDireccionBI;
    private JTextField txtIdentificadorBI;
    private JTextField txtPrecioRentaBI;
    private JTextField txtPrecioVentaBi;
    private JTextField txtDireccionBI;
    private JLabel lblBienesInmuebles;
    private JComboBox cboBienesInmuebles;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JPanel jpaBotones;
    private JButton btnRegistrarBI;
    private JButton btnActualizarBI;
    private JButton btnEliminarBI;
    private JButton btnBuscarBI;
    private JButton btnListarBI;
    private JButton btnLeerComboBI;
    private JTextField txtDescripcionBI;
    private JLabel lblDescripcion;
    private JButton btnLimpiar;
    DefaultTableModel modelo;

    public frmBienesInmuebles() {
        //
        setTitle("Registro de Bienes Inmuebles");
        setContentPane(this.jpaPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        ImageIcon imagen = new ImageIcon("src/Recursos/Imagenes/BienesInmueblesTC/iconoRegistrar32x32.png");
        setIconImage(imagen.getImage());
        //
        iniciar();
        btnRegistrarBI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BienesInmuebles inmueble = new BienesInmuebles();
                    inmueble.setID(Integer.parseInt(txtIdentificadorBI.getText()));
                    inmueble.setPrecioVenta(Double.parseDouble(txtPrecioVentaBi.getText()));
                    inmueble.setPrecioRenta(Double.parseDouble(txtPrecioRentaBI.getText()));
                    inmueble.setDescripcion(txtDescripcionBI.getText());
                    inmueble.setDireccion(txtDireccionBI.getText());
                    String respuesta = new BienesInmueblesNegocio().Insertar(inmueble);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                       llenarCBoinmuebles();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizarBI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BienesInmuebles inmueble = new BienesInmuebles();
                    inmueble.setID(Integer.parseInt(txtIdentificadorBI.getText()));
                    inmueble.setPrecioVenta(Double.parseDouble(txtPrecioVentaBi.getText()));
                    inmueble.setPrecioRenta(Double.parseDouble(txtPrecioRentaBI.getText()));
                    inmueble.setDescripcion(txtDescripcionBI.getText());
                    inmueble.setDireccion(txtDireccionBI.getText());
                    String respuesta = new BienesInmueblesNegocio().Actualizar(inmueble);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Actualizado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarCBoinmuebles();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnEliminarBI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int confirmar = JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar el registro?",
                            "Eliminar Precaucion",JOptionPane.WARNING_MESSAGE);
                    if(confirmar == JOptionPane.YES_OPTION){
                        BienesInmuebles inmueble = new BienesInmuebles();
                        inmueble.setID(Integer.parseInt(txtIdentificadorBI.getText()));
                        inmueble.setPrecioVenta(Double.parseDouble(txtPrecioVentaBi.getText()));
                        inmueble.setPrecioRenta(Double.parseDouble(txtPrecioRentaBI.getText()));
                        inmueble.setDescripcion(txtDescripcionBI.getText());
                        inmueble.setDireccion(txtDireccionBI.getText());
                        new BienesInmueblesNegocio().Eliminar(inmueble);
                        limpiar();
                        leerDatos();
                        llenarCBoinmuebles();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada =tblDatos.getSelectedRow();
                txtIdentificadorBI.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                txtPrecioVentaBi.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                txtPrecioRentaBI.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtDescripcionBI.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                txtDireccionBI.setText(modelo.getValueAt(filaSeleccionada,4).toString());
            }
        });
        btnBuscarBI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BienesInmuebles inmuebles = new BienesInmuebles();
                    inmuebles.setDescripcion(txtDescripcionBI.getText());
                    List<BienesInmuebles> listaInmuebles = new BienesInmueblesNegocio().Buscar(inmuebles);
                    modelo.setRowCount(0);
                    for (BienesInmuebles item: listaInmuebles) {
                        Object [] registro ={
                                item.getID(),
                                item.getPrecioVenta(),
                                item.getPrecioRenta(),
                                item.getDescripcion(),
                                item.getDireccion()
                        };
                        modelo.addRow(registro);
                    }
                    tblDatos.setModel(modelo);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListarBI.addActionListener(new ActionListener() {
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
        btnLeerComboBI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = cboBienesInmuebles.getSelectedItem();
                //String itemInmueble = ((Item)obj).getNombre();
                String itemInmueble = ((ItemCE)obj).getNombre();
                JOptionPane.showMessageDialog(null,"Descripcion: " + itemInmueble);
            }
        });
    }
    private void iniciar(){
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("ID");
        modelo.addColumn("Precio de Venta");
        modelo.addColumn("Precio de Renta");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Direccion");
        limpiar();
        leerDatos();
        llenarCBoinmuebles();
    }
    public void limpiar(){
        txtDireccionBI.setText("");
        txtIdentificadorBI.setText("0");
        txtPrecioRentaBI.setText("0.0");
        txtPrecioVentaBi.setText("0.0");
        txtDescripcionBI.setText("");
    }
    private void llenarCBoinmuebles(){
        try{
            List<BienesInmuebles> listaInmuebles = new BienesInmueblesNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (BienesInmuebles inmueble: listaInmuebles) {
                ItemCE item =new ItemCE(inmueble.getID(), inmueble.getDescripcion());
                modeloCombo.addElement(item);
            }
            cboBienesInmuebles.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void leerDatos(){
        try{
            List<BienesInmuebles> listaInmuebles = new BienesInmueblesNegocio().Leer();
            modelo.setRowCount(0);
            for (BienesInmuebles inmueble: listaInmuebles) {
                Object [] registro={
                        inmueble.getID(),
                        inmueble.getPrecioVenta(),
                        inmueble.getPrecioRenta(),
                        inmueble.getDescripcion(),
                        inmueble.getDireccion()
                };
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
