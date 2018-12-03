package principal;

import com.compi2.usac.analizadores.Lexico;
import com.compi2.usac.analizadores.Parser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author Elmer Alay
 * @version 1.0
 * @since   03-12-2018
 */
public class Main {
    
    public static void main(String args[]){
        try{
           String lectura = lecturaArchivo("C:\\Users\\junio\\Desktop\\ejemplo.txt");
           //System.out.println("Esta es la lectura \n " + lectura);
           ejecutar(lectura);
       }catch(Exception ex){
           
       }
    }
    
    public static String  lecturaArchivo(String archivo) throws FileNotFoundException, IOException{
        String cadena;
        String auxcadena = "";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        while((cadena = b.readLine()) != null){
            auxcadena = auxcadena + cadena+ "\n";
        }
        
        return auxcadena;
    }
    
    public static void ejecutar(String entrada){
        try {   
        Lexico lexer = new Lexico(new StringReader(entrada));
        Parser parser = new Parser(lexer);
        parser.parse();
        } catch (Exception e) {
            System.out.println("Error de tipo: " + e.getMessage());
        }
    }
    
}
