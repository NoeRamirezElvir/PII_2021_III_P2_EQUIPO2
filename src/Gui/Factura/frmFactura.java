package Gui.Factura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmFactura extends JFrame{
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JPanel jpaContains;
    private JPanel jpaBotones;
    private JPanel jpaDatos;
    private JLabel lblTitulo;
    private JLabel lblCodigo;
    private JLabel lblIDProducto;
    private JTextField txtID;
    private JComboBox cboIDProducto;
    private JLabel lblCliente;
    private JComboBox cboCliente;
    private JLabel lblFecha;
    private JTextField txtFecha;
    private JLabel lblEmpleado;
    private JComboBox comboBox1;
    private JLabel lblTotal;
    private JTextField textField1;
    private JScrollPane sclPaneDatos;
    private JTable tblDatos;
    private JButton btnRegistar;
    private JButton btlListar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnLeerCbo;
    private JButton btnLimpiar;
    private JComboBox comboBox2;
    private JLabel lblFactura;
    private JLabel lblDescripcion;
    private JTextField textField2;
    DefaultTableModel  modelo = new DefaultTableModel();

    public frmFactura() {
        Iniciar();
        btnRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void Iniciar() {
        setTitle("Facturacion");
        setContentPane(this.jpaPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);

        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.setRowCount(0);
        modelo.addColumn("Codigo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Cliente");
        modelo.addColumn("Empleado");
        modelo.addColumn("Producto (Descripcion)");
        modelo.addColumn("Total");
    }
}
