/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EList;

import listaCircular.exceptions.emptyListException;
import listaCircular.exceptions.itemNotFoundException;

/**
 *
 * @author elio
 */
public class EList<T> 
{
    private nodo<T> primerNodo;
    /**
     * Metodo que ingresa datos al principio de la lista
     * @param datoR
     * @return lista<T>
     */
    public EList<T> addFirst(T datoR)
    {
        if(isEmpty())
        {
            primerNodo = new nodo<T>(datoR);
            primerNodo.setEnlace(primerNodo);
        }//if
        else
        {
            nodo<T> aux = primerNodo;
            //se busca el ultimo nodo
            while(aux.getEnlace() != primerNodo)
		  aux=aux.getEnlace();
            nodo<T> nuevo = new nodo<T>(datoR);
            aux.setEnlace(nuevo);
            nuevo.setEnlace(primerNodo);
            //aux.enlace = nuevo;//se enlaza el ultimo nodo con el nuevo nodo
            //nuevo.enlace = primerNodo;//se enlaza el nuevo nodo con el primer nodo
            primerNodo = nuevo;//el primer nodo pasa a ser igual al ultimo nuevo
        }//else
        return this;
    }//addFirst
    
    /**
     * Metodo que ingresa datos al final de la lista
     * @param datoR
     * @return lista<T>
     */
    public EList<T> addLast(T datoR)
    {
        if(isEmpty())
        {
            primerNodo = new nodo<T>(datoR);
            primerNodo.setEnlace(primerNodo);
        }//if
        else
        {
            nodo<T> aux = primerNodo;
            //se busca el ultimo nodo
            while(aux.getEnlace() != primerNodo)
		  aux=aux.getEnlace();
            nodo<T> nuevo = new nodo<T>(datoR);
            aux.setEnlace(nuevo);//se enlaza el ultimo nodo con el nuevo
            nuevo.setEnlace(primerNodo);//se enlaza el nuevo con el primero
            //nota: el primer nodo no pasa a ser el igual al ultimo, se deja el nuevo de ultimo.
        }//else
        return this;
    }//addLast
    
    /**
     * Metodo que modifica el valor ubicado en la posicion indicada con el valor indicado
     * Retorna true si se realizo correctamente el proceso, false en caso contrario
     * @param index
     * @param element
     * @return 
     */
    public boolean set(int index, T element)
    {
        boolean aux = false;
        if(!isEmpty())
        {
            int cont;
            nodo<T> nodoR = primerNodo;
            for (cont = 0/**/; nodoR != null;/**/ nodoR = nodoR.getEnlace(), cont++) 
            {
                if (cont == index) 
                {
                    nodoR.setDato(element);
                    aux = true;
                }//if
            }//for
        }
        return aux;
    }//buscar
    
    /**
     * Metodo que elimina todos los datos de la lista
     * Retorna true si se realizo correctamente el proceso, false en caso contrario
     * @return boolean
     */
    public boolean clear()
    {
        boolean aux = false;
        if(!isEmpty())
        {
            //se hace null el primerNodo para que la maquina virtual se encargue de liberar el espacio de memoria
            primerNodo = null;
            aux = true;
        }//if
        return aux;
    }//clear
    
    /**
     * Metodo que retorna el ultimo nodo de la lista
     * @return nodo<T>
     */
    public nodo<T> last()
    {
        nodo<T> n = primerNodo;
        if(!isEmpty())
        {
            while(n.getEnlace() != primerNodo)
                n = n.getEnlace();
        }//if
        return n;
    }//last
    
    
     /**
     * Metodo que elimina un dato de la lista almacenado en la posicion especificada, en caso de encontrarse en ella.
     * Sino arroja una exception llamada itemNotFoundException
     * Retorna true si se realizo correctamente el proceso, false en caso contrario
     * @param  index
     * @return boolean
     */
    public boolean remove(int index)
    {
        boolean auxA = false, auxB = false;
        nodo<T> nodoR = primerNodo;
        nodo<T> nodoAnterior = null;
        if(!isEmpty())
        {
            int i = 0;
            while(nodoR != primerNodo || !auxB)
            {
                auxB = true;
                if(i == index)
                {
                    //si nada mas hay un solo dato, se hace null el primerNodo
                    if (nodoR.getEnlace() == nodoR) 
                    {
                        primerNodo = null;
                        break;//es obligatorio salir del bucle, sino entra en un bucle infinito
                    }//if
                    else
                    {
                        if(i == 0)//si es el nodo de la primera posicion
                        {
                            //System.out.println("anterior " + last().dato);
                            //System.out.println("siguiente " + nodoR.enlace.dato);
                            //se enlazan el nodo siguiente con el anterior al nodo que se va a eliminar
                            last().setEnlace(nodoR.getEnlace());
                            //el segundo pasa a ser el primero
                            primerNodo = nodoR.getEnlace();
                            auxA = true;
                            break;
                        }//if - sino es el nodo de la primera posicion
                        else
                        {
                            //System.out.println("anterior " + nodoAnterior.dato);
                            ///System.out.println("siguiente " + nodoR.enlace.dato);
                            //se enlazan el nodo siguiente con el anterior al nodo que se va a eliminar
                            
                            nodoAnterior.setEnlace(nodoR.getEnlace());
                            auxA = true;
                            break;
                        }//else
                    }//else
                }//if
                nodoAnterior = nodoR;
                nodoR = nodoR.getEnlace();
                i++;
            }//while
        }//if
        else//no tiene datos la lista 
        {
            try 
            {
                throw new emptyListException();
            }//try
            catch (emptyListException ex) 
            {
                System.out.println(ex.getMessage());
            }//catch
        }//else
        if(!auxA)//sino se encontro ningun elemento con la descripcion 
        {
            try 
            {
                throw new itemNotFoundException();
            }//try 
            catch (itemNotFoundException ex) 
            {
                System.out.println(ex.getMessage());
            }//catch
        }//if
        return auxA;
    }//remove
    
    /**
     * Metodo que elimina el dato recibido de la lista, en caso de encontrarse en ella.
     * Sino arroja una exception llamada itemNotFoundException
     * Retorna true si se realizo correctamente el proceso, false en caso contrario
     * @param datoR
     * @return boolean
     */
    public boolean remove(T datoR)
    {
        boolean auxA = false, auxB = false;
        nodo<T> nodoR = primerNodo;
        nodo<T> nodoAnterior = null;
        if(!isEmpty())
        {
            int i = 0;
            while(nodoR != primerNodo || !auxB)
            {
                auxB = true;
                //si el dato del nodo es igual al del argumento recibido
                if(nodoR.getDato() == datoR)
                {
                    //si nada mas hay un solo dato, se hace null el primerNodo
                    if (nodoR.getEnlace() == nodoR) 
                    {
                        primerNodo = null;
                        break;//es obligatorio salir del bucle, sino entra en un bucle infinito
                    }//if
                    else
                    {
                        if(i == 0)//si es el nodo de la primera posicion
                        {
                            //System.out.println("anterior " + last().dato);
                            //System.out.println("siguiente " + nodoR.enlace.dato);
                            //se enlazan el nodo siguiente con el anterior al nodo que se va a eliminar
                            last().setEnlace(nodoR.getEnlace());
                            //el segundo pasa a ser el primero
                            primerNodo = nodoR.getEnlace();
                            auxA = true;
                            break;
                        }//if - sino es el nodo de la primera posicion
                        else
                        {
                            //System.out.println("anterior " + nodoAnterior.dato);
                            ///System.out.println("siguiente " + nodoR.enlace.dato);
                            //se enlazan el nodo siguiente con el anterior al nodo que se va a eliminar
                            
                            nodoAnterior.setEnlace(nodoR.getEnlace());
                            auxA = true;
                            break;
                        }//else
                    }//else
                }//if
                nodoAnterior = nodoR;
                nodoR = nodoR.getEnlace();
                i++;
            }//while
        }//if
        else//no tiene datos la lista 
        {
            try 
            {
                throw new emptyListException();
            }//try
            catch (emptyListException ex) 
            {
                System.out.println(ex.getMessage());
            }//catch
        }//else
        if(!auxA)//sino se encontro ningun elemento con la descripcion 
        {
            try 
            {
                throw new itemNotFoundException();
            }//try
            catch (itemNotFoundException ex) 
            {
                System.out.println(ex.getMessage());
            }//catch
        }//if
        return auxA;
    }//remove
    
    /**
     * Metodo que retorna el dato de la posicion recibida
     * @param index
     * @return T
     */
    public T get(int index)
    {
        if(!isEmpty())//sino esta vacia la lista
        {
            int cont = 0;
            T result = null;
            nodo<T> nodoR = primerNodo;
            for (/**/; nodoR != null;/**/ nodoR = nodoR.getEnlace(), cont++) 
            {
                if(cont == index)
                {
                    result = nodoR.getDato();
                    break;
                }//if
            }//for
            return result;
        }//if
        else//si esta vacia retorna null
            return null;
    }//get
    
    /**
     * Metodo que indica la posicion en la cual esta el dato recibido
     * @param dataRecibida
     * @return int
     */
    public int indexOf(T dataRecibida)
    {
        if(!isEmpty())//sino esta vacia
        {
            int cont = 0, result = 0;
            nodo<T> nodoR = primerNodo;
            for (nodoR = primerNodo/**/; nodoR != null;/**/ nodoR = nodoR.getEnlace(), cont++) 
            {
                if(nodoR.getDato() == dataRecibida)
                {
                    result = cont;
                    break;
                }//if
            }//for
            return result;
        }//if
        else//si esta vacia retorna -1
            return -1;
    }//get
    
    /**
     * Metodo que copia los datos de la lista a un arreglo recibido como argumento
     * @param data
     * @return T[]
     */
    public T[] toArray(T[] data)
    {
        if(!isEmpty())//si tiene datos, copia los datos de los arrays
            System.arraycopy(toArray(), 0, data, 0, size());
        else//sino muestra una exception
            try 
            {
                throw new emptyListException();
            }//try 
            catch (emptyListException ex) 
            {
                System.out.println(ex.getMessage());
            }//catch
        return data;
    }//toArray
    
    /**
     * Metodo que copia los datos de la lista a un arreglo tipo Object el cual es retornado
     * @return Object[]
     */
    public Object[] toArray()
    {
        Object array[] = new Object[size()];
        if(isEmpty())
        {
            return null;
        }//if
        else
        {
            int count = 0;
            boolean aux = false;
            nodo<T> nodoR = primerNodo;
            while (nodoR != primerNodo || !aux)
            {
                aux = true;
                array[count] = nodoR.getDato();
                count++;
                nodoR = nodoR.getEnlace();
            }//while
            return array;
        }//else
    }//toArray
    
    public int size()
    {
        if(isEmpty())
        {
            return 0;
        }//if
        else
        { 
            int count = 1;
            nodo<T> nodoR = primerNodo;
            while(nodoR.getEnlace() != primerNodo)
            {
                count ++;
                nodoR=nodoR.getEnlace(); 
            }//while
            return count;
        }//else
    }//size
    
    /**
     * Metodo que recibe un argumento y indica si este dato esta en lista o no.
     * @param element
     * @return 
     */
    public boolean contains(T element)
    {
        boolean auxA = false, auxB = false;
        nodo<T> nodoR = primerNodo;
        if(!isEmpty())
        {
            while(nodoR != primerNodo || !auxB)
            {
                auxB = true;
                if(nodoR.getDato() == element)
                {   
                    auxA = true;
                    break; 
                }//if
                nodoR = nodoR.getEnlace();
            }//for
        }//if
        else  
        {
            try 
            {
                throw new emptyListException();
            }//try 
            catch (emptyListException ex) 
            {
                System.out.println(ex.getMessage());
            }//catch
        }//else
        return auxA;
    }//contains
    
    /**
     * Metodo que indica si la lista de datos esta vacia
     * @return boolean
     */
    public boolean isEmpty()
    {
        return primerNodo == null;
    }//isEmpty
    
    public static void main(String[] args)
    {
        EList<Integer> list = new EList<Integer>();
        list.addFirst(23);
        list.addFirst(24);
        list.addFirst(7);
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("datos: " + arr[i]);
        }
        //System.out.println("count " + list.size());
//        System.out.println("datos " + primerNodo);
//        System.out.println("as    " + primerNodo.dato);
//        System.out.println("ass   " + primerNodo.enlace.dato);
//        System.out.println("asss  " + primerNodo.enlace.enlace.dato);
//        System.out.println("assss " + primerNodo.enlace.enlace.enlace.dato);
//        System.out.println("ass   " + primerNodo.enlace.enlace.enlace.enlace.dato);
//        System.out.println("asss  " + primerNodo.enlace.enlace.enlace.enlace.enlace.dato);
//        System.out.println("assss " + primerNodo.enlace.enlace.enlace.enlace.enlace.enlace.dato);
    }
}//CLASS
