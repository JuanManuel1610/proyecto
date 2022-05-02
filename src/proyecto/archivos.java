/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class archivos {
    
    private final String NomArch="Datos.txt";
    List<atributos> Datos = new ArrayList<>();
    public boolean verificaArch(){
        File archivo = new File(NomArch);
        if(!archivo.exists()) return false;
                else return true;
    }
    public boolean Grabar(List<atributos> Datos){
        
        try{
         FileWriter archivo = new FileWriter(NomArch,true);
         try(BufferedWriter bw = new BufferedWriter(archivo)){
             for(atributos dato : Datos){
                 bw.write(Conviertegson(dato) + "\n");
             }
             bw.close();
         }
         archivo.close();
        }catch(Exception ex){ return false; }
            
        
        return true;
        
    }
    
    public boolean Leer(){
        
        String cadena = "";
        try{
            FileReader archivo = new FileReader(NomArch);
            BufferedReader br = new BufferedReader(archivo);
            while((cadena = br.readLine()) != null){
                Datos.add (ConvierteClase(cadena));
            }
            br.close();
            archivo.close();
        }catch(Exception ex){return false;}
        return true;
    }
    public void agregar(atributos dato){
        Datos.add(dato);
    }
    
    private String Conviertegson(atributos dato){
        Gson gson = new Gson();
        return gson.toJson(dato);
    }
    private atributos ConvierteClase(String dato){
        Gson gson = new Gson();
        return gson.fromJson(dato, atributos.class);
    }
    
   public List<atributos> getDatos(){
       return Datos;
   }
    
    
   
}
