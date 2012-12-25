/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaCircular.exceptions;

/**
 *
 * @author elio
 */
public class itemNotFoundException extends Exception 
{
    @Override
    public String getMessage()
    {
        String msn = "\t\tMensaje: No se encontro el item seleccionado";
        return msn;
    }
}
