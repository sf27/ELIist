/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elist;

/**
 * 
 * @author Elio Rincón
 */
public class nodo<T> {
    private T       data;
    private nodo<T> enlace;

    // int dato = 0;
    // nodo1 enlace;
    public nodo(T dataRec) {
        this.data = dataRec;
        enlace = null;
    }

    public void setEnlace(nodo<T> e) {
        enlace = e;
    }

    public nodo<T> getEnlace() {
        return enlace;
    }

    public void setDato(T dataRec) {
        data = dataRec;
    }

    public T getDato() {
        return data;
    }
}
