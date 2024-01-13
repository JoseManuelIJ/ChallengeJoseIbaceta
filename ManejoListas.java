import java.util.ArrayList;
import java.util.Random;

public class ManejoListas{
    //Se crea la lista con la cantidad de numeros indicados por el usuario, utilizando como valor maximo la variable tope.
    public static ArrayList<Integer> crearLista(int cantidadNumeros, int tope){
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        Random aleatorio= new Random();
        for(int i=0; i<cantidadNumeros; i++){
            arreglo.add(aleatorio.nextInt(tope+1));
        }
        return arreglo;
    }
    //Ordenamiento bubblesort
    //Obtenido de https://www.geeksforgeeks.org/bubble-sort/
    public static void bubblesort(ArrayList<Integer> arr){
        int i, j, temp;
        boolean swapped;
        int n=arr.size();
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1) ){
                     
                    // Swap arr[j] and arr[j+1]
                    temp = arr.get(j);
                    arr.set(j,arr.get(j+1));
                    arr.set(j+1,temp);
                    swapped = true;
                }
            }
 
            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    //Ordenamiento bubblesort.
    //Obtenido de https://www.geeksforgeeks.org/insertion-sort/
    public static void insertionSort(ArrayList<Integer> arr){
        int i, key, j;
        int n=arr.size();
        for (i = 1; i < n; i++) {
            key = arr.get(i);
            j = i - 1;
    
            // Move elements of arr[0..i-1],
            // that are greater than key, 
            // to one position ahead of their
            // current position
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1,key);
        }
    }
}