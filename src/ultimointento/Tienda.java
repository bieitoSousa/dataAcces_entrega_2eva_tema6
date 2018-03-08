/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimointento;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bieito
 */
public class Tienda {
    
Scanner sc = new Scanner(System.in); 

public Codigo [] cd = crearCodigos();

public Historico [] historico = crearHistorico();

public AccesoDatos ac ;


Tienda(AccesoDatos ac){

this.ac=ac;}

Codigo [] crearCodigos() {
    System.out.println("hola");
Codigo [] cd = new Codigo [11];
String [] codigo = new String [11];
int [] precio = new int [11];
//llenar los arrays con datos
    for (int i=0;i<11;i++){
                String a = " abcdefghij";
                String b = "00123456789";
                codigo [i]= a.substring(i,i+1) ;
                precio[i]= Integer.parseInt(b.substring(i, i+1)) ;
    }
//crear el objeto codigo
    for (int i=0;i<cd.length;i++ ){
         cd [i]= new Codigo ( codigo[i] , precio[i] );
    }
    System.out.println("finaliz");
return cd ;

}




Historico [] crearHistorico() {

Historico [] his = new Historico [11];
    System.out.println("23456789");
    /***
if (ac.fhistorico.exists()){
    System.out.println("eeeeeeeeeerrrrooorrr");
    for (int i=0;i<his.length;i++){
        try {
            his[i]= ac.LeerHistorico();
        } catch (IOException ex) {
            System.out.println("fallo");
        }
}
}else{
  */  
    
    System.out.println("acacccccccccc");
String [] codigo = new String [11];
int [] historico = new int [11];


for (int i=0;i<cd.length;i++ ){
his [i]= new Historico ( codigo[i] , 0 );

}
/*}*/
return his;

}

void SumarHistorico (String histadd){
for ( int i=0 ; i>historico.length;i++){
if (historico[i].codigo.equals(histadd)){
historico[i].historico++;
}
}



}

void mostarCodigos ( ){
for (int i=0;i<cd.length;i++ ){
cd [i].toString(); 
}}



/**
* recoje un String  y optine Codigo
*
*
*/

Codigo codigoExists(String a) {

Codigo aux =null;

	for (int i=0;i<this.cd.length;i++ ){
		if (this.cd[i].codigo.equals(a)){
			aux =cd[i];
			
		} 
	}

return aux;
}

    int menu() {
        
        System.out.println("------------------------");
        System.out.println("Seleccione :");
        System.out.println("1.- Inicio de venta ");
        System.out.println("2.- Caja");
        System.out.println("3.- Salir");
        System.out.println("------------------------");
        int out =Integer.parseInt(sc.nextLine());
     return out;
    }
}
