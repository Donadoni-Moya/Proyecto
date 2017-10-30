/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dominio;

import estructuras.ListaDoble;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public abstract class Constantes {

    //USER SE INSTANCIÓ DE PRUEBA, BORRAR CUANDO SEA NECESARIO
    public static Usuario USER = new Usuario("Timoteo", "123456", true);
    public static String logo;
    public static double IGV;

    //redondea un double a 2 decimales readondeando al numero superior
    public static double redondear(double numero, int cantidad_decimales) {
        String val = numero + "";
        BigDecimal big = new BigDecimal(val);
        big = big.setScale(cantidad_decimales, RoundingMode.HALF_UP);
        return big.doubleValue();
    }

    //redondea un double a dos decimales de forma correcta y devuelve un string
    //formateado a 2 deciamels , ejm: 15.3 devuelve 15.30
    public static String redondearStr(double numero) {
        DecimalFormat df = new DecimalFormat("0.00");
        double num = redondear(numero, 2);
        return df.format(num);
    }

    public static String fechaActual() {
        Calendar fechaActual = Calendar.getInstance();
        String cadenaFecha = String.format("%02d/%02d/%04d",
                fechaActual.get(Calendar.DAY_OF_MONTH),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.YEAR));
        return cadenaFecha;

    }

    public static void cargarLogo(java.awt.Component fm, JLabel lblLogo) {
        lblLogo.setText("");

        Image imagen = fm.getToolkit().getImage(logo);

        imagen = imagen.getScaledInstance(lblLogo.getWidth(), -1, Image.SCALE_AREA_AVERAGING);

        lblLogo.setIcon(new ImageIcon(imagen));
    }

    public static void llenarTabla(JTable jTable, ListaDoble<EntradaSalida> miListaProductos) {

        String Titulo[] = {"Código", "Nombre", "Marca", "Modelo",
            "Precio Unitario", "Cantidad", "Total"};
        String registro[] = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulo);
        DecimalFormat df = new DecimalFormat("0.00");
        for (EntradaSalida p : miListaProductos) {
            registro[0] = String.valueOf(p.getProducto().getCodigo());
            registro[1] = p.getProducto().getNombre();
            registro[2] = p.getProducto().getMarca();
            registro[3] = p.getProducto().getModelo();
            registro[4] = df.format(p.getProducto().getPrecioUnitario());
            registro[5] = String.valueOf(p.getCantidad());
            registro[6] = df.format(p.getTotal());
            modelo.addRow(registro);
        }
        jTable.setModel(modelo);

    }

}
