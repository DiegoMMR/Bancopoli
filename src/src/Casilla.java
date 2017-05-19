/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Point;

/**
 *
 * @author dieez
 */
public class Casilla {
    
    private boolean bDuenño;
    private Point posicion;
    private String sDueño;
    private double precio;
    private int alquiler;
    
    Cuadros _Cuadros = new Cuadros();
    
    public Casilla(double precio, Point posicion)
    {
        this.bDuenño = false;
        this.sDueño = "nadie";
        this.precio = precio;
        this.posicion = posicion;
        this.alquiler = 50;
        
        
    }
    
    //crea todas las casillas
    Casilla huehue = new Casilla(130,_Cuadros.getHuehue());
    Casilla xela = new Casilla(100,_Cuadros.getXela());
    Casilla altaVerapaz = new Casilla(90,_Cuadros.getAltaVerapaz());
    Casilla quiche = new Casilla(150,_Cuadros.getQuiche());
    Casilla izabal = new Casilla(140,_Cuadros.getIzabal());
    Casilla peten = new Casilla(50,_Cuadros.getPeten());
    Casilla fegua = new Casilla(190,_Cuadros.getFegua());
    Casilla solola = new Casilla(170,_Cuadros.getSolola()); 
    Casilla sat1 = new Casilla(0.1,_Cuadros.getSat1());
    Casilla sanMarcos = new Casilla(230,_Cuadros.getSanMarcos());
    Casilla bajaVerapaz = new Casilla(250,_Cuadros.getBajaVerapaz());
    Casilla empagua = new Casilla(175,_Cuadros.getEmpagua());
    Casilla santaRosa = new Casilla(310,_Cuadros.getSantaRosa());
    Casilla zacapa = new Casilla(270,_Cuadros.getZacapa());
    Casilla guatemala = new Casilla(250,_Cuadros.getGuatemala());
    Casilla jutiapa = new Casilla(270,_Cuadros.getJutiapa());
    Casilla sat2 = new Casilla(0.1,_Cuadros.getSat2());
    
    
    //matriz con mismas posiciones que las de cuadros para facilitar el manejo de posiciones en la mesa
    private Casilla matriz[] = {null, huehue, xela, altaVerapaz, null, quiche, izabal, peten, fegua, solola, sat1,
                              null, sanMarcos, bajaVerapaz, empagua, null, null, santaRosa, zacapa,
                              guatemala, jutiapa, sat2, null, huehue, xela, altaVerapaz, null, quiche, izabal, peten};
    
    
}
