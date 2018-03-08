/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimointento;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
	
	void addStrim(String codigo ,int precio,int dia,int mes,int ano) throws IOException{
            this.fcodigo.createNewFile();
            
            DataOutputStream fc=null;
            try {
                fc=new DataOutputStream(new FileOutputStream(fcodigo,true));
                try {
                    fc.writeUTF(codigo);
                    fc.writeByte(precio);
                    fc.writeByte(dia);
                    fc.writeByte(mes);
                    fc.writeByte(ano);
                    } catch (IOException ex) {
                     System.out.println("No se ha podido escribir en el Fichero");   }

            } finally {
                if (fc!=null) fc.close();
            }

	}	

        
     private Venta readVenta(DataInputStream fr) {
         Venta v = null;
        try {
                 String codigo = fr.readUTF();
                 int precio= fr.readByte();
		 int dia= fr.readByte();
		 int mes =fr.readByte();
		 int ano =fr.readByte();
                  
                v= new Venta(codigo,precio,dia,mes,ano); 
                 
             } catch (IOException ex) {
                 System.out.println("no se ha podido leer el archivo de codigos");
             }
     return v;
     }    
        
        
    Venta recorrerString() throws FileNotFoundException {
        
        
         DataInputStream fr =null;
            fr=new DataInputStream(new FileInputStream(fcodigo));
            
        Venta v=null;
              
        if (fr==null) fr=new DataInputStream(new FileInputStream(fcodigo));
            try {
                if (fr.available()>0) v=readVenta(fr);
                else {
                    try {
                        fr.close();
                        fr=null;
                    } catch (IOException ex) {
                        System.out.println("no se ha podido cerrar el archivo");
                    }
                }   } catch (IOException ex) {
                Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return v;
    }   
                 
       void mostrarStream(){
      Venta v = null;   
            do{  
                 try{    
                     v=recorrerString();
                     v.toString();
               } catch (FileNotFoundException ex) {
                   System.out.println("ha fallado ...");;
               }
          }while(v != null);
						
				}

    
     void escribirHistorico(Historico h) throws IOException {
         this.fhistorico.createNewFile();
        DataOutputStream oos=null;
        DataInputStream ois=null;

        
        try {
                oos=new DataOutputStream(new FileOutputStream(this.fhistorico)); // Escribimos no novo
                    oos.writeUTF(h.codigo);
                    oos.write(h.historico);  
                // Non estaba no histórico, necesitamos procesar a venta
                } catch (IOException ex) {
                    
                    System.out.println("Produciuse un erro, non se procesou o arquivo.");

        } finally {
            if (oos!=null) oos.close();
            if (ois!=null) ois.close();
        }
    
     }
         Historico LeerHistorico() throws IOException {
        DataOutputStream oos=null;
        DataInputStream ois=null;
        
        Historico h = null;

        
        try {
                oos=new DataOutputStream(new FileOutputStream(this.fhistorico)); // Escribimos no novo
                String cod = ois.readUTF();
                int hist = ois.read();
                h=new Historico(cod,hist); 
                // Non estaba no histórico, necesitamos procesar a venta
                } catch (IOException ex) {
                    System.out.println("Produciuse un erro, non se procesou o arquivo.");
                     
                
        } finally {
            if (ois!=null) ois.close();
        }
     return h;  
     }
    
    
    
}