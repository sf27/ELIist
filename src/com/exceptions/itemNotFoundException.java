/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exceptions;

/**
 * 
 * @author elio
 */
public class itemNotFoundException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 3243117061851290837L;

    @Override
    public String getMessage() {
        String msn = "\t\tMensaje: No se encontro el item seleccionado";
        return msn;
    }
}
