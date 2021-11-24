package Gui.Articulos;

import Negocio.Articulos.ArticulosNegocio;
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

public class frmArticulos extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JPanel jpaContain;
    private JPanel jpaBotones;
    private JPanel jpaDatos;
    private JScrollPane sclPaneDatos;
    private JTable tblDatos;
    private JLabel lblTitulo;
    private JButton btnRegistrar;
    private JButton btnListar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnLeerCbo;
    private JButton btnLimpiar;
    private JComboBox cboID;
    private JLabel lblIde;
    private JLabel lblDescrpcion;
    private JTextField txtDescripcion;
    private JLabel lblMaterial;
    private JTextField txtMaterial;
    private JLabel lblCategoria;
    private JTextField txtCategoria;
    private JLabel lblEstilo;
    private JTextField txtEstilo;
    private JLabel lblColor;
    private JTextField txtColor;
    private JLabel lblTmanio;
    private JTextField txtTamanio;
    private JLabel lblMarca;
    private JTextField txtMarca;
    private JLabel lblNoLote;
    private JTextField txtNoLote;
    private JLabel lblArticulo;
    private JComboBox cboArticulo;
    DefaultTableModel modelo = new DefaultTableModel();

    public frmArticulos() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Articulos articulo = new Articulos();
                    articulo.setID(Integer.parseInt(cboID.getSelectedItem().toString()));
                    articulo.setMaterial(txtMaterial.getText());
                    articulo.setCategoria(txtCategoria.getText());
                    articulo.setEstilo(txtEstilo.getText());
                    articulo.setColor(txtColor.getText());
                    articulo.setTamanio(txtTamanio.getText());
                    articulo.setMarca(txtMarca.getText());
                    articulo.setNoLote(Long.parseLong(txtNoLote.getText()));
                    String respuesta = new ArticulosNegocio().Insertar(articulo);
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
                    Articulos articulo = new Articulos();
                    articulo.setID(Integer.parseInt(cboID.getSelectedItem().toString()));
                    articulo.setMaterial(txtMaterial.getText());
                    articulo.setCategoria(txtCategoria.getText());
                    articulo.setEstilo(txtEstilo.getText());
                    articulo.setColor(txtColor.getText());
                    articulo.setTamanio(txtTamanio.getText());
                    articulo.setMarca(txtMarca.getText());
                    articulo.setNoLote(Long.parseLong(txtNoLote.getText()));
                    String respuesta = new ArticulosNegocio().Actualizar(articulo);
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
                        Articulos articulo = new Articulos();
                        articulo.setID(Integer.parseInt(cboID.getSelectedItem().toString()));
                        articulo.setMaterial(txtMaterial.getText());
                        articulo.setCategoria(txtCategoria.getText());
                        articulo.setEstilo(txtEstilo.getText());
                        articulo.setColor(txtColor.getText());
                        articulo.setTamanio(txtTamanio.getText());
                        articulo.setMarca(txtMarca.getText());
                        articulo.setNoLote(Long.parseLong(txtNoLote.getText()));
                        String respuesta = new ArticulosNegocio().Eliminar(articulo);
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
                    Articulos electrodomestico = new Articulos();
                    electrodomestico.setCategoria(txtCategoria.getText());
                    List<Articulos> electrodomesticosList = new ArticulosNegocio().Buscar(electrodomestico);
                    modelo.setRowCount(0);//recuento de filas
                    for (Articulos it : electrodomesticosList) {
                        Object[] registroLeido = {it.getID(),
                                it.getMaterial()
                                ,it.getCategoria()
                                ,it.getEstilo()
                                ,it.getColor()
                                ,it.getTamanio()
                                ,it.getMarca()
                                ,it.getNoLote()};
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLeerCbo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboArticulo.getSelectedItem();
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
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    int filaSeleccionada = tblDatos.getSelectedRow();
                    cboID.setSelectedItem(modelo.getValueAt(filaSeleccionada,0).toString());
                    txtMaterial.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                    txtCategoria.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                    txtEstilo.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                    txtColor.setText(modelo.getValueAt(filaSeleccionada,4).toString());
                    txtTamanio.setText(modelo.getValueAt(filaSeleccionada,5).toString());
                    txtMarca.setText(modelo.getValueAt(filaSeleccionada,6).toString());
                    txtNoLote.setText(modelo.getValueAt(filaSeleccionada,7).toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void llenarComboBox() {
        try{
            List<Articulos> electrodomesticosList = new ArticulosNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Articulos it: electrodomesticosList) {
                Item item = new Item((it.getID()), it.getCategoria());
                modeloCombo.addElement(item);
            }
            cboArticulo.setModel(modeloCombo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void leerDatos() {
        try {
            List<Articulos> electrodomesticosList = new ArticulosNegocio().Leer();
            modelo.setRowCount(0);
            for (Articulos it: electrodomesticosList) {
                Object[] registroLeido = {it.getID(),
                        it.getMaterial()
                        ,it.getCategoria()
                        ,it.getEstilo()
                        ,it.getColor()
                        ,it.getTamanio()
                        ,it.getMarca()
                        ,it.getNoLote()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){
        }
        
    }

    private void limpiar() {
        txtCategoria.setText("");
        txtColor.setText("");
        txtDescripcion.setText("");
        txtEstilo.setText("");
        txtMarca.setText("");
        txtTamanio.setText("");
        txtMaterial.setText("");
        txtNoLote.setText("");
    }

    private void Iniciar() {
        setTitle("Articulos");
        setContentPane(this.jpaPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);

        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Material");
        modelo.addColumn("Categoria");
        modelo.addColumn("Estilo");
        modelo.addColumn("Color");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Marca");
        modelo.addColumn("No. de Lote");
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
}
