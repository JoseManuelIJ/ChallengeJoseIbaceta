import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ManejoArchivos {
    //Se genera el archivo con los numeros aleatorios. Los parametros corresponden a la cantidad de numeros que tendra y el valor limite.
    public static void GenerarArchivo(String nombreArchivo, ArrayList<Integer> lista){
        Scanner ingresoConsola= new Scanner(System.in);
        File archivo= new File(nombreArchivo);
        try{
            //Variables asociadas al archivo.
            archivo.createNewFile();                
            FileWriter escrituraLista = new FileWriter(archivo);
            BufferedWriter bufferLista = new BufferedWriter(escrituraLista);
            //lista de numeros al azar.
            //Escritura.
            for( int i=0; i<lista.size(); i++){
                bufferLista.write(lista.get(i)+"\n");
            }
            bufferLista.close();
            System.out.println("Archivo generado exitosamente.\n");
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al generar el archivo.\n");
            e.printStackTrace();
        }
    }
    //Se obtienen los datos del archivo solicitado por el usuario.
    public static ArrayList<Integer> lecturaArchivo(String nombreArchivo){
        ArrayList<Integer> contenido=new ArrayList<Integer>();
        try{
            FileReader lecturaArchivo = new FileReader(nombreArchivo);
            BufferedReader bufferArchivo = new BufferedReader(lecturaArchivo);
            
            String valor;
            while((valor=bufferArchivo.readLine())!=null){
                contenido.add( Integer.parseInt(valor));
            }
            bufferArchivo.close();
        }
        catch(Exception e){
            System.out.println("Archivo no encontrado. Recuerde generar un archivo con la opcion 1.\n");
        }
        return contenido;
    }
}
