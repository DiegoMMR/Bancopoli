/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Point;
import javax.swing.JOptionPane;

/**
 *
 * @author dieez
 */
public class Casilla {
    
    boolean bDueño;
    private Point posicion;
    String sDueño;
    double precio;
    private int alquiler;
    String nombre;
    
    
    
    public Casilla(){}
    
    public Casilla(double precio, Point posicion, String nombre)
    {
        this.bDueño = false;
        this.sDueño = "nadie";
        this.precio = precio;
        this.posicion = posicion;
        this.alquiler = 50;
        this.nombre = nombre;
        
        
        
    }

    public boolean isbDueño() {
        return bDueño;
    }

    public void setbDueño(boolean bDueño) {
        this.bDueño = bDueño;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public String getsDueño() {
        return sDueño;
    }

    public void setsDueño(String sDueño) {
        this.sDueño = sDueño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
  
    
    
    
    
    
    
}
