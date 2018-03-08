/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimointento;

/**
 *
 * @author bieito
 */
public class Codigo {
    public String  codigo ;
    public int  precio ;

        Codigo (String  codigo,int  precio){
        this.codigo=codigo;
        this.precio=precio;
        }
        @Override
        public String toString(){
        return  "Codigo : " + codigo + "precio " + precio ;
        }

} 


