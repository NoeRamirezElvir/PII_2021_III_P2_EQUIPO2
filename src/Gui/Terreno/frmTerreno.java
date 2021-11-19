package Gui.Terreno;

import Negocio.BienesInmuebles.BienesInmueblesNegocio;
import Negocio.Terreno.TerrenoNegocio;
import Recursos.Clases.BienesInmuebles;
import Recursos.Clases.Item;
import Recursos.Clases.Terreno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmTerreno extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JLabel lblImagen2;
    private JPanel jpaContenido;
    private JComboBox cboDescripcion;
    private JTextField txtDimension;
    private JLabel lblIUbicacion;
    private JLabel lblDimensionT;
    private JLabel lblTipoSueloT;
    private JLabel lblOrientacionT;
    private JTextField txtOrientacionTerreno;
    private JComboBox cboTipoServicios;
    private JComboBox cboCategoria;
    private JTextField txtAltitud;
    private JTextField txtTipoUso;
    private JLabel lblServiciosBasicosT;
    private JComboBox cboTipoSuelo;
    private JLabel lblCategoriaT;
    private JLabel lblAltitudT;
    private JLabel lblTipoUsoT;
    private JPanel jpaBotones;
    private JButton btnRegistrarT;
    private JButton btnLeerComboT;
    private JButton btnActualizarT;
    private JButton btnEliminarT;
    private JButton btnBuscarT;
    private JButton btnListarT;
    private JPanel jpaImagen;
    private JLabel lblImagen;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JLabel lblID;
    private JTextField txtID;
    private JLabel lblTerrenos;
    private JComboBox cboTerrenos;
    private JButton btnLimpiar;
    DefaultTableModel modelo;

    public frmTerreno() {
        //
        setTitle("Registro de Terreno");
        setContentPane(this.jpaPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        ImageIcon imagen = new ImageIcon("src/Recursos/Imagenes/PersonaCE/iconoRegistrar32x32.png");
        setIconImage(imagen.getImage());
        //
        iniciar();
        btnRegistrarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Terreno terreno = new Terreno();
                    obtenerInfoInmueble(terreno);
                    terreno.setDimension(txtDimension.getText());
                    terreno.setTipoSuelo(String.valueOf(cboTipoSuelo.getSelectedItem()));
                    terreno.setOrientacionTerreno(txtOrientacionTerreno.getText());
                    terreno.setTipoServicios(String.valueOf(cboTipoServicios.getSelectedItem()));
                    terreno.setCategoria(String.valueOf(cboCategoria.getSelectedItem()));
                    terreno.setAltitud(txtAltitud.getText());
                    terreno.setTipoUso(txtTipoUso.getText());
                    String respuesta=new TerrenoNegocio().Insertar(terreno);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarCBOTerrenos();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Terreno terreno = new Terreno();
                    obtenerInfoInmueble(terreno);
                    terreno.setDimension(txtDimension.getText());
                    terreno.setTipoSuelo(String.valueOf(cboTipoSuelo.getSelectedItem()));
                    terreno.setOrientacionTerreno(txtOrientacionTerreno.getText());
                    terreno.setTipoServicios(String.valueOf(cboTipoServicios.getSelectedItem()));
                    terreno.setCategoria(String.valueOf(cboCategoria.getSelectedItem()));
                    terreno.setAltitud(txtAltitud.getText());
                    terreno.setTipoUso(txtTipoUso.getText());
                    String respuesta=new TerrenoNegocio().Actualizar(terreno);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Actualizado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarCBOTerrenos();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int confirmar = JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar el registro?",
                            "Eliminar Precaucion",JOptionPane.WARNING_MESSAGE);
                    if(confirmar == JOptionPane.YES_OPTION) {
                        Terreno terreno = new Terreno();
                        terreno.setID(Integer.parseInt(txtID.getText()));
                        terreno.setDimension(txtDimension.getText());
                        terreno.setTipoSuelo(String.valueOf(cboTipoSuelo.getSelectedItem()));
                        terreno.setOrientacionTerreno(txtOrientacionTerreno.getText());
                        terreno.setTipoServicios(String.valueOf(cboTipoServicios.getSelectedItem()));
                        terreno.setCategoria(String.valueOf(cboCategoria.getSelectedItem()));
                        terreno.setAltitud(txtAltitud.getText());
                        terreno.setTipoUso(txtTipoUso.getText());
                        new TerrenoNegocio().Eliminar(terreno);
                        limpiar();
                        leerDatos();
                        llenarCBOTerrenos();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Terreno terreno = new Terreno();
                    terreno.setTipoSuelo(String.valueOf(cboTipoSuelo.getSelectedItem()));
                    List<Terreno> listaTerreno = new TerrenoNegocio().Buscar(terreno);
                    modelo.setRowCount(0);
                    for (Terreno item: listaTerreno) {
                        Object [] registro ={
                                item.getID(),
                                item.getDimension(),
                                item.getTipoSuelo(),
                                item.getOrientacionTerreno(),
                                item.getTipoServicios(),
                                item.getCategoria(),
                                item.getAltitud(),
                                item.getAltitud(),
                                item.getTipoUso()
                        };
                        modelo.addRow(registro);
                    }
                    tblDatos.setModel(modelo);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();;
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
        btnLeerComboT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Object obj =cboTerrenos.getSelectedItem();
                    long item=((Item)obj).getID();
                    JOptionPane.showMessageDialog(null,"ID: " + item);
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
                    txtDimension.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                    cboTipoSuelo.setSelectedItem(modelo.getValueAt(filaSeleccionada,2).toString());
                    txtOrientacionTerreno.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                    cboTipoServicios.setSelectedItem(modelo.getValueAt(filaSeleccionada,4).toString());
                    cboCategoria.setSelectedItem(modelo.getValueAt(filaSeleccionada,5).toString());
                    txtAltitud.setText(modelo.getValueAt(filaSeleccionada,6).toString());
                    txtTipoUso.setText(modelo.getValueAt(filaSeleccionada,7).toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void iniciar(){
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("ID");
        modelo.addColumn("Dimensiones");
        modelo.addColumn("Tipo de Suelo");
        modelo.addColumn("Orientacion");
        modelo.addColumn("Tipo de Servicios");
        modelo.addColumn("Categoria");
        modelo.addColumn("Altitud");
        modelo.addColumn("Tipo de Uso");
        limpiar();
        leerDatos();
        llenarID();
        llenarCBOTerrenos();
    }
    public void limpiar(){
        txtID.setText("0");
        txtDimension.setText("");
        txtAltitud.setText("");
        txtOrientacionTerreno.setText("");
        txtTipoUso.setText("");
    }
    public void leerDatos(){
       try{
           List<Terreno> listaTerreno = new TerrenoNegocio().Leer();
           modelo.setRowCount(0);
           for (Terreno item: listaTerreno) {
               Object [] registro ={
                       item.getID(),
                       item.getDimension(),
                       item.getTipoSuelo(),
                       item.getOrientacionTerreno(),
                       item.getTipoServicios(),
                       item.getCategoria(),
                       item.getAltitud(),
                       item.getTipoUso()
               };
               modelo.addRow(registro);
           }
           tblDatos.setModel(modelo);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    public void llenarID(){
        try{
            List<BienesInmuebles> listaInmuebles= new BienesInmueblesNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (BienesInmuebles inmueble: listaInmuebles){
                Item item = new Item(inmueble.getID(),inmueble.getDireccion());
                modeloCombo.addElement(item);
            }
            cboDescripcion.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void llenarCBOTerrenos(){
        try{
            List<Terreno> listaTerrenos = new TerrenoNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Terreno terreno: listaTerrenos) {
                Item item = new Item(terreno.getID(),terreno.getDimension());
                modeloCombo.addElement(item);
            }
            cboTerrenos.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void obtenerInfoInmueble(Terreno terreno) {
        try{
            List<BienesInmuebles> listaInmuebles = new BienesInmueblesNegocio().Leer();
            int id=Integer.parseInt(txtID.getText());
            for (BienesInmuebles item: listaInmuebles) {
                if(id == item.getID()){
                    terreno.setID(item.getID());
                    terreno.setPrecioVenta(item.getPrecioVenta());
                    terreno.setPrecioRenta(item.getPrecioRenta());
                    terreno.setDescripcion(item.getDescripcion());
                    terreno.setDireccion(item.getDireccion());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
