/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.event.ActionEvent;
import proy.controlador.CReporteEntrada;
import proy.vista.VentanaReporteEntrada;

/**
 *
 * @author Miguel
 */
public class CReporteEntradaImpl extends CPadreReportesIngresoSalida implements CReporteEntrada {
    
    
    @Override
    public void clickBtnEliminar(ActionEvent e){
        System.out.println("clickBtnEliminar de ventana Entrada");
    }
    
}
