/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private final Casillas _Casillas;
    private final Point matriz[];
    private String nombre;
    private boolean bancarrota;
    
    public double cantidadAPagar;
    public String jugadorAPagar;
    
    
    public double getCantidadAPagar() {return cantidadAPagar;}
    public void setCantidadAPagar(double cantidadAPagar) {this.cantidadAPagar = cantidadAPagar;}

    public String getJugadorAPagar() {return jugadorAPagar;}
    public void setJugadorAPagar(String jugadorAPagar) {this.jugadorAPagar = jugadorAPagar;}
    
    public Jugador (String jugador)
    {
        this._Cuadros = new Cuadros();
        this._Pieza = new Pieza(jugador);
        this.saldo = 500;
        this.valorPropiedadoes = 0;
        this.seleccion = 0;
        this.matriz = this._Cuadros.getMatriz();
        this.nombre = jugador;
        this._Casillas = new Casillas();
        this.bancarrota = false;
        
    }

    public boolean isBancarrota() {return bancarrota;}
    public void setBancarrota(boolean bancarrota) {this.bancarrota = bancarrota;}

    
    
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}    
    
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
    public void mover(int dado, JLabel saldo, Casilla matrizC[]) {

        int auxiliar = 0;
        
        //busca la posicion de la pieza
        for (int j = 0; j < 23; j++) {

            if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, matriz[j].getLocation().x, matriz[j].getLocation().y) == 0) {
                auxiliar = j;
                break;
            }
        }
        
        
                
        //calcula si puede pasar la salida para poder sumar 100 al saldo
        if (Point.distance(this._Pieza.getLocation().x, this._Pieza.getLocation().y, _Cuadros.getSaqueCupon().getLocation().x,  _Cuadros.getSaqueCupon().getLocation().y) == 0 && dado > 6){this.setSaldo(this.saldo + 100);}
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
        
        
        _Casillas.caer(this, auxiliar, matrizC);
        
        this.cantidadAPagar = _Casillas.getCantidadAPagar();
        this.jugadorAPagar = _Casillas.getJugadorAPagar();
          
         System.out.println("Cantidad a pagar jugador: " + this.cantidadAPagar);
        
         //Se envia a la carcel y paga Q100
        if (auxiliar == 15) {
            JOptionPane.showMessageDialog(null, "Ve a la carcel y paga Q100 ");
            this.setSaldo(this.saldo - 100);
            this._Pieza.setLocation(matriz[4]);
            auxiliar = 4;
        }
        //Al caer en cupones se genera un numero aleatorio que representa cada cupon
        if (auxiliar == 16) {
            int cuponNum = (int) (Math.random() * 5 + 1);
            switch (cuponNum){
                case 1:  cuponNum = 1;
                    JOptionPane.showMessageDialog(null, "Haz ganado un bono de Q100");
                    this.setSaldo(this.saldo + 100);
                    break;
                case 2:  cuponNum = 2;
                    JOptionPane.showMessageDialog(null, "Haz ganado un bono de Q500");
                    this.setSaldo(this.saldo + 500);
                    break;
                case 3:  cuponNum = 3;
                    JOptionPane.showMessageDialog(null, "Debes pagar impuestos extra por un monto de Q100");
                    this.setSaldo(this.saldo - 100);
                    break;
                case 4:  cuponNum = 4;
                    JOptionPane.showMessageDialog(null, "Ve a la carcel");
                    this.setSaldo(this.saldo - 100);
                    this._Pieza.setLocation(matriz[4]);
                    auxiliar = 4;
                    break;
                case 5:  cuponNum = 5;
                    JOptionPane.showMessageDialog(null, "Ve al inicio y cobra Q100");
                    this.setSaldo(this.saldo + 100);
                    this._Pieza.setLocation(matriz[0]);
                    auxiliar = 0;
                    break;
                default: break;
            }
        }
        
        saldo.setText("Q. " + String.valueOf(this.saldo));
        
      
        
    }
    
    
    
}
