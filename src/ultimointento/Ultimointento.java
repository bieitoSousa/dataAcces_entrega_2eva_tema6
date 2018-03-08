/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimointento;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bieito
 */
public class Ultimointento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
System.out.println(" comenzar ...");
AccesoDatos ac = new AccesoDatos(); 
Tienda t = new Tienda(ac);
System.out.println(" a ...");
System.out.println(ac.urlpath);

 System.out.println(" b ...");
//muestra el codigo y el precio
t.mostarCodigos(); // te muestra los Codigos
int op = 0;
do {
    
    t.mostarCodigos();
    t.mostarHistorico();
    
		 op =t.menu(); 

		switch (op){

				case 1 : // mostrar ticket
                                    System.out.println("Empezamos el Ticket");
					Ticket tck = new Ticket(ac,t);// creamos un ticket y le damos acceso a Accesoatos para que guarde los datos;
					tck.RealizarticketStream();// pide los datos y los guara en un stream os va mostrando;
                                        tck.mostrar(); 					
				break;
				
				case 2 : 
                   
                         // guardar datos en el fichero
                      
				break;
				
				
				case 3 : // salir
				break;

}
    }while(op!=3);
    
}
}
