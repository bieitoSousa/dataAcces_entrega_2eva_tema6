/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimointento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bieito
 */
public class Ticket {
    Scanner sc 	= new Scanner(System.in); 
    AccesoDatos ac;
    Tienda t;
    Fecha fecha = new Fecha();
    Codigo [] cd = new Codigo [11];
    int importe ;
    int dia = fecha.getintDia();
    int mes = fecha.getintMes();
    int ano = fecha.getintAno();

	Ticket(AccesoDatos ac, Tienda t) {
	this.ac = ac;
        this.t = t;
	this.cd = t.cd;
	
	}

	public void RealizarticketStream(){
            String cdtxt = "" ;
            Venta v = null;
		do { 
			System.out.println("introuce el codigo [-1 para salir ]");// mensage por pantalla
				cdtxt = sc.nextLine(); // cojo la entrada por taclado

				if (t.codigoExists(cdtxt)){// verifico si el codigo coincide 
                                    Codigo cd = t.EncontrarCodigo(cdtxt); // si sirve lo guardo
                                    try {
                                        ac.addStrim(cd.codigo ,cd.precio,dia,mes,ano); // lo meto en un stream
                                        v =ac.mostrarStream();
                                    } catch (IOException ex) {
                                    }
                                      	

                                
                                       }
                                             

                    }while(!(cdtxt.equals("-1")) );


	
		
	
	
	} 
	
}
	


