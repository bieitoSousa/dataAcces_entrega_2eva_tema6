/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimointento;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author bieito
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) throws IOException {
        
       
        
        
       AccesoDatos ac = new AccesoDatos ();
       
       
       
       Tienda t = new Tienda(ac);
        System.out.println(" Tienda abierta ");
       Fecha f = new Fecha();
        System.out.println(" Poniendo fecha");
       Ticket tck = new Ticket(ac,t);
        System.out.println(" cargando maquina de tickets");
    
       
       int op = 0;
do {
     
    t.mostarCodigos();
   
    t.mostarHistorico();
    
    
    
    op =t.menu(); 
	switch (op){

            case 1 : // mostrar ticket
                 tck.RealizarticketStream();
                 break;
				
            case 2 : 
                
                t.meterVentasEnArrayHistorico();
                t.mostarHistorico();
                ac.actualizarFicheroHistorico(t);

                
                break;
            case 3 : // salir
		break;

}
    }while(op!=3);
    
}
}


       
       
    
 
    

