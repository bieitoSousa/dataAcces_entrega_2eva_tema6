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

public Codigo [] cd = new Codigo[11];

public Historico [] historico = new Historico[11];

public Historico [] haux = new Historico[11];

public AccesoDatos ac ;


Tienda(AccesoDatos ac){

this.ac=ac;
crearCodigos();
    System.out.println("se han creado los codigos");
crearHistorico();
    System.out.println("se ha creado el historico");
}

void crearCodigos() {
 System.out.println("creando historicos");   
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
         this.cd[i]= new Codigo ( codigo[i] , precio[i] );
    }
   


}
void crearHistoriacoaux(){
System.out.println("historico ---empezar camino historicso desde 0");
            String [] codigo = new String [11];
            int [] historico = new int [11];
            for (int i=0;i<cd.length;i++ ){
            this.haux[i]= new Historico ( this.cd[i].codigo ,0 );}

}





 void crearHistorico() {
    System.out.println("creando historicos");
    try {
        System.out.println("exists devuelve un "+ac.fhistorico.exists());
        System.out.println("length devuelve un "+ac.fhistorico.length());
        if (!(ac.fhistorico.exists())|(ac.fhistorico.length()<4)){
            System.out.println("historico ---empezar camino historicso desde 0");
            String [] codigo = new String [11];
            int [] historico = new int [11];
            for (int i=0;i<cd.length;i++ ){
            this.historico[i]= new Historico ( this.cd[i].codigo ,0 );
            }
        }else{
            System.out.println("historico ---empezar camino leer historicos del fichero");
       this.historico = ac.leerHistorico(this);
             System.out.println("historico ---fin camino leer historicos del fichero");}
    } catch (IOException   ex) {
        //creo uno vacio    
           
    }
}



void SumarHistorico (String histadd){
for ( int i=0 ; i>historico.length;i++){
if (historico[i].codigo.equals(histadd)){
historico[i].historico++;
}
}



}

void mostarCodigos ( ){
        System.out.println("===============   CODIGOS  ====================");
for (int i=0;i<cd.length;i++ ){
    System.out.println(cd[i].toString() );
} System.out.println("===============   FIN CODIGOS  ====================");
}


void mostarHistorico ( ){
    System.out.println("===============   HISTORICO  ====================");
for (int i=0;i<this.historico.length;i++ ){
    System.out.println(this.historico[i].toString());

}

 System.out.println("===============   FIN HISTORICO  ====================");
}

/**
* recoje un String  y optine Codigo
*
*
*/

Codigo EncontrarCodigo(String a) {

Codigo aux =null;

	for (int i=0;i<this.cd.length;i++ ){
		if (this.cd[i].codigo.equals(a)){
			aux =cd[i];
			
		} 
	}

return aux;
}


boolean codigoExists(String a) {

boolean aux =false;

	for (int i=0;i<this.cd.length;i++ ){
		if (this.cd[i].codigo.equals(a)){
			aux =true;
			
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

    void actualizaHistorico(String codigo) {
        
      for(int i =0;i<this.historico.length;i++ )  
       if (this.historico[i].codigo.equals(codigo)){ 
        this.historico[i].historico++;
       }
    }

    void meterVentasEnArrayHistorico() throws IOException {
        System.out.println("1");
        ac.actualizarhistoricosconventas(this);
        System.out.println("fin");
       
    }

    
  
}
