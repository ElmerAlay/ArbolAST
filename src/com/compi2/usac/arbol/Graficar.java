package com.compi2.usac.arbol;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Elmer Alay
 * @version 4.0
 * @since   04-12-2018
 */
public class Graficar {
    
    public String graficarNodo(Nodo nodo){
        String cuerpo = "";
        
        for(Nodo hijos : nodo.getHijos()){
                cuerpo += "\"" + nodo.getIdNodo() + 
                        nodo.getSeparador() + nodo.getEtiqueta() + "=" +
                        nodo.getValor() + "\"->\"" + hijos.getIdNodo() +
                        hijos.getSeparador() + hijos.getEtiqueta() + "=" +
                        hijos.getValor() + "\";\n";
                cuerpo += graficarNodo(hijos);
            
        }
        
        return cuerpo;
    }
    
    public void graficar(Nodo raiz){
        FileWriter file = null;
        PrintWriter pw = null;
        String cadena = graficarNodo(raiz);
        
        try{
            file = new FileWriter("arbol.dot");
            pw = new PrintWriter(file);
            
            pw.println("digraph G {\nnode[shape=box, style=filled,"
                        + " color=blanchedalmond]; \nedge[color="
                        + "chocolate3]; \nrankdir=UD; \n");
            pw.println(cadena);
            pw.println("}");
            
            file.close();
        }catch(Exception e){
            System.out.println("Error " + e);
        }
        
        try{
            String cmd = "dot -Tpng arbol.dot -o arbol.png";
            Runtime.getRuntime().exec(cmd);
        }catch(IOException ioe){
            System.err.println("Error " + ioe);
        }
    }
}
