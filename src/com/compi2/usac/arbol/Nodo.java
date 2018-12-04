package com.compi2.usac.arbol;

import java.util.ArrayList;

/**
 * @author Elmer Alay
 * @version 1.0
 * @since   03-12-2018
 */
public class Nodo {
    private String etiqueta;
    private ArrayList<Nodo> hijos = new ArrayList<>();
    private String valor;
    private int idNodo;
    private String separador;

    public Nodo() {
        etiqueta = null;
        valor = null;
        idNodo = 0;
        separador = null;
    }
    
    public void addHijos(Nodo hijo){
        hijos.add(hijo);
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public String getSeparador() {
        return separador;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }
    
    
    
}
