package Gui.BienesMuebles;

import Negocio.BienesMuebles.BienesMueblesNegocio;
import Recursos.Clases.BienesMuebles;
import Recursos.Clases.ItemCE;
import Recursos.ClasesExtras.TextPrompt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class frmBienesMuebles extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JPanel jpaContain;
    private JPanel jpaBotones;
    private JPanel jpaDatos;
    private JLabel lbltitulo;
    private JLabel lblId;
    private JLabel lblDescripcion;
    private JLabel lblPrecio;
    private JTextField txtID;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JLabel lblPeso;
    private JLabel lblFechaIngreso;
    private JLabel lblGarantia;
    private JTextField txtPeso;
    private JTextField txtFechaIngreso;
    private JTextField txtGarantia;
    private JButton btnRegistrar;
    private JButton btnListar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnLeerCbo;
    private JButton btLimpiar;
    private JComboBox cboBienMueble;
    private JScrollPane sclPaneDatos;
    private JTable tblDatos;
    private JLabel lblcbo;
    DefaultTableModel modelo;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public frmBienesMuebles() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BienesMuebles bienMueble = new BienesMuebles();
                    bienMueble.setID(Integer.parseInt(txtID.getText()));
                    bienMueble.setDescripcion(txtDescripcion.getText());
                    bienMueble.setPrecio(Double.parseDouble(txtPrecio.getText()));
                    bienMueble.setPeso(Double.parseDouble(txtPeso.getText()));
                    bienMueble.setFechaIngreso(ConvertirFrmatoTextoAFecha(txtFechaIngreso.getText()));
                    bienMueble.setGarantia(Integer.parseInt(txtGarantia.getText()));
                    String respuesta = new BienesMueblesNegocio().Insertar(bienMueble);
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
                    BienesMuebles bienMueble = new BienesMuebles();
                    bienMueble.setID(Integer.parseInt(txtID.getText()));
                    bienMueble.setDescripcion(txtDescripcion.getText());
                    bienMueble.setPrecio(Double.parseDouble(txtPrecio.getText()));
                    bienMueble.setPeso(Double.parseDouble(txtPeso.getText()));
                    bienMueble.setFechaIngreso(ConvertirFrmatoTextoAFecha(txtFechaIngreso.getText()));
                    bienMueble.setGarantia(Integer.parseInt(txtGarantia.getText()));
                    String respuesta = new BienesMueblesNegocio().Actualizar(bienMueble);
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
                    int confirmacion = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea Eliminar este mueble?", "Confirmacion", JOptionPane.WARNING_MESSAGE);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        BienesMuebles bienMueble = new BienesMuebles();
                        bienMueble.setID(Integer.parseInt(txtID.getText()));
                        bienMueble.setDescripcion(txtDescripcion.getText());
                        bienMueble.setPrecio(Double.parseDouble(txtPrecio.getText()));
                        bienMueble.setPeso(Double.parseDouble(txtPeso.getText()));
                        bienMueble.setFechaIngreso(ConvertirFrmatoTextoAFecha(txtFechaIngreso.getText()));
                        bienMueble.setGarantia(Integer.parseInt(txtGarantia.getText()));
                        String respuesta = new BienesMueblesNegocio().Eliminar(bienMueble);
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
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                txtID.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtDescripcion.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtPrecio.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtPeso.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtFechaIngreso.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                txtGarantia.setText(modelo.getValueAt(filaSeleccionada, 5).toString());
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BienesMuebles bienMueble = new BienesMuebles();
                    bienMueble.setDescripcion(txtDescripcion.getText());
                    List<BienesMuebles> bienesMueblesList = new BienesMueblesNegocio().Buscar(bienMueble);
                    modelo.setRowCount(0);//recuento de filas
                    for (BienesMuebles item : bienesMueblesList) {
                        Object[] registroLeido = {
                                item.getID(),
                                item.getDescripcion(),
                                item.getPrecio(),
                                item.getPeso(),
                                sdf.format(item.getFechaIngreso()),
                                item.getGarantia()};
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
                Object objeto = cboBienMueble.getSelectedItem();
                String itemBienMueble = ((ItemCE)objeto).getNombre();
                JOptionPane.showMessageDialog(null,itemBienMueble);
            }
        });
        btLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                txtPeso.setText("");
                txtFechaIngreso.setText("");
                txtGarantia.setText("");
            }
        });
    }
    private Date ConvertirFrmatoTextoAFecha(String text) {
        Date fecha = null;
        try {
            fecha = sdf.parse(text);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }
    private void Iniciar() {
        setTitle("Registro de Bienes Muebles");
        setContentPane(this.jpaPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        TextPrompt titulos = new TextPrompt("Kg.",txtPeso);
        TextPrompt titulo = new TextPrompt("Meses.",txtGarantia);
        titulos.changeAlpha(0.75f);
        titulo.changeAlpha(0.75f);
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("ID");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio (Lps)");
        modelo.addColumn("Peso (Kg)");
        modelo.addColumn("Fecha de Ingreso");
        modelo.addColumn("Garantía (meses)");
        leerDatos();
        llenarComboBox();
    }
    private void llenarComboBox() {
        try {
            List<BienesMuebles> bienesMueblesList = new BienesMueblesNegocio().Leer();
            DefaultComboBoxModel combomodel = new DefaultComboBoxModel();
            for (BienesMuebles bienmueble : bienesMueblesList) {
                ItemCE objeto = new ItemCE( bienmueble.getID(), bienmueble.getDescripcion());
                combomodel.addElement(objeto);
            }
            cboBienMueble.setModel(combomodel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void leerDatos() {
        try {
            List<BienesMuebles> bienesMueblesList = new BienesMueblesNegocio().Leer();
            modelo.setRowCount(0);//recuento de filas
            for (BienesMuebles item : bienesMueblesList) {
                Object[] registroLeido = {
                        item.getID(),
                        item.getDescripcion(),
                        item.getPrecio(),
                        item.getPeso(),
                        sdf.format(item.getFechaIngreso()),
                        item.getGarantia()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);

        } catch (Exception e) {
        }
    }
}
