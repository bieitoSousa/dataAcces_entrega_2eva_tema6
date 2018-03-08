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
    Codigo [] cd = t.cd;
    int importe ;
    int dia = fecha.getintDia();
    int mes = fecha.getintMes();
    int ano = fecha.getintAno();

	Ticket(AccesoDatos ac, Tienda t) {
	this.ac = ac;
        this.t = t;
	
	
	}

	public void RealizarticketStream(){
            String cdtxt = "" ;
		do { 
			System.out.println("introuce el codigo [-1 para salir ]");
				cdtxt = sc.nextLine();
				if (t.codigoExists(cdtxt)!= null){
					Codigo cd = t.codigoExists(cdtxt);
					this.importe = this.importe +cd.precio;
                            try {
                                ac.addStrim(cd.codigo ,cd.precio,dia,mes,ano);
                            } catch (IOException ex) {
                                
                            }
                                            Venta v = null;   
                                                        do{  
                                                             try{    
                                                                 v=ac.recorrerString();
                                                                 v.toString();
                                                           } catch (FileNotFoundException ex) {
                                                               System.out.println("ha fallado ...");;
                                                           }
                                                      }while(v != null);
						
				}

		}while(Integer.parseInt(cdtxt) != -1 );

	}


	void mostrar(){
	
		System.out.println ("========================");
		
			ac.mostrarStream();
			System.out.println ("Total : ___"+importe+"___");
		
		System.out.println ("=========================");
		
	
	
	} 
	
	
	
}

