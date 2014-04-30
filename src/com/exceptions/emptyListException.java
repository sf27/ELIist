/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exceptions;

/**
 * 
 * @author elio
 */
public class emptyListException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 763546965209773139L;

    @Override
    public String getMessage() {
        String msn = "\t\tMensaje: La lista no contiene datos";
        return msn;
    }
}
