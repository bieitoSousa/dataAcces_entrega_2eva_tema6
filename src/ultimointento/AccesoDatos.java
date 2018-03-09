/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimointento;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bieito
 */
public class AccesoDatos {

     
    
	final String urlpath = "C:\\Users\\bieito\\Documents\\temp\\Java";
	final String urlcodigo = urlpath+"codigo.dat";
	final String urlhistorico = urlpath+"historico.dat";
	
	final File fcodigo = new File (urlcodigo);
	final File fhistorico = new File (urlhistorico);
	final File fpath = new File (urlpath);
	
	AccesoDatos(){
        fpath.mkdirs();
        }
 //-------------------------------------Fin de Paquete de Paquete VENTAS ------------------------------------------------------///     	
	void addStrim(String codigo ,int precio,int dia,int mes,long ano) throws IOException{
            this.fcodigo.createNewFile();
            
            DataOutputStream fc=null;
            try {
                fc=new DataOutputStream(new FileOutputStream(fcodigo,true));
                try {
                    //System.out.println("Escribiendo datos en el  Stream");
                    fc.writeUTF(codigo);
                    //System.out.println("Escribe string codigo "+codigo);
                    fc.writeByte(precio);
                    //System.out.println("Escribe int precio "+precio);
                    fc.writeByte(dia);
                    //System.out.println("Escribe int dia "+dia);
                    fc.writeByte(mes);
                    //System.out.println("Escribe int mes "+mes);
                    fc.writeLong(ano);
                    //System.out.println("Escribe int ano "+ano);
                    } catch (IOException ex) {
                     System.out.println("No se ha podido escribir en el Fichero");   }

            } finally {
                if (fc!=null) fc.close();
            }

	}	


 Venta mostrarStream() throws IOException {
      DataInputStream fr = null;
       Venta v=null;
       int total=0;
       try {    
                fr = new DataInputStream(
                        new FileInputStream( fcodigo));
            while (true) {
                        
                String codigo = fr.readUTF();
                //System.out.println("leo codigo "+codigo);
                int precio = fr.readByte();       // Elimina el tab
                //System.out.println("leo precio "+precio);
                int dia = fr.readByte();
                //System.out.println("leo dia "+dia);
                 int mes = fr.readByte();       // Elimina el tab
                //System.out.println("leo dia "+mes);
                 long ano = fr.readLong();
                //System.out.println("leo dia "+ano); 
                  v = new Venta(codigo,precio,dia,mes,ano);
                  System.out.println(v.toString());
                //System.out.println(codigo +"---"+precio+"---"+"---"+dia+"---"+mes+"---"+ano);
                //System.out.println(v.toString()); 
                total= total+v.precio; 
            }   
            
            
            
         } catch (EOFException e) {
             System.out.println("total : "+total);   
         } catch (FileNotFoundException ex) {
         } catch (IOException ex) { 
         }finally { fr.close();} 			
		return v;		}
           
           
           
  Venta actualizarhistoricosconventas(Tienda t) throws IOException {
      DataInputStream fr = null;
       Venta v=null;
       int total=0;
       try {    
                fr = new DataInputStream(
                        new FileInputStream( fcodigo));
            while (true) {
                        
                String codigo = fr.readUTF();
                //System.out.println("leo codigo "+codigo);
                int precio = fr.readByte();       
                //System.out.println("leo precio "+precio);
                int dia = fr.readByte();
                //System.out.println("leo dia "+dia);
                 int mes = fr.readByte();       
                //System.out.println("leo dia "+mes);
                 long ano = fr.readLong();
                //System.out.println("leo dia "+ano); 
                  v = new Venta(codigo,precio,dia,mes,ano);
                  t.actualizaHistorico(v.codigo);       
                //System.out.println(codigo +"---"+precio+"---"+"---"+dia+"---"+mes+"---"+ano);
                //System.out.println(v.toString()); 
               
            }   
            
            
            
         } catch (EOFException e) {
             System.out.println("total : "+total);   
         } catch (FileNotFoundException ex) {
         } catch (IOException ex) { 
         }finally { fr.close();} 			
		return v;		}    
           
    //-------------------------------------Fin de Paquete de Paquete VENTAS ------------------------------------------------------///       

    void actualizarFicheroHistorico(Tienda t) throws IOException {
        escribirHistorico(t);
        System.out.println("========================= SE HA ESCRITO hISTORICO");
        leerHistorico(t);
        System.out.println("========================= SE HA LEIDO hISTORICO");
    }
    
    void escribirHistorico(Tienda t) throws IOException{
    int z = 0; 
            this.fhistorico.delete();
            this.fhistorico.createNewFile(); 
        for ( int i=0 ; i<t.historico.length;i++){
            DataOutputStream fc=null;
            try {
                fc=new DataOutputStream(new FileOutputStream(this.fhistorico,true));
                try {
                    //System.out.println("Escribiendo datos en el Historico");
                   
                    fc.writeUTF(t.historico[i].codigo);
                    System.out.println("Escribe string codigo "+t.historico[i].codigo);
                    fc.writeByte(t.historico[i].historico);
                    System.out.println("Escribe int historico "+t.historico[i].historico);
                    } catch (IOException ex) {
                     System.out.println("No se ha podido escribir en el Fichero");   }

            } finally {
                if (fc!=null) fc.close();
            }
      }   
    } 
    
    
    
    public Historico [] leerHistorico(Tienda t) throws IOException{
        int z =0;
        Historico [] h = new Historico[11];
      
      DataInputStream fr = null;
     
      Venta v=null;
      
       try {  
            
           fr = new DataInputStream(
          new FileInputStream( this.fhistorico));
           System.out.println("historico length vale : "+t.historico.length);
           for ( int i=0 ; i<t.historico.length;i++){ 
           
                String str = fr.readUTF();             
                System.out.println("leo codigo "+str);
                int p = fr.readByte(); 
                System.out.println("leo historico "+p);
                
                //t.historico[i].historico = t.haux[i].historico = p ;
                //t.historico[i].codigo= t.haux[i].codigo = str;           
                h[i]=new Historico (str,p);
            }   
         } catch (EOFException e) {
             
         } catch (FileNotFoundException ex) {
         } catch (IOException ex) { 
         }finally { fr.close();} 			
		
        return h ;
    

    
    
}
}