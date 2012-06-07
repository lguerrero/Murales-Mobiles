package algoritmoGuayasamin;
import java.util.ArrayList;
//import java.util.List;

public class Prueba2 {

	/**
	 * @LuisGuerrero
	 * Algoritmo Guayasamin
	 */
	public static void main(String[] args) {
		
		System.out.println("inicio");
		
		Permutaciones palabra = new Permutaciones();  		//declaracion e inicializacion de objeto de la clase Permutaciones3 
		Combinatorias combinar;									//declaracion de objeto de la clase Combinatorias1
		SubconjuntosZ subconjuntos = new SubconjuntosZ(); 	//declaracion e inicializacion de objeto de la clase SubconjuntosZ
		ArrayList<String> numeros = new ArrayList<String>();//Arreglo que almacena los giros de cada cuadro
		ArrayList<String> cad = new ArrayList<String>();    //Arreglo que almacena los cuadros
		int ciclos=0;										//variable que contara los ciclos
		
		String cadena = "ABC"; 		//Esta variable despues se modifica por ABCDEF para los 6 cuadros
		palabra.Permutacion("",cadena); //llamada a primer metodo Permutacion 
		
		numeros.add("1"); 				//Agregando elementos al ArrayList 
		numeros.add("2"); 
		numeros.add("3"); 
		numeros.add("4"); 
		
		System.out.println("Permutaciones: " + palabra.permutacion + " Total: " + palabra.getTotalPermutaciones()); //se imprime el total de permutaciones
		
		for(int j=0; j < palabra.permutacion.size(); j++){ 
			
			char[] caracter = palabra.permutacion.get(j).toCharArray(); //elemento en la posicion j es separado y agregado por caracteres al arreglo caracter  
			//System.out.println(caracter); 	// imprimo las permutaciones que se le van asignado al arreglo
			int n = caracter.length;      		// n = al largo del arreglo caracter
			char tmp = '0';				  		// se inicializa tmp con un valor cualquiera	
			
			for (int i=0; i<n; i++){ 
				tmp = caracter[i]; 				//elemento en la posicion i se asigna a tmp  
				cad.add(String.valueOf(tmp));	//se transforma a string y se agrega al arreglo cad
			}
			
			combinar = new Combinatorias(); 			//se inicializa con el constructor por defecto
			combinar.Combinar(cad, numeros);			//metodo de la clase Combinatorias1 que genera los grupos ej[A1,A2,A3,A4]
		
			subconjuntos = new SubconjuntosZ(combinar.contenedor); //se inicializa con el constructor(List<Objetos[]> o)
			
			cad.clear();						//se remueven todos los elementos del arreglo cad, para poder agregarle la sig. permutacion
			ciclos=j+1;										
			System.out.println("Ciclo Numero: " + ciclos); //imprimo el numero de ciclos generados
		}//Permutar las 6 soluciones 
		
		System.out.println("Total de Soluciones: " + subconjuntos.getTotalCombination() * palabra.getTotalPermutaciones()); //total de soluciones generadas
		System.out.println("fin"); //da el fin del algoritmo
	}//fin main
		
}//fin prueba2
