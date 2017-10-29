/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dao.impl;

import estructuras.ListaDoble;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static proy.dao.AbstractDAO.PASSWORD;
import static proy.dao.AbstractDAO.URL_BASEDEDATOS;
import static proy.dao.AbstractDAO.USUARIO;
import proy.dao.ConfiguracionDAO;
import proy.dominio.Configuracion;
import proy.vista.VentanaMenuPrincipal;
import java.net.URL;

/**
 *
 * @author Miguel
 */
public class ConfiguracionDAOImpl implements ConfiguracionDAO{
    
    private final String nombreTabla="Configuracion";
    private final String campoNombreEmp="nombreEmpresa";
    private final String campoLogo="logo";
    private final String campoRUC="RUC";
    private final String campoDireccion="direccion";
    private final String campoIgv="IGV";
    
    @Override
    public boolean modificar(Configuracion elem) {
        //Logica de actualizacion en BD
        //UPDATE
        return true;

    }
    
    //solo habrá una configuracion con ID = 1
    @Override
    public Configuracion get(String ID) {
    // Aqui el id no interesa, solo habra una configurracion en la base de datos 
//        try {
//
//            ResultSet rs = null;
//            Connection conn = null;
//            PreparedStatement pstmt = null;
//            Configuracion configuracion = null;
//            
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//
//            /* Preparamos la conexion hacia la base de datos */
//            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);
//
//            /* Preparamos la sentencia SQL a ejecutar */
//            String query = "SELECT "+campoNombreEmp+","+campoLogo+","+campoRUC+
//                    ","+campoDireccion+","+campoIgv+" FROM "+nombreTabla;
//            
//            pstmt = conn.prepareStatement(query);
//            
//            /* Ejecutamos la sentencias SQL */
//            rs = pstmt.executeQuery();
//
//            /* Obtenemos los datos seleccionados */
//            if (rs.next()) {
//                String nombre = rs.getString(campoNombreEmp);
//                String logo = rs.getString(campoLogo);
//                String direccion = rs.getString(campoDireccion);
//                String ruc = rs.getString(campoRUC);
//                float igv = rs.getFloat(campoIgv);
//                
//                configuracion = new Configuracion(logo, nombre, ruc, direccion, igv);
//            }
//            return configuracion;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        /* Si no encontro ningun dato, retornamos null */
//        return null;
        
        //Logica de buscar por ID
        //SELECT
        //WHERE ID = ELEM
        URL url = getClass().getResource("/proy/images/logo.png");  
        System.out.println(url.toExternalForm().replace("file:/", "")); // = C:/Users/... 
        return new Configuracion(url.toExternalForm().replace("file:/", ""),"UNSMS", "123456789012", "Av. Universitaria /Calle Germán Amézaga 375. Edificio Jorge Basadre Ciudad Universitaria", 0.18);
//        return new Configuracion("/proy/images/logo.png","UNSMS", "123456789012", "Av. Universitaria /Calle Germán Amézaga 375. Edificio Jorge Basadre Ciudad Universitaria", 0.18);
        
        //ELIMINAR ESTE RETURN, SOLO SE UTILIZA PARA PROBAR LA CARGA INICIAL(EN EL MAIN)
    }

    
    //El resto de metodos NO es necesario implementarlos
    @Override
    public boolean registrar(Configuracion nuevaConf) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /* Preparamos la conexion hacia la base de datos */
            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoNombreEmp+","
                    +campoLogo+","+campoRUC+","+campoDireccion+","+campoIgv+") "
                    + "VALUES (?,?,?,?,?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nuevaConf.getNombreEmpresa());
            pstmt.setString(2, nuevaConf.getLogo());
            pstmt.setString(3, nuevaConf.getRUC());
            pstmt.setString(4, nuevaConf.getDireccion());
            pstmt.setDouble(5, nuevaConf.getIGV());

            pstmt.executeUpdate();

            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }

    @Override
    public ListaDoble<Configuracion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
