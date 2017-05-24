/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.swing.JOptionPane;

/**
 *
 * @author dieez
 */
public class Casillas {
    
    public Casillas(){}
    
    Cuadros _Cuadros = new Cuadros();
    
      //crea todas las casillas
    public Casilla huehue = new Casilla(130,_Cuadros.getHuehue(),"Huehue");
    public Casilla xela = new Casilla(100,_Cuadros.getXela(),"Xela");
    public Casilla altaVerapaz = new Casilla(90,_Cuadros.getAltaVerapaz(),"Alta Verapaz");
    public Casilla quiche = new Casilla(150,_Cuadros.getQuiche(),"Quiche");
    public Casilla izabal = new Casilla(140,_Cuadros.getIzabal(),"Izabal");
    public Casilla peten = new Casilla(50,_Cuadros.getPeten(),"Peten");
    public Casilla fegua = new Casilla(190,_Cuadros.getFegua(),"Fegua");
    public Casilla solola = new Casilla(170,_Cuadros.getSolola(),"Solola"); 
    public Casilla sat1 = new Casilla(0.1,_Cuadros.getSat1(),"Sat");
    public Casilla sanMarcos = new Casilla(230,_Cuadros.getSanMarcos(),"San Marcos");
    public Casilla bajaVerapaz = new Casilla(250,_Cuadros.getBajaVerapaz(),"Baja Verapaz");
    public Casilla empagua = new Casilla(175,_Cuadros.getEmpagua(),"Empagua");
    public Casilla santaRosa = new Casilla(310,_Cuadros.getSantaRosa(),"Santa Rosa");
    public Casilla zacapa = new Casilla(270,_Cuadros.getZacapa(),"Zacapa");
    public Casilla guatemala = new Casilla(250,_Cuadros.getGuatemala(),"Guatemala");
    public Casilla jutiapa = new Casilla(270,_Cuadros.getJutiapa(),"Jutiapa");
    public Casilla sat2 = new Casilla(0.1,_Cuadros.getSat2(),"Sat");
    
    private double cantidadAPagar;
    private String jugadorAPagar;
    
    //matriz con mismas posiciones que las de cuadros para facilitar el manejo de posiciones en la mesa
    public Casilla matriz[] = {null, huehue, xela, altaVerapaz, null, quiche, izabal, peten, fegua, solola, sat1,
                              null, sanMarcos, bajaVerapaz, empagua, null, null, santaRosa, zacapa,
                              guatemala, jutiapa, sat2, null, huehue, xela, altaVerapaz, null, quiche, izabal, peten};

    public Casilla[] getMatriz() {return matriz;}
    public void setMatriz(Casilla[] matriz) {this.matriz = matriz;}

    public double getCantidadAPagar() {return cantidadAPagar;}
    public void setCantidadAPagar(double cantidadAPagar) {this.cantidadAPagar = cantidadAPagar;}

    public String getJugadorAPagar() {return jugadorAPagar;}
    public void setJugadorAPagar(String jugadorAPagar) {this.jugadorAPagar = jugadorAPagar;}
    
    
    
    
    
    //jugador a pagar y cantidad a pagar son auxiliares para poderlos llevar a la mesa
    public void caer(Jugador _Jugador, int posicion, Casilla matriz[]) {

        Casilla _Casilla = matriz[posicion];
        
       this.cantidadAPagar = 0;
       this.jugadorAPagar = "";  
        
        if (_Casilla != null) {
            
        
        

            //ventana si o no
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = 0;

             //Tiene dueño
            if (_Casilla.isbDueño() == true && (_Casilla.getsDueño() == null ? _Jugador.getNombre() != null : !_Casilla.getsDueño().equals(_Jugador.getNombre())))
            {       
                //muesta mendaje de a quien y cuanto se le debe pagar
                JOptionPane.showMessageDialog(null, _Casilla.getNombre() + " es de " + _Casilla.getsDueño() + " y debes de pagarle Q. " + _Casilla.getAlquiler());
                
               this.cantidadAPagar = _Casilla.getAlquiler();
               this.jugadorAPagar = _Casilla.getsDueño();  
                
                //valida si le alcanza para pagar
                if(_Jugador.getSaldo() > this.cantidadAPagar)
                {
                double saldo = _Jugador.getSaldo() - this.cantidadAPagar;
                _Jugador.setSaldo(saldo);
                //si no le alcanza lo pone en bancarrota
                }else
                {
                    this.cantidadAPagar = _Jugador.getSaldo();
                    _Jugador.setBancarrota(true);
                }
                
                System.out.println("Cantidad a pagar casilla: " +this.cantidadAPagar);
            }
            
            //si la casilla esta al noombre del que esta en turno 
            if(_Jugador.getNombre().equals(_Casilla.getsDueño()))
            {
                 JOptionPane.showMessageDialog(null, _Casilla.getNombre() + " es tuyo");
            }
            
            //no tiene dueño
            if (_Casilla.isbDueño() == false && posicion != 10 && posicion != 21) {
                //dependiendo de la desicion 
                dialogResult = JOptionPane.showConfirmDialog(null, _Casilla.getNombre() + " no tiene dueño, ¿Lo desea Comprar?", "Comprar", dialogButton);
                if (dialogResult == 0) {
                    
                    //valida si le alcanza para pagar
                    if(_Jugador.getSaldo() > _Casilla.getPrecio()){ 
                    //cambia los valores de la casilla y del saldo del jugaro
                    JOptionPane.showMessageDialog(null, "Se le descontaran Q. " + _Casilla.getPrecio());
                    double saldo = _Jugador.getSaldo() - _Casilla.getPrecio();
                    double valorPropiedades = _Jugador.getValorPropiedadoes() + _Casilla.getPrecio();
                    
                    _Casilla.setbDueño(true);
                    _Casilla.setsDueño(_Jugador.getNombre());
                    
                    matriz[posicion] = _Casilla;
                    
                    _Jugador.setSaldo(saldo);
                    _Jugador.setValorPropiedadoes(valorPropiedades);
                    }else{JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");}
                   
                   
                } else {
                    System.out.println("No");
                }

            }
            
           
            
             //casillas de la sat
            if (posicion == 10 || posicion == 21) {
                double aux = _Jugador.getValorPropiedadoes();

                if (aux > 0) {

                    //calcula el 10% de las propiedades para poder quitarslo al jugador
                    double impuesto = aux * _Casilla.getPrecio();
                    
                     //valida si le alcanza para pagar
                    if(_Jugador.getSaldo() > impuesto){ 
                     double saldo = _Jugador.getSaldo() - impuesto;

                    JOptionPane.showMessageDialog(null, "Se le descontaran Q. " + impuesto + " por impuestos");
                    _Jugador.setSaldo(saldo);
                    //si no le alcanza lo declara en bancarrota
                    }else{_Jugador.setBancarrota(true);}
                    
                   
                    
                } else {
                    double saldo = _Jugador.getSaldo() - 10;
                    JOptionPane.showMessageDialog(null, "Lo sentimos pero no tiene nada impuestos por lo que se le quitaran 10 por impuesto de pobreza");
                    _Jugador.setSaldo(saldo);
                }
            }

        }
         
        
    }
    
}
