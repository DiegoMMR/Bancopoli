/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dieez
 */
public class Jugador {
    
    private Pieza _Pieza;
    private double saldo;
    private double valorPropiedadoes;
    private int seleccion;
    private final String  perro = "/img/perro.png";
    private final String carro = "/img/carro.png";
    private final String sombrero = "/img/sombrero.png";
    private String aux;
    private final Cuadros _Cuadros;
    private final Point matriz[];
    
    public Jugador (String jugador)
    {
        this._Cuadros = new Cuadros();
        this._Pieza = new Pieza(jugador);
        this.saldo = 500;
        this.valorPropiedadoes = 0;
        this.seleccion = 0;
        this.matriz = this._Cuadros.getMatriz();
        
    }

    public Pieza getPieza() {return _Pieza;}
    public void setPieza(Pieza _Pieza) {this._Pieza = _Pieza;}

    public double getSaldo() {return saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}
    
    public double getValorPropiedadoes() {return valorPropiedadoes;}
    public void setValorPropiedadoes(double valorPropiedadoes) {this.valorPropiedadoes = valorPropiedadoes;}

    public int getSeleccion() {return seleccion;}
    public void setSeleccion(int seleccion) {this.seleccion = seleccion;}
    
    //agrega una pieza al trablero
    public void agregar(JPanel panel)
    {
        switch (this.seleccion) {
            case 1:
                this.aux = this.perro;
                break;
            case 2:
               this.aux = this.carro;
                break;
            case 3:
                this.aux = this.sombrero;
                break;
            default:
                break;
        }

        this._Pieza.setIcon(new ImageIcon(getClass().getResource(aux)));
        this._Pieza.setLocation(_Cuadros.getInicio());
        panel.add(this._Pieza);
    }
    
    //mueve la pueza segun el dado
    public void mover(int dado, JLabel saldo) {

        int auxiliar = 0;

        //busca la posicion de la pieza
        for (int j = 0; j < 23; j++) {

            if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, matriz[j].getLocation().x, matriz[j].getLocation().y) == 0) {
                auxiliar = j;
                break;
            }
        }
        
        
        //calcula si puede pasar la salida para poder sumar 100 al saldo
        if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, _Cuadros.getSantaRosa().getLocation().x,  _Cuadros.getSantaRosa().getLocation().y) == 0 && dado > 5){this.setSaldo(this.saldo + 100);}
        if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, _Cuadros.getZacapa().getLocation().x,_Cuadros.getZacapa().getLocation().y) == 0 && dado > 4){this.setSaldo(this.saldo + 100);}
        if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, _Cuadros.getGuatemala().getLocation().x, _Cuadros.getGuatemala().getLocation().y) == 0 && dado > 2){this.setSaldo(this.saldo + 100);}
        if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, _Cuadros.getJutiapa().getLocation().x,  _Cuadros.getJutiapa().getLocation().y) == 0 && dado > 1){this.setSaldo(this.saldo + 100);}
        if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, _Cuadros.getSat2().getLocation().x,  _Cuadros.getSat2().getLocation().y) == 0 && dado > 1){this.setSaldo(this.saldo + 100);}

        //aumenta la posicion de la matriz segun el dado
        for (int i = dado; i > 0; i--) {
            auxiliar++;

        }
        //mueve la pieza
        this._Pieza.setLocation(matriz[auxiliar]);
        //si la pieza cae en el inicio se le suman 100 al saldo para poder sumar 200 si cae en la casiila
        if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, _Cuadros.getInicio().getLocation().x, _Cuadros.getInicio().getLocation().y) == 0) {
            this.setSaldo(this.saldo + 100);

        }
        
        saldo.setText("Q. " + String.valueOf(this.saldo));
    }
    
    
}
