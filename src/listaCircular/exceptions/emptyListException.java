/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaCircular.exceptions;

/**
 *
 * @author elio
 */
public class emptyListException extends Exception
{
    @Override
    public String getMessage()
    {
        String msn = "\t\tMensaje: La lista no contiene datos";
        return msn;
    }
}
