/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.service.impl;

import estructuras.ListaDoble;
import javax.swing.JDialog;
import javax.swing.JFrame;
import proy.dao.impl.ConfiguracionDAOImpl;
import proy.dominio.Categoria;
import proy.dominio.Configuracion;
import proy.service.CategoriaService;
import proy.vista.VentanaConfiguracion;

/**
 *
 * @author Miguel
 */
public class ConfiguracionServiceImpl implements CategoriaService {

    ConfiguracionDAOImpl configuracionDAOImpl = new ConfiguracionDAOImpl();
    
    @Override
    public boolean registrar(Categoria e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean modificar(Categoria e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean modificar(VentanaConfiguracion v) {

        if (true/*VALIDACIONES*/) {            
//
            //TODAS LAS VALCIDACIONES DE DATOS 
            //
            String logo = v.txtLogo.getText();
            String nombre = v.txtNombre.getText();
            String ruc = v.txtRuc.getText();
            String direccion = v.txtDireccion.getText();
            double igv = Double.parseDouble(v.txtIgv.getText());
            Configuracion miConfiguracion = new Configuracion(logo, nombre, ruc, direccion, igv);
            
            configuracionDAOImpl.modificar(miConfiguracion);
            
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Categoria get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<Categoria> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
