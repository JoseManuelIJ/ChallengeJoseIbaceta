import java.util.ArrayList;
import java.util.Scanner;

public class App {    
    public static void main(String[] args){
        int opcion=0;
        while (true) {            
            //Se obtiene la eleccion del usuario
            opcion= eleccion();
            if (opcion != -1){
            //se crea una lista con una cantidad de numeros designados por el usuario.
            if (opcion==1){
                opcion1();
                if (!continuar()){
                    cerrar();
                }
            }
            //Se lee el ultimo archivo generado sin ordenar.
            else if(opcion==2){
                if (opcion2()){
                    if (!continuar()){
                        cerrar();
                    }
                }
                
            }
            //Se utiliza un algoritmo de ordenamiento a eleccion sobre el ultimo archivo generado.
            else if (opcion==3) {
                if (opcion3()){
                    if (!continuar()){
                        cerrar();
                    }
                }
            }
            //Se lee el archivo ordenado.
            else if (opcion==4){
                if (opcion4()){
                    if (!continuar()){
                        cerrar();
                    }
                }
            }
            //Se busca un numero dentro de los archivos.
            else if (opcion==5){
                if (opcion5()){
                    if (!continuar()){
                        cerrar();
                    }
                }
            }
            else if (opcion==6){
                cerrar();
            }
            }
        }
        
    }
    //Funcion para desplegar el texto del menu
    public static void menu() {
        System.out.println(
            "Opciones \n0 - Menu\n"+
            "1 - Genera nuevo archivo\n"+
            "2 - Lee archivo generado\n"+
            "3 - Ordena archivo\n"+
            "4 - Lee archivo ordenado\n"+
            "5 - Buscar número en archivo\n"+
            "6 - Salir\n"+
            "Seleccione una opción : ");
        
    }
    //Se obtiene la eleccion del usuario, siendo los valores validos un número entre el 0 y 6. Si retorna -1, la opcion no es valida.
    public static int eleccion(){
        //Se muestra el menu por pantalla.
        menu();
        int opcion=0;
        Scanner ingresoConsola= new Scanner(System.in);
        try{
        
        opcion= ingresoConsola.nextInt();
        if(opcion < 1 || opcion > 6 ){
            System.out.println("Ingrese una opción valida.\n");
            return -1;
        }

        }
        catch(Exception e){
            System.out.println("Ingrese una opción valida.\n");
            return -1;
        }
        return opcion;
    }
    //Se genera el archivo con los parametros elegidos por el usuario.
    public static void opcion1(){
        int cantidadNumeros=0;
        int tope=0;
        //Se asigna la cantidad de numeros a generar en el archivo.            
        while(true){
            Scanner ingresoConsolaCN= new Scanner(System.in);
            try{
                System.out.println("Ingrese la cantidad de números para el archivo:\n");
                cantidadNumeros=ingresoConsolaCN.nextInt();
                if(cantidadNumeros>0){
                    break;
                }
                else{
                    System.out.println("Valor invalido, ingrese nuevamente.");
                }
            }
            catch(Exception e){
                System.out.println("Valor invalido, ingrese nuevamente.");
            }
        }
        //Se asigna el valor maximo.
        while(true){
            Scanner ingresoConsolaTope= new Scanner(System.in);
            try{
                System.out.println("Ingrese el valor maximo que puede tener el archivo:\n");
                tope=ingresoConsolaTope.nextInt();
                if(tope>0){
                    break;
                }
                else{
                    System.out.println("Valor invalido, ingrese nuevamente.");
                }
            }
            catch(Exception e){
                System.out.println("Valor invalido, ingrese nuevamente.");
            }
        }
        //Se genera el archivo solicitado.
        ArrayList<Integer> listaAzar= ManejoListas.crearLista(cantidadNumeros, tope);
        ManejoArchivos.GenerarArchivo("Secuencia.txt", listaAzar);
    }
    //Se lee el archivo especificado por el usuario y se despliegan las posiciones y el contenido del mismo.
    public static boolean opcion2(){
        ArrayList<Integer> contenidoArchivo= ManejoArchivos.lecturaArchivo("Secuencia.txt");
        if(contenidoArchivo.size()==0){
            return false;
        }
        for (int i =0; i<contenidoArchivo.size();i++){
            System.out.println("Pos"+(i+1)+" - "+ contenidoArchivo.get(i));
        }
        return true;
    }
    //Se ordena la lista creada previamente por el usuario.
    public static boolean opcion3(){
        ArrayList<Integer> contenidoArchivo= ManejoArchivos.lecturaArchivo("Secuencia.txt");
        //Se comprueba si el archivo fue previamente creado.
        if (contenidoArchivo.size()==0){
            return false;
        }
        int respuesta;
        long tiempoEjecucion,inicio,fin;
        //Se revisa que la opcion del usuario este dentro de los parametros deseados: 1 o 2.
        while(true){
            try{
                System.out.println("Seleccione el metodo a utilizar:.\n1: Ordenamiento de burbuja\n2: Ordenamiento por inserción.");
                Scanner ingresoConsola= new Scanner(System.in);
                respuesta= ingresoConsola.nextInt();
                //Se ordena el conjunto utilizando bubblesort y se revisa el tiempo que toma.
                if(respuesta == 1){
                    inicio = System.currentTimeMillis();
                    ManejoListas.bubblesort(contenidoArchivo);
                    fin = System.currentTimeMillis();
                    break;
                }
                //Se ordena el conjunto utilizando insertionsort y se revisa el tiempo que toma.
                else if(respuesta==2){
                    inicio = System.currentTimeMillis();
                    ManejoListas.insertionSort(contenidoArchivo);
                    fin = System.currentTimeMillis();
                    break;
                }
                else{
                    System.out.println("Valor invalido, ingrese nuevamente.");
                }
            }
            catch(Exception e){
                System.out.println("Valor invalido, ingrese nuevamente.");
            }
            
        }
        //Se escribe el archivo con la lista ordenada.
        ManejoArchivos.GenerarArchivo("SecuenciaOrdenada.txt", contenidoArchivo);
        tiempoEjecucion=fin-inicio;
        System.out.println("El tiempo que demoro en orderarse es de: "+tiempoEjecucion+"ms\n");
        return true;
    }
    public static boolean opcion4(){
        ArrayList<Integer> contenidoArchivo= ManejoArchivos.lecturaArchivo("SecuenciaOrdenada.txt");
        //Se comprueba si el archivo fue previamente creado.
        if (contenidoArchivo.size()==0){
            return false;
        }
        for (int i =0; i<contenidoArchivo.size();i++){
            System.out.println("Pos"+(i+1)+" - "+ contenidoArchivo.get(i));
        }
        return true;
    };
    public static boolean opcion5(){
        ArrayList<Integer> contenidoArchivo= ManejoArchivos.lecturaArchivo("Secuencia.txt");
        ArrayList<Integer> contenidoArchivoOrdenado= ManejoArchivos.lecturaArchivo("SecuenciaOrdenada.txt");
        //Se verifica que exista un archivo con los numeros generados.
        if(contenidoArchivo.size()==0){
            System.out.println("Es necesario generar una secuencia de números para usar esta opción.\n");
            return false;
        }
        int valor;
        Scanner ingresoConsola= new Scanner(System.in);
        //Se obtienne un valor valido para buscar en los archivos.
        while(true){
            System.out.println("Ingrese el numero que desee encontrar:\n");
            try{        
                valor= ingresoConsola.nextInt();
                if(valor<0){
                    System.out.println("Ingrese una opción valida.\n");
                }
                else{
                    break;
                }        
                }
                catch(Exception e){
                    System.out.println("Ingrese una opción valida.\n");
                }
        }
        //Se verifica que el numero se encuentre en cualquiera de los archivos.
        int indiceArchivo=contenidoArchivo.indexOf(valor);
        if (indiceArchivo==-1){
            System.out.println("No se encuentra el número buscado.");
            return true;
        }
        else{
            System.out.println("En el archivo original, el valor se encuentra en la posicion: "+ (indiceArchivo+1)+"\n");
        }
        //Se comprueba que se ordenara antes el archivo.
        int indiceArchivoOrdenado;
        if(contenidoArchivoOrdenado.size()>0){
            indiceArchivoOrdenado=contenidoArchivoOrdenado.indexOf(valor);
            System.out.println("En el archivo ordenado, el valor se encuentra en la posicion: "+ (indiceArchivoOrdenado+1)+"\n");
        }
        return true;
    }
    public static boolean continuar(){
        System.out.println("Si no desea seguir usando el programa ingrese 'cerrar'. Para continuar ingrese cualquier valor distinto.\n");
        Scanner ingresoConsola= new Scanner(System.in);
        String respuesta= ingresoConsola.nextLine();
        if (respuesta.equals("cerrar")){
            return false;
        }
        return true;
    }
    public static void cerrar(){
        System.out.println("Gracias por utilizar esta aplicación, tenga un buen día.");
        System.exit(0);
    }
}